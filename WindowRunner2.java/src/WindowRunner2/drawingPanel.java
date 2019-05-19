package WindowRunner2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class drawingPanel extends JPanel implements ActionListener {
	
	
	Color bColor;
	int width, height;
	Color drawColor;
	JFrame myFrame;
	
	
	int eyeH = 0;
	int maxEye;
	
		
	Timer t;
	
	
	boolean opening = true;
	
	public drawingPanel(Color bc, int w, int h, JFrame f)
	{
		bColor = bc;
		width = w;
		height = h;
		myFrame = f;
		
		this.setSize(width,height);
		this.setBackground(bColor);
		
		int rValue = 255 -bColor.getRed();
		int gValue = 255 -bColor.getGreen();
		int bValue = 255 -bColor.getBlue();
		
		drawColor = new Color(rValue, gValue, bValue);
		
	//Timer Setup
	
		t = new Timer((int)(Math.random()* 80), this);	
		t.start();
	
	}
	
	
	
	//overide paint
	public void paintComponent(Graphics g)  {
		
		g.setColor(bColor);
		
		g.fillRect(0, 0, width, height);
		drawSmiley(g);
	}

	
		
		
		
		
	public void drawSmiley(Graphics g) {
		int cX = (int)(width/2.0);
		int cY = (int)(height/2.0);
		
		int shortD = Math.min(width, height);
		int smileW = (int)(shortD * 0.80);
		int eyeW = (int)(shortD * 0.23);
		maxEye = eyeW;
		
		Color yellowColor = new Color(255,255,10);
		g.setColor(yellowColor);
		g.fillOval(cX-(int)(smileW/2.0),
				cY-(int)(smileW/2.0),
				smileW,
				smileW);
		
		//ring
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		
		g.setColor(Color.BLACK);
		g.drawOval(cX-(int)(smileW/2.0),
				cY-(int)(smileW/2.0),
				smileW,
				smileW);
		
		g.fillOval(cX-(int)(smileW/5.0)-(eyeW/2),
				cY-(int)(smileW/5.0)-(eyeW/2),	
				eyeW,
				eyeH);
		
		g.fillOval(cX +(int)(smileW/5.0)-(eyeW/2),
				cY - (int)(smileW/5.0)-(eyeW/2),
				eyeW,
				eyeW-eyeH);
		
		//Arc
		
		g2.fillArc(cX-(smileW/4),
				cY,
				2*smileW/4,
				smileW/4,
				0,
				-180);
				
		
		
		
		}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(opening == true)
		{
			if(eyeH < maxEye)
			{
				eyeH += 2;

			} else {
				opening = false;
			}
			
		} else {
			if(eyeH >= 1) {
				eyeH -=2;
			} else {
				opening = true;
			}
		}
		
		repaint();
		
	} 
			
		
		
		
	}
		
		
	

	


