/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public class room {
	protected int width;
	protected int height;
	protected int length;
	protected boolean inside;
	
	public room(int width, int height, int length) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.inside = false;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setInside(boolean inside) {
		this.inside = inside;
	}
	public boolean getInside() {
		return this.inside;
	}
	public String intercom() {
		return "room{" + "width=" + width + ", height=" + height + ", length=" + length + ", inside=" + inside + '}';
	}
	
	
}
