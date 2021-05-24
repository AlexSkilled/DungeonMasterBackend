package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserInterface extends JFrame{
	private static final long serialVersionUID = -6184788803882753965L;
	
	public UserInterface() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = getContentPane();
		JLabel label = null;
		try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            outerLoop:
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (networkInterface.getDisplayName().contains("Dual Band Wireless-AC")) {
            			label = new JLabel("IP подключения: " + addr.getHostAddress());
                    	break outerLoop;
                    }
                }
            }
        }
        catch (IOException e )
        {
        	label = new JLabel("Ошибка при попытке получить IP " + e.getMessage());
        }
	    
		pane.add(label);
		
	    setPreferredSize(new Dimension(200, 100));
	    
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);

        // calculate perfect center
        int perf_x = (int) x - 200/2;
        int perf_y = (int) y - 100/2;

        setLocation(perf_x, perf_y);
	    setVisible(true);    
	}
	
}
