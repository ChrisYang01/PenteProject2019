import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ControlPanel extends JPanel implements MouseListener {
	
	
	//Data Fields 
	int cpWidth, cpHeight;
	Color bc = new Color(19, 69, 196);
	GameWindow gw;
	JLabel scoreNum, livesNum;
	
	JButton reset = new JButton("Reset");
	
	
	
	
	Font myFont = new Font("TimesRoman", Font.BOLD, 24);
	
	
	//Constructors
	
	public ControlPanel(int w, int h, GameWindow gww) {
		
		cpWidth = w;
		cpHeight = h;
		gw = gww;
		
		
		this.setSize(cpWidth, cpHeight);
		this.setPreferredSize(new Dimension(cpWidth, cpHeight));
		this.setMinimumSize(new Dimension(cpWidth, cpHeight));
		
		// set Color
		
		this.setBackground(bc);
		
		//border set `up 
		this.setLayout(new BorderLayout());
		
		Border b = BorderFactory.createLineBorder(
			
				Color.RED,
				6
					
			
				
				);
		this.setBorder(b);
		
		//Score
		JPanel scoreP = new JPanel();
		scoreP.setPreferredSize(new Dimension(cpWidth/2, cpHeight));
		scoreP.setLayout(new GridLayout(1,2,10,1));
		scoreP.setBackground(new Color(244, 65, 65));
		scoreP.setBorder(BorderFactory.createEmptyBorder(
				5,(int)(cpWidth * 0.05),5,5
				));
		
		
		JLabel scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(myFont);
		scoreLabel.setForeground(Color.WHITE);
		scoreP.add(scoreLabel);
		
		
		scoreNum = new JLabel("    " + gw.getScoreStr());
		scoreNum.setFont(myFont);
		scoreNum.setForeground(Color.WHITE);
		scoreP.add(scoreNum);
		
		
		
		this.add(scoreP,BorderLayout.WEST);
		scoreP.setVisible(true);
		
		//lives
		JPanel livesP = new JPanel();
		livesP.setPreferredSize(new Dimension(cpWidth/2, cpHeight));
		livesP.setLayout(new GridLayout(1,1,10,1));
		livesP.setBackground(new Color(255,255,255));
		livesP.setBorder(BorderFactory.createEmptyBorder(
				5,(int)(cpWidth * 0.05),5,5
				));
		
		
		JLabel livesLabel = new JLabel("Lives: ");
		livesLabel.setFont(myFont);
		livesLabel.setForeground(Color.RED);
		livesP.add(livesLabel);
		
		
		livesNum = new JLabel("    " + gw.getlivesStr());
		livesNum.setFont(myFont);
		livesNum.setForeground(Color.RED);
		livesP.add(livesNum);
		
	
		
		
		
		livesP.add(reset);
		
		reset.addMouseListener(this);
		
		
		
		
		
		
		
		this.add(livesP,BorderLayout.EAST);
		scoreP.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		scoreNum.setText("    " + gw.getScoreStr());
		livesNum.setText("    " + gw.getlivesStr());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Good Morning!!You clicked on me");
		System.out.println("The button is " + e.getButton());
		gw.doReset();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
