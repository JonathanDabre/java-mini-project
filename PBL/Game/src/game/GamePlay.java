package game;

import java.awt.Color;
		
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX= 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	// gameplay initialization
	
	public GamePlay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		g.setColor(Color.yellow);
		// position of borders
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// attributes of pedal
		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8);
		
		// attributes of ball
		g.setColor(Color.orange);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		g.dispose(); // to release the  system resources used 
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		timer.start();
		if(play)
		{
			if(new Rectangle(ballposX, ballposY, 20, 30).intersects(new Rectangle(playerX, 550,100,8)))
			{
				ballYdir=-ballYdir;
			}
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX <0) {
				ballXdir=-ballXdir;
				
			}
			if(ballposY <0) 
			{
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir=-ballXdir;
				
			}
				
		}
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
		
		

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			if(playerX >= 600) // to not exceed the boundary
			playerX = 600;
			else
			{
				moveRight();
			}
		}
		if(arg0.getKeyCode()== KeyEvent.VK_LEFT)
		{
			if(playerX < 10) // to not exceed the boundary
				{
					playerX = 10;
				}
			else
			{
				moveLeft();
			}
		}
		
		
	}
	public void moveRight()
	{
		play = true;
		playerX += 20;
	}
	
	public void moveLeft()
	{
		play = true;
		playerX -= 20;
	}	
		

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
