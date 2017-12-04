package com.oyo.search.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code ParseSysLogUtil} class represents log parser.
 */
public class ParseSysLogUtil {

	/**
	 * Removes {@literal Timestamp} from the given {@code String} message.
	 * @param tuple
	 * @return
	 */
	public static String getParsedResponse(String tuple) {
		//String rx = "^[A-Za-z]{3,6}\\s*\\d{1,2}\\s*\\d\\d:\\d\\d:\\d\\d ip\\-\\d{1,3}\\-\\d{1,3}\\-\\d{1,3}\\-\\d{1,3} [A-Za-z_-]+\\[\\d{1,100}\\]:\\s*";
		/**
		 * Regex for removing unused log data in format - "log_level_first_char, [Timestamp(yyyy-mm-ddThh:mm:ss.ddddd) #ddddd] Log_level -- : " 
		 */
		String rx = "^[A-Za-z]{1}\\,\\s*\\[\\d{1,4}\\-\\d{1,4}\\-\\d{1,4}T\\d{2}:\\d{2}:\\d{2}.\\d*\\s*#*\\d*]\\s*[A-Za-z]{3,6}\\s--\\s:\\s";
		Pattern ptrn = Pattern.compile(rx);
		Matcher m = ptrn.matcher(tuple);

		if (m.find()) {
			tuple = tuple.replace(m.group(0), "");
		}
		return tuple;
	}
}
