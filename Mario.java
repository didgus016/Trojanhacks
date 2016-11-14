import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mario extends JPanel implements KeyListener {
	public static boolean alive;
	public static int xlocation;
	public static int ylocation;
	public static Image img;
	public static int score; 
	
	public Mario()
	{
		xlocation = 0;
		ylocation = 0;
		Image img = Toolkit.getDefaultToolkit().getImage("src/Mario.jpg");
		try {
			this.img = ImageIO.read(new File("src/Mario.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(this.img.getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		add(label);
		revalidate();
		repaint();
		alive = true;	
	}
	
	public Mario(int x, int y)
	{
		addKeyListener(this);
		xlocation = x;
		ylocation = y;
		alive = true;
	}
	public void killMario()
	{
		alive = false;
	}
	public boolean getAlive()
	{
		return alive;
	}
	public static int getYLocation()
	{
		return ylocation;
	}
	public static int getXlocation()
	{
		return xlocation;
	}


	
	//Interface duties
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
	public void keyPressed(KeyEvent evt)
	{
		if(evt.getKeyCode() == KeyEvent.VK_DOWN){
			if( (ylocation+10) < 1000)
			{
				ylocation+=10;
			}
		}
		else if(evt.getKeyCode() == KeyEvent.VK_UP)
		{
			if( (ylocation-10) > 0)
				ylocation-=10;
		}
		//If the person said right
		else if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if( (xlocation+10) < 1500)
			{
				xlocation+=10;
			} // if left
			else if(evt.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if( (xlocation-10) > 0)
					xlocation-=10;
			}	
		}
	 }
}
