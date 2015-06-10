package mine.samples.custommessage;

import static org.junit.Assert.*;

import javax.validation.constraints.Size;

import mine.samples.ValidationTestBase;

import org.junit.Test;

public class MessageTest extends ValidationTestBase {

	@Size(min = 10)
	String defaultMessage = "hoge";

	@Size(min = 10, message = "サイズが{min}と{max}の間にしてください")
	String directMessage = "hoge";

	@Size(min = 10, message = "{mykey}")
	String fromPropMEssage = "hoge";

	@Test
	public void test() {
		validator.validate(this);
		printViolations(validator.validate(this));
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public String getDirectMessage() {
		return directMessage;
	}

	public void setDirectMessage(String directMessage) {
		this.directMessage = directMessage;
	}

	public String getFromPropMEssage() {
		return fromPropMEssage;
	}

	public void setFromPropMEssage(String fromPropMEssage) {
		this.fromPropMEssage = fromPropMEssage;
	}

}
