package com.oyo.search.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.newrelic.api.agent.Trace;
import com.oyo.search.constants.Constants;
import com.oyo.search.pojo.TriggerDataModel;
import com.oyo.search.util.TransformUtil;

/**
 * The {@code SearchTriggerListener} represents listener for
 * search hotels service {@literal Topic}.
 */
@Service
@ConditionalOnProperty("kafka.enabled")
public class SearchTriggerListener {

	private static final Logger log = LoggerFactory.getLogger(SearchTriggerListener.class);

	private TriggerDataModel triggerDataModel;

	@Trace(dispatcher = true)
	@KafkaListener(topics = "search_htl")
	public void receiveMessage(String kafkaMessage) {
		log.info("KafkaConsumerService: Message received: {}", kafkaMessage);
		System.out.println("KafkaConsumerService: Message received: " + kafkaMessage);
		try {
			kafkaMessage = ParseSysLogService.getParsedResponse(kafkaMessage);
			System.out.println("KafkaConsumerService: Message processed: " + kafkaMessage);
			triggerDataModel = (TriggerDataModel) TransformUtil.fromJson(kafkaMessage, TriggerDataModel.class);
		} catch (Exception e) {
			log.info("KafkaConsumerService: KafkaListener:- {} for data {} with error message {}",
					Constants.JSON_PARSE_ERROR, kafkaMessage, e.getStackTrace());
			return;
		}
		System.out.println("Message processed : " + triggerDataModel.toString());

	}

}
