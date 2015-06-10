package mine.samples;

import javax.validation.constraints.AssertTrue;

public class Bean {
	@AssertTrue
	private boolean isOk;

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}
