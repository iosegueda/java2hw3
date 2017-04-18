//Iris Osegueda
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class HW3 extends JFrame implements ActionListener
{
    Container container;
    ImagePanel imageP;
    JPanel southPanel;
    JButton start, stop;

    public HW3()
    {
        super( "Animation" );
        container = getContentPane();
		
        // using BorderLayout

        // create the components
        imageP = new ImagePanel();
		
        start = new JButton( "Start" );
        start.addActionListener( this );
		
        stop = new JButton( "Stop" );
        stop.setEnabled( false );
        stop.addActionListener( this );
		
        southPanel = new JPanel();
        southPanel.add( start );
        southPanel.add( stop );

        // add the components
        container.add( imageP );
        container.add( southPanel, BorderLayout.SOUTH );
		
        setSize( 500, 600 );
        setLocation( 200, 200 );
        setVisible( true );
    }

    // Event Handling code
    public void actionPerformed( ActionEvent ae )
    {
        // find the source of the event
        if ( ae.getSource() == start )
        {
            imageP.startAnimation();
            stop.setEnabled(true);
            start.setEnabled(false);
        }

        if ( ae.getSource() == stop )
        {
            imageP.stopAnimation();
            stop.setEnabled( false );
            start.setEnabled( true );
        }

    }

    // application
    public static void main( String[] args )
    {
        HW3 hw = new HW3();
        hw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }
}
