package mine.samples.groups;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import mine.samples.ValidationTestBase;

import org.junit.AfterClass;
import org.junit.Test;

public class FirstGroupsTest extends ValidationTestBase {
	interface Group1 {
	}

	interface Group2 {
	}
	
	interface Group3 {
	}

	@NotNull
	Object aaa;

	@NotNull(groups = Group1.class)
	Object bbb;
	
	@NotNull(groups = Group3.class)
	Object ccc = 1;

	@Test
	public void test1() {
		assertThat(validator.validate(this).size(), is(1));
		assertThat(validator.validate(this, Default.class).size(), is(1));
	}
	
	@Test
	public void test2(){
		assertThat(validator.validate(this, Group1.class).size(), is(1));
		assertThat(validator.validate(this, Group3.class).size(), is(0));
	}

}
