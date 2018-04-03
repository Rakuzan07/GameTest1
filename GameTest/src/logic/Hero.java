package logic;

public class Hero implements Dinamic{
	
	private static final int SPEED = 4; 
	private int x,y,height,width;
	
	public Hero(int x , int y , int height , int width) {
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	
	
	public Hero() {
		this.x=0;
		this.y=0;
	}
	
	public void jump() {
		
	}

	public void run() {
		
	}

	
	public void collision() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
    public int getHeight() {
    	return height;
    }
    
    public int getWidth() {
    	return width;
    }

}
