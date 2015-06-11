package mine.samples.customvalidator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class PeriodTest extends ValidationTestBase {
	@Period(day = 1)
	Date date;

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		assertThat("od desu", validator.validate(this).size(), is(0));
		
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		assertThat("od desu", validator.validate(this).size(), is(0));
		
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		assertThat("ng desu", validator.validate(this).size(), is(1));
	}

}
