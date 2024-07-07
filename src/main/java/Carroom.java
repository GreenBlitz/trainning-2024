public class Carroom extends room{
	protected int space;
	public Carroom(int width, int height, int length) {
		super(width, height, length);
		space = 0;
	}
	public boolean addcar(int capacity){
		if(space >= capacity){
			space -= capacity;
			return true;
		}
		return false;
	}
}
