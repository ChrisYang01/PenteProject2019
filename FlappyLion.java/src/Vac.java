
public class Vac extends Obstacle {
	
	long frameCount = 0;
	int frameSpeed = 4;
	
	public Vac(int x, int y, String fileName, String ext, int mW, GameWindow gw, int numOfPics) {
		super(x,y,fileName, ext,mW, gw,numOfPics);
	}
	
	
	public void animate() {
		frameCount++;
		
		if(frameCount % frameSpeed == 0) {
			super.setCurPic(super.getCurPic()+ 1);
			
			
			if(super.getCurPic() >= super.getMyPicsLength())  {
				super.setCurPic(0);
		
		}
		
		
		}
	}


	
	

}
