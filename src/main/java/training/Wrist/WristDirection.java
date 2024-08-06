package training.Wrist;

public enum WristDirection {

	kLeft(true),
	kRight(false);

	private final boolean value;

	WristDirection(boolean value) {
		this.value = value;
	}

	public boolean gotLeft() {
		return this.value;
	}

}
