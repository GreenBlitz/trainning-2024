package training.Roller;

public enum RollerDirection {

	kForward(1),
	kBackward(-1);

	private final int value;

	RollerDirection(int value) {
		this.value = value;
	}

	public int toInt() {
		return this.value;
	}

}
