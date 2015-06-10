package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class NullAndNotNullTest extends ValidationTestBase {
	@Null
	Object thisIsNull;

	@NotNull
	Object thisIsNotNull;

	@Test
	public void test() {
		NullAndNotNullTest bean = new NullAndNotNullTest();
		bean.setThisIsNotNull(null); // NG
		bean.setThisIsNull(new Object()); // NG
		assertThat(validator.validate(bean).size(), is(2));
		printViolations(validator.validate(bean));
	}

	public Object getThisIsNull() {
		return thisIsNull;
	}

	public void setThisIsNull(Object thisIsNull) {
		this.thisIsNull = thisIsNull;
	}

	public Object getThisIsNotNull() {
		return thisIsNotNull;
	}

	public void setThisIsNotNull(Object thisIsNotNull) {
		this.thisIsNotNull = thisIsNotNull;
	}

}
