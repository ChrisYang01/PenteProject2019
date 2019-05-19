import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("Flappy Lion");
		int fW = 1000;
		int fH = 1000;
		
		f.setSize(fW, fH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Lots of code
		GameWindow myGame = new GameWindow(fW,(int)(fH * 0.75)-20,f);
		ControlPanel myCP = new ControlPanel(fW ,(int)(fH * 0.14), myGame);
		myGame.setControlPanel(myCP);
		
		
		f.add(myGame, BorderLayout.CENTER);
		f.add(myCP, BorderLayout.SOUTH);
		f.setVisible(true);
		
		
		
		

	}

}
