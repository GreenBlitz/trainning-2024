package training.Wrist;

public enum WristDirection {

	kLeft(true),
	kRight(false);

	private final boolean value;

	WristDirection(boolean val) {
		this.value = val;
	}

	public boolean gotLeft() {
		return this.value;
	}

}
