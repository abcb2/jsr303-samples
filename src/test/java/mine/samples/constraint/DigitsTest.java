package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class DigitsTest extends ValidationTestBase {

	@Digits(integer = 3, fraction = 1)
	String stringValue;

	@Digits(integer = 4, fraction = 0)
	int intValue;

	@Digits(integer = 4, fraction = 3)
	BigDecimal bigDecimalValue;

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public BigDecimal getBigDecimalValue() {
		return bigDecimalValue;
	}

	public void setBigDecimalValue(BigDecimal bigDecimalValue) {
		this.bigDecimalValue = bigDecimalValue;
	}

	@Test
	public void test() {
		DigitsTest bean = new DigitsTest();
		bean.setStringValue("101.0"); // OK
		bean.setIntValue(1000); // OK
		bean.setBigDecimalValue(new BigDecimal("1234.123"));
		assertThat(validator.validate(bean).size(), is(0));

	}

}
