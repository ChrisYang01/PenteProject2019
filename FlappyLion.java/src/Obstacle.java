
public class Obstacle extends ScreenObj{
	
	
	private int moveSpeed;
	private boolean obHit;
	
	
	public Obstacle(int x, int y, String fn, String ext, int mW, 
			GameWindow gw, int picNum)
	{
		super(x, y, fn, ext, mW, gw, picNum);
		
		moveSpeed = (int)(Math.random() * 10) + 3;
		obHit = false;
		
	}
		
		
		//recycling move Cloud 
		public boolean moveObstacle() {
			boolean didReset = false;
			
			super.setXLoc(super.getXLoc()-moveSpeed); 
			
			if(super.getXLoc() < -1 * (super.getBW() - super.getBW() + 100))
				{
				super.setXLoc(super.getGameWindow().getWidth()
						+ super.getBW() 
						+ (int)(Math.random() * 300)
						);
				didReset = true;
				
				
				
				
				
			}
			return didReset;
			
	}
	
	public void setMoveSpeed(int nSpeed)  {
		moveSpeed = nSpeed;
	}
	
	
	public boolean collision(Obstacle theLion) {
		boolean didC = false;
		
		int theLionX0 = theLion.getXLoc() + theLion.getGameBBXExtra() - (int)(theLion.getBW()/2);
		int theLionX1 = theLionX0 + theLion.getGameBBW();
		
		int myX0 = this.getXLoc() + this.getGameBBXExtra() - (int)(this.getBW()/2);
		int myX1 = myX0 + this.getGameBBW();
		
		
		int theLionY0 = theLion.getYLoc() + theLion.getGameBBYExtra() - (int)(theLion.getBH()/2);
		int theLionY1 = theLionY0 + theLion.getGameBBH();
		
		int myY0 = this.getYLoc() + this.getGameBBYExtra() - (int)(this.getBW()/2);
		int myY1 = myY0 + this.getGameBBH();
		
		
		if(
				theLionX0 < myX0 && myX0 < theLionX1 ||
				theLionX0 < myX1 && myX1 < theLionX1
				)
		{
			if(
					(theLionY0 < myY0 && myY0 < theLionY1 ||
					theLionY0 < myY1 && myY1 < theLionY1 
					||
			
					(myY0 < theLionY0 && theLionY0 < myY1 ||
					myY0 < theLionY1 && theLionY1 < myY1)
					
					)
					
					)
					
					
			didC = true;	
				
			System.out.println("We have an intersect");
						
					 
					
			
				{			
					
					
					
			
					
					//System.out.println("We have an X intersect ...");
			
		}
		
		}
		
		//int myX = super.getXLoc() + this.
		
		
		return didC;
		
	}	
	
	public void setobHit(boolean hState){
		obHit = hState; 
	}
	
	public boolean getObHit() {
		return obHit;
	}
	
	public void resetPosition() {
		// sends the obstacle back off screen
		super.setXLoc(super.getGameWindow().getWidth()
				+ super.getBW() 
				+ (int)(Math.random() * 300)
				);
		obHit = false;
		
		
		
		
	}
		
	
	
	
	
	}
	
	
	
	


