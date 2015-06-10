package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

public class AssertTrueAndFalseTest {
	private Validator validator;

	@Before
	public void before() {
		ValidatorFactory f = Validation.buildDefaultValidatorFactory();
		validator = f.getValidator();
	}

	@AssertTrue
	boolean mustTrue;

	@AssertFalse
	boolean mustFalse;

	public boolean isMustTrue() {
		return mustTrue;
	}

	public void setMustTrue(boolean mustTrue) {
		this.mustTrue = mustTrue;
	}

	public boolean isMustFalse() {
		return mustFalse;
	}

	public void setMustFalse(boolean mustFalse) {
		this.mustFalse = mustFalse;
	}

	@Test
	public void バリデーション() {
		AssertTrueAndFalseTest bean = new AssertTrueAndFalseTest();
		bean.setMustTrue(false);
		bean.setMustFalse(true);
		Set<ConstraintViolation<AssertTrueAndFalseTest>> violations = validator
				.validate(bean);
		assertThat(violations.size(), is(2));
	}

}
