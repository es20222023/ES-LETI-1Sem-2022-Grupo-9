package ES_LETI_1Sem_2022_Grupo_9.ESGrupo9;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The class Week calendar extends calendar
 */ 
public class WeekCalendar extends Calendar {
	private Week week;

	/** 
	 *
	 * Week calendar
	 *
	 * @param events  the events
	 * @return 	public
	 */
	public WeekCalendar(ArrayList<CalendarEvent> events) { 
		super(events);
		week = new Week(LocalDate.now());
	}

	@Override
	protected boolean dateInRange(LocalDate date) {
		return Week.getStartOfWeek(date).equals(week.getDay(DayOfWeek.MONDAY));
	}

	@Override
	protected LocalDate getDateFromDay(DayOfWeek day) {
		return week.getDay(day);
	}

	protected int numDaysToShow() {
		return 5;
	}

	@Override
	protected DayOfWeek getStartDay() {
		return DayOfWeek.MONDAY;
	}

	@Override
	protected DayOfWeek getEndDay() {
		return DayOfWeek.FRIDAY;
	}

	@Override
	protected void setRangeToToday() {
		week = new Week(LocalDate.now());
	}

	@Override
	protected double dayToPixel(DayOfWeek dayOfWeek) {
		return TIME_COL_WIDTH + getDayWidth() * (dayOfWeek.getValue() - 1);
	}

	/** 
	 *
	 * Next week
	 *
	 */
	public void nextWeek() { 
		week = week.nextWeek();
		repaint();
	}

	/** 
	 *
	 * Prev week
	 *
	 */
	public void prevWeek() { 
		week = week.prevWeek();
		repaint();
	}

	/** 
	 *
	 * Next month
	 *
	 */
	public void nextMonth() { 
		week = new Week(week.getDay(DayOfWeek.MONDAY).plusWeeks(4));
		repaint();
	}

	/** 
	 *
	 * Prev month
	 *
	 */
	public void prevMonth() { 
		week = new Week(week.getDay(DayOfWeek.MONDAY).minusWeeks(4));
		repaint();
	}

}