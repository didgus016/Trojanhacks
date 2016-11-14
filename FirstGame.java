import java.awt.*;//import all the libraries needed
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.Timer;

public class FirstGame extends JFrame implements KeyListener
{
		Mario m = new Mario();
		firstgame2 f = new firstgame2();
		
		public static void main(String[] args)
		{
			FirstGame game = new FirstGame();
		}
	
		public FirstGame()
		{
			super("ACMBoardDodge");
			addKeyListener(this);
            setSize(1400,900); //fit the entire screen 
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setContentPane(new JLabel(new ImageIcon("src/tree.png")));
            setLocation(0,0); //set location to 0,0
            setResizable(true); //this will not be resizable
            setLayout(null);
            m.setBounds(0,0,100,100);
            add(m);
            int i = 0;
            setVisible(true); // set visible to true
            while(m.getAlive() == true)
            {
            	int score = 0;
            	Projectile p = new Projectile();
            	int y = (int)((Math.random()) * 900);
            	if (y > 800)
            	{
            		y = 800;
            	}
            	p.setBounds(1400, y, 100, 100);
            	p.xlocation = 1300;
            	add(p);
            	while(p.xlocation+100 > 0 && m.alive)
            	{
            		System.out.println("step");
            		try{
            			Thread.sleep(10);
            			
            		}catch (InterruptedException ie) {
            			System.out.println(ie.getMessage());
            		}
            		int currentx = p.xlocation;
            		p.xlocation -= 10;
            		p.setBounds(currentx, y, 100, 100);
            		//Dead Logic
            		if (((m.xlocation + 100 > currentx) && (m.xlocation + 100 < currentx + 100))
            			|| ((m.xlocation > currentx) && (m.xlocation < currentx + 100)))
            		{
            			if (((m.ylocation + 100 > y) && (m.ylocation + 100 < y + 100))
                    			|| ((m.ylocation > y) && (m.ylocation < y + 100)))
            			{
            				m.alive = false;
            				remove(p);
            				score = m.score;
            			}
            		 }
            		p.revalidate();
            	}
            	//Remove p
            	remove(p);
            	m.score += 10;
            	}
            
            if(!m.alive)
            {
            	m.removeAll();
            	repaint();
            	setContentPane(new JLabel(new ImageIcon("src/hell.jpg")));
            	add(f);
            	repaint();
            }
           
        }
		
		public void keyReleased(KeyEvent evt){}
		public void keyTyped(KeyEvent evt){}
		public void keyPressed(KeyEvent evt)
		{
			if(evt.getKeyCode() == KeyEvent.VK_DOWN){
				if((Mario.ylocation+10 < 800))
				{
					Mario.ylocation+=10;
				}
			}
			else if(evt.getKeyCode() == KeyEvent.VK_UP)
			{
				if( (Mario.getYLocation()-10) > 0)
					Mario.ylocation-=10;
			}
			//If the person said right
			else if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if( (Mario.xlocation+10) < 1300)
				{
					Mario.xlocation+=10;
				} // if left
			}
			else if(evt.getKeyCode() == KeyEvent.VK_LEFT)
			{
					if( (Mario.xlocation-10) > 0)
						Mario.xlocation-=10;
			}	
		
			int xloc = Mario.xlocation;
			int yloc = Mario.ylocation;
			if(!(xloc > 1300 || xloc < 0 || yloc > 800 || yloc < 0))
				m.setBounds(xloc, yloc, 100,100);
			//if(Mario.xlocation == p.location && )
		 }
	}
