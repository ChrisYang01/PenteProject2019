import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//parent class for all the objects 

public class ScreenObj {
	//data hiding
	private int xLoc, yLoc;
	private int boundW, boundH;
	private Image [ ] myPics = null;
	private int maxWidth;
	private int origW, origH;
	private int currentPic;
	private GameWindow gameW;
	
	
	//Add Coordinates for a collision box 
	private int gameBBXExtra = 0, gameBBYExtra = 0;
	private int gameBBW = 0, gameBBH = 0;
	private boolean showGameBB = false;
	
	
	//constructors(s)

	
	public ScreenObj(
			int x, 
			int y,
			String fileName,
			String ext,
			int mW,
			GameWindow gw,
			int numOfPics) 
	{
		xLoc = x;
		yLoc = y;
		gameW = gw;
		maxWidth = mW;
		
		readyPics(numOfPics, fileName, ext);
	}
	
	public void readyPics(int n, String fn, String ext) {
		
		myPics = new Image [n];
		for(int i = 0; i < myPics.length; i++) {
			
			String fullString = "";
			if(i < 10) {
				fullString += fn + 0 + Integer.toString(i) + ext;
			} else {
					fullString += fn + Integer.toString(i) + ext;
			}
			System.out.println("Trying to open: " + fullString);
			
			
		
		
		boolean iLoaded = loadImage(fullString, i);
		
		if(iLoaded)
		{
			setBH(myPics[i].getHeight(null));
			setBW(myPics[i].getWidth(null));
			origW = myPics[i].getWidth(null);
			origH = myPics[i].getHeight(null);
			
			
			System.out.println("setBH is" + getBH());
			System.out.println("setBW is" + getBW());
			System.out.println("origW" + origW);
			System.out.println("origH" + origH);
			
			
			if(getBW() > maxWidth)
			{
				
				int newH = (int)(
						maxWidth *
						((getBH() * 1.0 / getBW() * 1.0)
						));
			
				
				//update Box Width 
				setBH(newH);
				setBW(maxWidth);
				
				System.out.println("maxWidth" + maxWidth);
				System.out.println("newH" + newH);
				
			}
			
			
		}
		
		
		}
		
		
	}
	
	
		
		
	
	private boolean loadImage(String f, int whichPic)
	{
		
		boolean ok = false; 
		try {
			ImageIcon ii = new ImageIcon(f);
			myPics[whichPic] = ii.getImage();
			ok = true;
			
		}catch(Exception e) {
		   System.out.println("Problem in loading "
					+ f + "in loadImage...");
		}
		
		return ok;
	}	
	
	public void drawMe(Graphics g) {
		
		g.drawImage(myPics[currentPic],
		getXLoc()-(int)(getBW()/2),
		getYLoc()-(int)(getBH()/2),
		getXLoc()+(int)(getBW()/2),
		getYLoc()+(int)(getBH()/2),
		0,
		0,
		origW,
		origH,
		null);
		
		if(showGameBB == true) {
			g.setColor(Color.MAGENTA);
			g.drawRect(xLoc-(int)(boundW/2)+ gameBBXExtra,
				yLoc-(int)(boundH/2)+ gameBBYExtra,
				gameBBW, gameBBH);
		
		}
		
		//animate();
	}	
	
		
	
	public void animate() {
		currentPic++;
		if(currentPic >= myPics.length)  {
			currentPic = 0;
			
		}
		
		
	}
	
	
	
	
	//accessor methods
	
	public int getXLoc() {
		return xLoc;
	}
	
	public int getYLoc() {
		return yLoc;
	}
	
	public void setXLoc(int newX)
	{
		xLoc =newX;
	}
	
	public void setYLoc(int newY)
	{
		yLoc =newY;
	}
	
	//accessors for boundW and boundH
	
	public int getBW() {
		return boundW;
	}
	
	public int getBH() {
		return boundH;
		
	}
	
	public void setBW(int newBW) {
		boundW = newBW;
	}
	
	public void setBH(int newBH) {
		boundH = newBH;
	}
	
	public GameWindow getGameWindow()  {
		return gameW;
	}
	
	public int getMaxWidth() {
		return maxWidth;
	}
	
	public int getCurPic() {
		return currentPic;
	}
	
	public void setCurPic(int newPicNum) {
		currentPic = newPicNum;
	}
	
	public int getMyPicsLength() {
		return myPics.length;
	
	
	}
	
	//For game bounding box 
	
	public void showGameBB(boolean showIt) {
		showGameBB = showIt;
	}
	
	public void setGameBBXExtra(int newEX) {
		gameBBXExtra = newEX;
	}
	
	public void setGameBBYExtra(int newEY) {
		gameBBXExtra = newEY;
	}
	
	public void setGameBBW(int newBBW) {
		gameBBW = newBBW;
	}
		
	public void setGameBBH(int newBBH) {
		gameBBH = newBBH;
		
	
	}
	
	
	public int getGameBBXExtra() {
		return gameBBXExtra;
	}
	
	public int getGameBBYExtra() {
		return gameBBYExtra;
	}
	
	public int getGameBBW() {
		return gameBBW;
	}
	
	public int getGameBBH() {
		return gameBBH;
		}


	}
	
	
	
	
	
	


