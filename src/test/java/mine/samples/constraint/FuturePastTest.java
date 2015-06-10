package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class FuturePastTest extends ValidationTestBase {
	@Past
	Date date;

	@Future
	Calendar calendar;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	@Test
	public void test() {
		FuturePastTest bean = new FuturePastTest();
		bean.setDate(new Date(System.currentTimeMillis() - 10000)); // ok
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -2); // NG
		bean.setCalendar(calendar);
		Set<ConstraintViolation<FuturePastTest>> violations = validator
				.validate(bean);
		assertThat(violations.size(), is(1));
		
		printViolations(violations);
	}

}
