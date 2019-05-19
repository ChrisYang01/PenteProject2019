import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Cloud extends ScreenObj {
	
	
	//Data 
	//int maxWidth;
	GameWindow myGW;
	//Image myPic = null;
	int moveSpeed;
	
	
	
	
	
	//Constructors
	public Cloud(int x, int y, String fn, String ext, int mW, GameWindow gw, int picNum)
	{
		super(x, y, fn, ext, mW, gw, picNum);
		this.setMoveSpeed();
		System.out.println("Hi in Cloud Constrcutor moveSpeed is " + moveSpeed);
	}
		

	
	private void setMoveSpeed( ) {
		moveSpeed = (int)(Math.random()* 10) + 3; 
	}
	


		public void moveCloud() {
			
			super.setXLoc(super.getXLoc()-moveSpeed); 
			
			if(super.getXLoc() < -1 * (super.getBW() + 200) )
			{
				super.setXLoc(super.getGameWindow().getWidth()
						+ super.getBW() 
						+ (int)(Math.random() * 200)
						);
			}
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


