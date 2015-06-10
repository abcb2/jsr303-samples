package mine.samples.constraint;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;

import mine.samples.ValidationTestBase;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class SizeTest extends ValidationTestBase {

	@Size(min = 3, max = 5)
	String str;

	@Size(min = 3, max = 6)
	List<Integer> list;

	@Size
	Map<String, Integer> map;

	@Size(max = 100)
	int[] array;

	@Test
	public void test() {
		SizeTest bean = new SizeTest();
		bean.setArray(new int[] { 1, 2, 3 }); // OK
		bean.setMap(new HashMap<String, Integer>()); // OK
		bean.setList(Arrays.asList(1, 2)); // NG
		bean.setStr("あい"); // OK

		assertThat(validator.validate(bean).size(), is(2));
		printViolations(validator.validate(bean));
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

}
