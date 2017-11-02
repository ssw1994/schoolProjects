import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class registerComponent extends JPanel implements ActionListener{
   JTextField txtUser,txtPass,txtMobile,txtEmail,txtRepass,txtDob;
   JButton Register;
   public registerComponent(){
	   add(InitGUI());
	   setPreferredSize(new Dimension(200,250));
	   setBackground(Color.cyan);
   }
   public JPanel InitGUI(){
	   JPanel temp = new JPanel();
	   temp.setLayout(new FlowLayout());
	   temp.setPreferredSize(new Dimension(300,220));
	   JPanel rightPane  = new JPanel();
	   rightPane.setBackground(new Color(140,160,180));
	   rightPane.setLayout(new GridLayout(6,1));
	   rightPane.setPreferredSize(new Dimension(200,180));
	   
	   JPanel leftPane = new JPanel();
	   leftPane.setBackground(new Color(140,160,180));
	   leftPane.setLayout(new GridLayout(6,1));
	   leftPane.setPreferredSize(new Dimension(80,180));
	   
	   JLabel name = new JLabel("UserName  ");
	   JLabel pass = new JLabel("Password   ");
	   JLabel mobile = new JLabel("Mobile  ");
	   JLabel email = new JLabel("Email  ");
	   JLabel repass = new JLabel("Repassword  ");
	   JLabel dob = new JLabel("D.O.B  ");
	   txtUser = new JTextField(20);
	   txtMobile = new JTextField(20);
	   txtEmail = new JTextField(20);
	   txtDob = new JTextField(20);
	   txtPass = new JTextField(20);
	   txtRepass = new JTextField(20);
	   Register = new JButton("Register");
	   Register.addActionListener(this);
	   temp.setLayout(new FlowLayout());
	   leftPane.add(name);rightPane.add(txtUser);
	   leftPane.add(mobile);rightPane.add(txtMobile);
	   leftPane.add(email);rightPane.add(txtEmail);
	   leftPane.add(dob);rightPane.add(txtDob);
	   leftPane.add(pass);rightPane.add(txtPass);
	   leftPane.add(repass);rightPane.add(txtRepass);
	   temp.add(leftPane);
	   temp.add(rightPane);
	   temp.add(Register);
	   temp.setBackground(new Color(140,160,180));
	   return temp;
   }
   
   public void actionPerformed(ActionEvent ae){
	   try{
		   System.out.println(ae.getActionCommand() + "Clickded");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
}