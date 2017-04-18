import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ThreadedDrawingPanel extends JPanel implements Runnable
{
    private int x = 50, y = 50, diameter = 100;
    private Random rand = new Random();
    private Thread myThread;
	// accelerating = false
    
    Image lander = Toolkit.getDefaultToolkit().getImage( "lander.jpg" );
    Image landerFire = Toolkit.getDefaultToolkit().getImage( "landerfire.jpg" );
	
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        // Image file = lander
		
		// if accelerating
			// file = landerFire
		// else
			// file = lander
		
		// draw(file, x, y, this)
			
        g.drawOval( x, y, diameter, diameter );
    }
    
    public void run()
    {
        while ( myThread != null )
        {
			//max should be 0 
			//min should be max size of the window 
			
			// check if accelerating and y > max
				// accelerating = false
			// else if !accelerating and y < min
				// accelerating = true
				
			// if accelerating
				// decrease y
			// else
				// increase y
			
			           
            repaint();
            
            try
            {
                Thread.sleep( 5 );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        } // while
    } // run
    
    public void startAnimation()
    {
        if ( myThread == null )
        {
            myThread = new Thread( this );
            myThread.start();
        }
    }
    
    public void stopAnimation()
    {
        myThread = null;
    }
}
      