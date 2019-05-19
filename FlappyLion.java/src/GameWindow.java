import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameWindow extends JPanel implements ActionListener, KeyListener {
	
	
	public static final int SPACE_KEY = 32;
	public static final int L_GRAVITY = 4;
	public static final int POINT_REWARD = 5;
	public static final int MAX_LIVES = 3;
	//data
	private int windowW, windowH;
	private Color bColor = new Color(209, 238, 249);
	private JFrame myFrame = null;
	private ScreenObj test1;
	private Cloud c1Test;  //make place for object
	private Cloud[] cList;
	private Lion alexLion;
	private Vac vac;
	//private Obstacle eggs;
	private EggNew egg1;
	 
	
	private Timer t;
	
	private int score = 0;
	private int lives = 3;
	private boolean lionHit = false;
	
	private ControlPanel myScorePanel;
	
	private JLabel gameOverLabel;
	private Font gameOverFont = new Font("Arial", Font.BOLD, 145);
	
	
	
	//Constructor 
	public GameWindow(int w, int h) {
		windowW= w;
		windowH= h;
		
		
		this.setSize(windowW, windowH);
		this.setBackground(bColor);
		
	}
	
	public GameWindow(int w,int h,JFrame f) {
		this(w,h);
		myFrame = f;
		
		
		makeAllClouds((int)(Math.random() * 5) + 5);
		makeAlexLion();
		makeObstacles();
		
		
		
		//activate the keyListener
		addKeyListener(this);
		this.setFocusable(true);
		gameOverLabel = new JLabel("Game Over");
		gameOverLabel.setFont(gameOverFont);
		gameOverLabel.setForeground(Color.RED);
		gameOverLabel.setVisible(false);
		this.add(gameOverLabel, null);
		
		
		
		//Set Up Timer 
		t = new Timer(50, (ActionListener)this);
		t.start();
		
		
		}
	
	
	public void makeObstacles() {
		
		
		int lMaxW = (int)(windowW * 0.146);
		int numFrame = 3;
		int vacX = (int)(windowW)-lMaxW;
		int vacY = windowH - (int)(lMaxW * 2);
		
		vac = new Vac (
				vacX,
				vacY,
				"vacPic/Vach", 
				".png",
				lMaxW, 
				this,
				numFrame
				);
			System.out.print(windowW);
			
			vac.setMoveSpeed(13);
			//vac.showGameBB(true);
			vac.setGameBBXExtra((int)(vac.getBW() * 0.59));
			vac.setGameBBYExtra((int)(vac.getBH() * 0.10));
			vac.setGameBBW((int)(vac.getBW() * 0.5));
			vac.setGameBBH((int)(vac.getBH() * 0.90));
			
				
			 int theMaxWE1 = (int) (windowW * 0.15);
		     int frameNumE1= 6;
		     int e1X = vacX + (int)(windowW * 0.5) + theMaxWE1;
				
		egg1 = new EggNew (
				(int)(windowW)- lMaxW, 
				windowH - (int)(lMaxW * 2), 
				"Eggs", 
				".png",
				lMaxW, 
				this,
				1
				);
		
		egg1.setMoveSpeed(25);
        //egg1.showGameBB(true);
        egg1.setGameBBXExtra( (int) (egg1.getBW()  * 0.02) );
        egg1.setGameBBYExtra( (int) (egg1.getBH()  * 0.55) ); 
        egg1.setGameBBW( (int) (egg1.getBW()  * 0.80) );
        egg1.setGameBBH( (int) (egg1.getBH()  * 0.35) );
			
		
	}
	
	public void makeAllClouds(int howMany) {
		//allocate memory....
		
		int topDown = 25;  //how far from top of screen
		cList = new Cloud[howMany];
		//makeClouds
		
		
		
		for (int i = 0; i < howMany; i++) {
			
			cList[i] = new Cloud (
					windowW +(int)(Math.random() * 500),
					topDown + (int)(Math.random()* 100),
					"cloud_",
					".png",
					(int)(Math.random()* 150) + 70,
					this,
					1);
			
		}
	}
				
	
	public void makeAlexLion(){
		
		int lMaxW = (int)(windowW * 0.4);
		int numFrame = 16;
		
		alexLion = new Lion (
				(int)(windowW/2), 
				(int)(windowH - lMaxW/2), 
				"LionPics/frame_", 
				".png",
				lMaxW, 
				this,
				numFrame
				);
			System.out.print(windowW);
			
		
			
			//alexLion.showGameBB(true);
			alexLion.setGameBBXExtra((int)(alexLion.getBW() * 0.3));
			alexLion.setGameBBYExtra((int)(alexLion.getBH() * 0.4));
			alexLion.setGameBBW((int)(alexLion.getBW() * 0.60));
			alexLion.setGameBBH((int)(alexLion.getBH() * 0.90));
			
		
	}
	
	
					
					
		
	
	
	//Behaviors-Methods 
	public void paintComponent(Graphics g){
		windowW = myFrame.getWidth();
		windowH = myFrame.getHeight();
	
	
	
		g.setColor(bColor);
		g.fillRect(0, 0, windowW, windowH);


		 drawClouds(g);
		 alexLion.drawMe(g);
		 vac.drawMe(g);
		 egg1.drawMe(g);
		 
		 
	}
	
	public void drawClouds(Graphics g) {
		
		for (int i = 0; i < cList.length; i++) {
			cList[i].drawMe(g);
			
		}
	}
	
	
	public void checkCollisions() {
		if(!vac.getObHit() && vac.collision(alexLion) == true)
		{
			System.out.println("VAC COLLISION");
			vac.setobHit(true);
			lives -= 1;
			myScorePanel.repaint();
		
			
		if (egg1.collision(alexLion) == true)
		{
			System.out.println("EGG1 COLLISION");
			egg1.setobHit(true);
			lives -=1;
			myScorePanel.repaint();
			//System.out.println("HEY THERE IS A COLLISON");
		}
		
		System.out.println();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(lives > 0) {
			alexLion.animate();
			moveAllObstacles();
			repaint();
			moveClouds();
			checkCollisions();
			
		
			
		} else {
		
			gameOverLabel.setVisible(true);
			repaint();
			
		}
		
		
		
		
	
	
	}
	
	public void moveAllObstacles() {
		boolean didReset = false;
		didReset = vac.moveObstacle();
		vac.animate();
		if(didReset) {
			if(vac.getObHit() == false ) {
				score += GameWindow.POINT_REWARD;
				myScorePanel.repaint();
			} else {
				vac.setobHit(false);
			}
			vac.setobHit(false);
			
		}
		//seperate for eggs 
		didReset = false;
		didReset = egg1.moveObstacle();
		egg1.moveObstacle();
		egg1.animate();
		if(didReset) {
			if(egg1.getObHit() == false ) {
				score += GameWindow.POINT_REWARD;
				myScorePanel.repaint();
			} else {
				egg1.setobHit(false);
			}
			egg1.setobHit(false);
			
		}
		
	}
	
	
	public void moveClouds() {
		
		for (int i = 0; i < cList.length; i++) {
			cList[i].moveCloud();
			}
	
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hey you typed a key");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Hey you pressed a key");
		System.out.println("Key has keyCode of" + e.getKeyCode());
		//System.out.println("Key has keyCode of" + e.getKeyChar());
		//System.out.println();
		
		
		if(e.getKeyCode()== SPACE_KEY){
			alexLion.jump();
			
		}
	
			repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hey you released a key");
	}
	
	
	public String getScoreStr() {
		return Integer.toString(score);
		
	}

	public String getlivesStr() {
		return Integer.toString(lives);

	}
	
	public void setControlPanel(ControlPanel p) {
		myScorePanel = p;
		System.out.println("My score panel has been set");
	}
	
	public void doReset() {
		lives = this.MAX_LIVES;
		score = 0;
		
		vac.resetPosition();
		egg1.resetPosition();
		alexLion.resetLion();
		gameOverLabel.setVisible(false);
		repaint();
		this.myScorePanel.repaint();
		//setFocusable(true);
		this.requestFocusInWindow();
		
		
	}
}