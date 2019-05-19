
public class Lion extends Obstacle{
	//we think we need to make the lion:
	//jump
	//do collisions 
	
	
	private int ySpeed; 
	private int origY;
	
	
	public Lion(int x, int y, String fileName, 
			String ext, int mW, GameWindow gw, int numOfPics) {
		
		super(x, y, fileName, ext, mW, gw, numOfPics);
		// TODO Auto-generated constructor stub
		
		
		ySpeed = 0;
		origY = y;
		
	}
		
		public void animate() {
			super.animate();
			
			super.setYLoc(super.getYLoc() + ySpeed);
			ySpeed += GameWindow.L_GRAVITY;
			
			
			if(super.getYLoc() > origY) {
				super.setYLoc(origY);
				ySpeed = 0;
			}
		}
		
		public void jump() {
			ySpeed += -(GameWindow.L_GRAVITY * 15);
			
		
		
		
		
		
	}
		
		public void resetLion() {
			ySpeed = 0;
			super.setYLoc(origY);
		}

}
