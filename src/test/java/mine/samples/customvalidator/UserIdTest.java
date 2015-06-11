package mine.samples.customvalidator;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;

import mine.samples.ValidationTestBase;

import org.junit.AfterClass;
import org.junit.Test;

public class UserIdTest extends ValidationTestBase {

	@UserId
	String userId;

	@Test
	public void test() {
		UserIdTest bean = new UserIdTest();
		bean.setUserId("bar");
		Set<ConstraintViolation<UserIdTest>> violations = validator
				.validate(bean);
		for (ConstraintViolation<UserIdTest> violation : violations) {
			System.err.println(violation.getMessage());
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
