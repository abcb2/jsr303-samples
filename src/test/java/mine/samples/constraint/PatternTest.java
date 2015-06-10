package mine.samples.constraint;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.validation.constraints.Pattern;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class PatternTest extends ValidationTestBase {

	@Pattern(regexp = "hoge")
	String hoge;

	@Pattern(regexp = "bar")
	String bar;

	@Test
	public void test() {
		PatternTest bean = new PatternTest();
		bean.setBar("bar"); // OK
		bean.setHoge("bar"); // NG
		assertThat(validator.validate(bean).size(), is(1));
		printViolations(validator.validate(bean));
	}

	public String getHoge() {
		return hoge;
	}

	public void setHoge(String hoge) {
		this.hoge = hoge;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

}
