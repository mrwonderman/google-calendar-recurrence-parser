package ch.halcyon.java.recurrenceparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

public class RecurrenceParser {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMdd'T'HHmmss");

	public static RecurrenceInfoObject getObjectFromRecurrenceString(
			String input) {

		RecurrenceInfoObject iObj = new RecurrenceInfoObject();

		String[] split = input.split(";");

		// Parse Start

		String tz = split[1].substring(split[1].indexOf("=") + 1,
				split[1].indexOf(":"));

		iObj.getStart().setTimezone(tz);

		String startdate = split[1].substring(split[1].indexOf(":") + 1,
				split[1].indexOf(" "));
		try {
			Date parse = dateFormat.parse(startdate);
			iObj.getStart().setStart(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Parse End

		String tzend = split[2].substring(split[2].indexOf("=") + 1,
				split[2].indexOf(":"));

		iObj.getEnd().setTimezone(tzend);

		String enddate = split[2].substring(split[1].indexOf(":") + 1,
				split[2].indexOf(" "));
		try {
			Date parse = dateFormat.parse(enddate);
			iObj.getEnd().setEnd(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Parse Rule

		iObj.getRule().setFrequency(split[2].split("=")[2]);

		if (split[3].startsWith("COUNT")) {
			iObj.getRule().setCount(
					Integer.valueOf(split[3].substring(
							split[3].indexOf("=") + 1, split[3].length())));

		} else {
			String substring = split[3].substring(split[3].indexOf("=") + 1,
					split[3].indexOf("Z"));
			try {
				Date parse = dateFormat.parse(substring);
				iObj.getRule().setUntil(parse);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		iObj.getRule().setDay(
				split[4].substring(split[4].indexOf("=") + 1,
						split[4].indexOf(" ")));

		return iObj;
	}

	public static String getJsonFromRecurrenceString(String input) {
		return new Gson().toJson(getObjectFromRecurrenceString(input));
	}
}