package mine.samples.list;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.validation.constraints.Pattern;

import mine.samples.ValidationTestBase;

import org.junit.AfterClass;
import org.junit.Test;

public class ListTest extends ValidationTestBase {
	@Pattern.List({ @Pattern(regexp = "^aaa.*"), @Pattern(regexp = ".*bbb$") })
	String str;

	@Test
	public void test() {
		str = "ccc";
		assertThat(validator.validate(this).size(), is(2));

		str = "aaa";
		assertThat(validator.validate(this).size(), is(1));

		str = "aaabbb";
		assertThat(validator.validate(this).size(), is(0));
	}

}
