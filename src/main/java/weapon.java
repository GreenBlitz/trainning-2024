import java.nio.charset.StandardCharsets;

public class weapon extends  room{
	public weapon(int width, int height, int length) {
		super(width, height, length);
	}
	@Override
	public String intercom(){
		String enc = super.intercom();
		byte[] bytearray = enc.getBytes(StandardCharsets.UTF_8);
		StringBuilder msg = new StringBuilder();
		for (byte b : bytearray){
			msg.append((String.format("%02d", b)));
		}
		return msg.toString();
		
	}
	
}
