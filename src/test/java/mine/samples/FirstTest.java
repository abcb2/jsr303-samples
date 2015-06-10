package mine.samples;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class FirstTest {

	@Test
	public void test1() {
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Bean bean = new Bean();
		bean.setOk(false);

		Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
		assertThat(violations.size(), is(1));

		for (ConstraintViolation<Bean> violation : violations) {
			System.out.println(violation.getMessage());
		}
	}

	@Test
	public void test2() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Bean bean = new Bean();
		bean.setOk(true);
		Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
		assertThat(violations.size(), is(0));
	}

}
