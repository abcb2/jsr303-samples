package mine.samples.constraint;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.junit.Before;
import org.junit.Test;

public class DecimalMaxAndMinTest {
	private Validator validator;

	@Before
	public void before() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@DecimalMax("10")
	String stringValue;

	@DecimalMin(value = "-10.0")
	int intValue;

	@DecimalMin("3.00")
	@DecimalMax("4.00")
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
		DecimalMaxAndMinTest bean = new DecimalMaxAndMinTest();
		bean.setStringValue("100"); // NG
		bean.setIntValue(-9); // OK
		bean.setBigDecimalValue(new BigDecimal("3.5")); // OK
		assertThat(validator.validate(bean).size(), is(1));
		printViolations(validator.validate(bean));
	}
	
	@Test
	public void test2(){
		DecimalMaxAndMinTest bean = new DecimalMaxAndMinTest();
		bean.setStringValue("A");
		bean.setIntValue(-9);
		bean.setBigDecimalValue(new BigDecimal("3.5"));
		assertThat(validator.validate(bean).size(), is(1));
		printViolations(validator.validate(bean));
	}
	
	protected <T> void printViolations(Set<ConstraintViolation<T>> violations){
		for(ConstraintViolation<T> violation : violations){
			StringBuilder sb = new StringBuilder();
			sb.append("[Path]" + violation.getPropertyPath() + " ");
			sb.append("[Value]" + violation.getInvalidValue() + " ");
			sb.append("[Message]" + violation.getMessage());
			System.err.println(sb.toString());
		}
	}

}
