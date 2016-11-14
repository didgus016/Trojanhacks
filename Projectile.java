import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Projectile extends JPanel{
	
	public int xlocation;
	public int ylocation;
	public Image img;
		
	public Projectile()
	{
		xlocation = 1500;
		ylocation = 500;
		String[] array = new String[6];
		array[0] = "src/brandon.png";
		array[1] = "src/samp.png";
		array[2] = "src/Alex.png";
		array[3] = "src/Mark.png";
		array[4] = "src/james.png";
		array[5] = "src/sideway.png";
		Random rand = new Random();
		int num = rand.nextInt(6);
		Image img = Toolkit.getDefaultToolkit().getImage(array[num]);
		try {
			this.img = ImageIO.read(new File(array[num]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(this.img.getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		add(label);
		revalidate();
		repaint();
		
	}
	//Will not use
	public Projectile(int y)
	{
		xlocation = 1500;
		ylocation = y;
		Image img = Toolkit.getDefaultToolkit().getImage("Projectile.jpg");
		
	}
	public void move()
	{
		//Remember to come back and delete the 
		//object if the projectile is off screen
		//so that we don't throw errors.
		xlocation+=10;
	}
	
}
