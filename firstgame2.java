import javax.swing.*;
import java.awt.*;

public class firstgame2 extends JPanel
{
	
	public firstgame2()
	{
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image hell = Toolkit.getDefaultToolkit().createImage("src/hell.jpg");
		g.drawImage(hell, 0, 0, null); 
		g.setFont(new java.awt.Font("Serif", 1, 100));
		g.drawString("YOU LOSE", 700, 450);

	}
	
}