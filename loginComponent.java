import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class loginComponent extends JPanel implements ActionListener{
	JButton login,signUp;
	JTextField txtuser,txtpass;
	public loginComponent(){
		setLayout(new FlowLayout());
		JLabel userName = new JLabel("Username");
		JLabel passWord = new JLabel("Password");
		txtuser = new JTextField(15);
		txtpass = new JTextField(15);
		login = new JButton("Login");login.addActionListener(this);
		signUp = new JButton("SignUp");signUp.addActionListener(this);
		setBackground(new Color(140,180,100));
		setPreferredSize(new Dimension(300,200));
        add(userName);add(txtuser);
        add(passWord);add(txtpass);
        add(login);add(signUp);	
        		
	}
	public void actionPerformed(ActionEvent ae){
		try{
			System.out.println(ae.getActionCommand() +  "Clikded");
		}catch(Exception e){
			
		}
	}
}