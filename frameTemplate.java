import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class frameTemplate extends JFrame{
	public frameTemplate(JPanel p){
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
	    }
		add(p);
		setVisible(true);
		setSize(450,300);
		setLocation(300,300);
		setResizable(true);
	}
}