package game;


import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args)
	{
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		obj.setBounds(10, 10, 700, 600); // main layout
		obj.setTitle("Brick Breaker");
		obj.setResizable(false); // interface size will remain constant
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		
	}

}
