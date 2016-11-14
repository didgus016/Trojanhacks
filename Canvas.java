import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel
{
	public int xrange;
	public int yrange;
	
	public Canvas()
	{
		xrange = 1500;
		yrange = 1000;
		Mario character = new Mario();
		Projectile proj = new Projectile();
	}
	
}
	
