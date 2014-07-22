package ch.halcyon.java.recurrenceparser.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import ch.halcyon.java.recurrenceparser.RecurrenceInfoObject;
import ch.halcyon.java.recurrenceparser.RecurrenceParser;

public class ParserTest extends TestCase {

	static String INPUT = "DTSTART;TZID=Europe/Zurich:20140818T111000 DTEND;TZID=Europe/Zurich:20140818T115500 RRULE:FREQ=WEEKLY;UNTIL=20150126T101000Z;BYDAY=MO BEGIN:VTIMEZONE TZID:Europe/Zurich X-LIC-LOCATION:Europe/Zurich BEGIN:DAYLIGHT TZOFFSETFROM:+0100 TZOFFSETTO:+0200 TZNAME:CEST DTSTART:19700329T020000 RRULE:FREQ=YEARLY;BYMONTH=3;BYDAY=-1SU END:DAYLIGHT BEGIN:STANDARD TZOFFSETFROM:+0200 TZOFFSETTO:+0100 TZNAME:CET DTSTART:19701025T030000 RRULE:FREQ=YEARLY;BYMONTH=10;BYDAY=-1SU END:STANDARD END:VTIMEZONE ";
	static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");
	static String JSON = "{\"start\":{\"timezone\":\"Europe/Zurich\",\"start\":\"Aug 18, 2014 11:10:00 AM\"},\"end\":{\"timezone\":\"Europe/Zurich\",\"end\":\"Aug 18, 2014 11:55:00 AM\"},\"rule\":{\"frequency\":\"WEEKLY\",\"until\":\"Jan 26, 2015 10:10:00 AM\",\"day\":\"MO\"}}";

	private RecurrenceInfoObject iObj;

	@Override
	protected void setUp() throws Exception {
		iObj = RecurrenceParser.getObjectFromRecurrenceString(INPUT);
	}

	public void testInitialThings() {
		assertNotNull(iObj.getStart());
	}

	public void testStart() {
		assertTrue(iObj.getStart().getTimezone().equals("Europe/Zurich"));

		try {
			assertTrue(iObj.getStart().getStart()
					.equals(DATETIME_FORMAT.parse("2014-08-18 11:10:00")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void testEnd() {
		assertTrue(iObj.getEnd().getTimezone().equals("Europe/Zurich"));

		try {
			assertTrue(iObj.getEnd().getEnd()
					.equals(DATETIME_FORMAT.parse("2014-08-18 11:55:00")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void testRule() {
		assertTrue(iObj.getRule().getFrequency().equals("WEEKLY"));
		try {
			assertTrue(iObj.getRule().getUntil()
					.equals(DATETIME_FORMAT.parse("2015-01-26 10:10:00")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		assertTrue(iObj.getRule().getDay().equals("MO"));
	}

	public void testJson() {
		assertTrue(RecurrenceParser.getJsonFromRecurrenceString(INPUT).equals(
				JSON));
	}
}
