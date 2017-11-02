import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AccountMenu extends JFrame{
    public AccountMenu(){
		Container container = getContentPane();
		try{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			container.setBackground(new Color(10,15,200));
			container.add(new LogReg());
			setSize(400,350);
			
			setVisible(true);
			setLocation(400,200);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new AccountMenu();
	}
}