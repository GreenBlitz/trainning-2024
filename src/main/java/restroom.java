public class restroom extends room {
	public restroom(int width, int height, int length) {
		super(width, height, length);
	}
	public String isEmpty(){
		if(super.getInside() == false){
			return "no";
		}
		else{
			return "in use";
		}
	}
}
