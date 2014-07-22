google-calendar-recurrence-parser
=================================

When you work with the API for the Google Calendars, you might coma across the following strings:

'''
$t: "DTSTART;TZID=Europe/Zurich:20140818T111000 DTEND;TZID=Europe/Zurich:20140818T115500 RRULE:FREQ=WEEKLY;UNTIL=20150126T101000Z;BYDAY=MO BEGIN:VTIMEZONE TZID:Europe/Zurich X-LIC-LOCATION:Europe/Zurich BEGIN:DAYLIGHT TZOFFSETFROM:+0100 TZOFFSETTO:+0200 TZNAME:CEST DTSTART:19700329T020000 RRULE:FREQ=YEARLY;BYMONTH=3;BYDAY=-1SU END:DAYLIGHT BEGIN:STANDARD TZOFFSETFROM:+0200 TZOFFSETTO:+0100 TZNAME:CET DTSTART:19701025T030000 RRULE:FREQ=YEARLY;BYMONTH=10;BYDAY=-1SU END:STANDARD END:VTIMEZONE "
'''

With this small library you then can simply parse it to a more suitable object or to a json element.

'''
{"start":{"timezone":"Europe/Zurich","start":"Aug 18, 2014 11:10:00 AM"},"end":{"timezone":"Europe/Zurich","end":"Aug 18, 2014 11:55:00 AM"},"rule":{"frequency":"WEEKLY","until":"Jan 26, 2015 10:10:00 AM","day":"MO"}}
'''
