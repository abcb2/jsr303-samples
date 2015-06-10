package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class MaxAndMinTest extends ValidationTestBase {

	@Max(10)
	String stringValue;

	@Min(-10)
	int intValue;

	@Min(3)
	@Max(4)
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
	public void test1() {
		MaxAndMinTest bean = new MaxAndMinTest();
		bean.setStringValue("100");
		bean.setIntValue(-9);
		bean.setBigDecimalValue(new BigDecimal("3"));
		assertThat(validator.validate(bean).size(), is(1));
		printViolations(validator.validate(bean));
	}

}
