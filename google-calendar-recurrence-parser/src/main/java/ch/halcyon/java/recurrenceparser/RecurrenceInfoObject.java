package ch.halcyon.java.recurrenceparser;

import java.util.Date;

public class RecurrenceInfoObject {

	public class Start {
		private String timezone;
		private Date start;

		public Start() {
		}

		public Start(String timezone, Date start) {
			super();
			this.timezone = timezone;
			this.start = start;
		}

		public String getTimezone() {
			return timezone;
		}

		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}

		public Date getStart() {
			return start;
		}

		public void setStart(Date start) {
			this.start = start;
		}

	}

	public class End {
		private String timezone;
		private Date end;

		public End() {
		}

		public End(String timezone, Date end) {
			super();
			this.timezone = timezone;
			this.end = end;
		}

		public String getTimezone() {
			return timezone;
		}

		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}

	}

	public class Rule {
		private String frequency;
		private Date until;
		private String day;
		private int count;

		public Rule() {
		}

		public Rule(String frequency, Date until, String day, int count) {
			super();
			this.frequency = frequency;
			this.until = until;
			this.day = day;
			this.count = count;
		}

		public String getFrequency() {
			return frequency;
		}

		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}

		public Date getUntil() {
			return until;
		}

		public void setUntil(Date until) {
			this.until = until;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	private Start start;
	private End end;
	private Rule rule;

	public RecurrenceInfoObject() {
		start = new Start();
		end = new End();
		rule = new Rule();
	}

	public RecurrenceInfoObject(Start start, End end, Rule rule) {
		super();
		this.start = start;
		this.end = end;
		this.rule = rule;
	}

	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}

	public End getEnd() {
		return end;
	}

	public void setEnd(End end) {
		this.end = end;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
