//Iris Osegueda
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ImagePanel extends JPanel implements Runnable
{
	private final int DELTA = 1;
	private final int LANDERHEIGHT = 38;
	private final int LANDERWIDTH = 50;
	
    private int minY = 0;
    private int maxY;
    private int x;
    private int y;
    
	private Thread myThread;
    
	private boolean accelerating = false;
	private boolean start = true;
    
	Image lander = Toolkit.getDefaultToolkit().getImage( "lander.jpg" );
    Image landerFire = Toolkit.getDefaultToolkit().getImage( "landerfire.jpg" );
	
    public void paintComponent( Graphics g )
    {
		super.paintComponent( g );
        setBackground(Color.black);

        Image file = lander;

        if (accelerating)
        {
            file = landerFire;
        }
        else
        {
            file = lander;
        }
		
		if(start)
		{
			maxY = getHeight() - LANDERHEIGHT;
            x = (getWidth() - LANDERWIDTH) / 2;
			y = maxY;
			start = false;
		}
        g.drawImage(file, x, y, this);
    }

    public void run()
    {
        while ( myThread != null )
        {

            maxY = getHeight() - LANDERHEIGHT;
            x = (getWidth() - LANDERWIDTH) / 2;
			
			if ( accelerating && y <= minY)
            {
                accelerating = false;
            }
            else if ( !accelerating && y >= maxY )
            {
                accelerating = true;
            }

            if ( accelerating )
            {
                y = ( y - DELTA );
            }
            else
            {
                y = ( y + DELTA );
            }

            if ( y < 0 )
            {
                y = 0;
            }
			else if ( y > maxY )
            {
                y = maxY;
            }

            repaint();

            try
            {
                Thread.sleep( 5 );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }

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
