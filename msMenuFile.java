import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class msMenuFile implements ActionListener{
	JMenuBar schoolMenuBar;
	JMenu master,admission,Class,studentReports,account,stationary,exit,Look;
	JMenuItem feeHeads,feeStructure,Classes,subject;           // master MenuItem
	JMenuItem newAdmission,searchStudent;                      // admission MenuITem
	JMenuItem catalog,monthAttendance,newClass;   	// class MenuItem
	JMenuItem Accounts;             //Account MenuItem
	JMenuItem uploadImage,setLogo;
	ImageIcon returnIcon;
	schoolApp locApp;
	JButton setLogoDone;
	JTextField txtMainLogo,txtSubLogo;
	public msMenuFile(schoolApp app){
		locApp = app;
	}
	public JMenuBar createSchoolMenu(){	
		master = createMasterMenu();
	    admission = createAdmissionMenu();	
		Class = createClassMenu();
		Look = createLookMenu();
		account=createAccountMenu();
		schoolMenuBar = new JMenuBar();
		schoolMenuBar.add(master);
		schoolMenuBar.add(admission);
		schoolMenuBar.add(Class);
		schoolMenuBar.add(Look);
		schoolMenuBar.add(account);
		return schoolMenuBar;
	}
	public JMenu createMasterMenu(){
		JMenu temp = new JMenu("Master");
		feeHeads = new JMenuItem("Fees Heads");feeHeads.addActionListener(this);
		feeStructure = new JMenuItem("Fees Structure");feeStructure.addActionListener(this);
		Classes = new JMenuItem("Class");Classes.addActionListener(this);
		subject = new JMenuItem("Subject");subject.addActionListener(this);
		temp.add(feeHeads);temp.add(feeStructure);
		temp.add(Classes);temp.add(subject);
		return (temp);
	}
	public JMenu createAdmissionMenu(){
	   JMenu temp = new JMenu("Admission");
	   newAdmission = new JMenuItem("New Admission");newAdmission.addActionListener(this);
	   searchStudent = new JMenuItem("Search Student Record");searchStudent.addActionListener(this);	
	   temp.add(newAdmission);temp.add(searchStudent);
	   return temp;
	}
    public JMenu createClassMenu(){
		JMenu temp = new JMenu("Class");
		catalog = new JMenuItem("Catalog Management");catalog.addActionListener(this);
		monthAttendance = new JMenuItem("Monthly Attendance");monthAttendance.addActionListener(this);
		newClass = new JMenuItem("New Class");newClass.addActionListener(this);
		
		temp.add(catalog);temp.add(monthAttendance);
		temp.add(newClass);
		return temp;
	}	
	public JMenu createLookMenu(){
		JMenu temp = new JMenu("Look");
		uploadImage = new JMenuItem("Set Wallpaper");
		uploadImage.addActionListener(this);
		setLogo = new JMenuItem("Set Logo");
		setLogo.addActionListener(this);
		temp.add(uploadImage);
		temp.add(setLogo);
		return temp;
	}
	public JMenu createAccountMenu(){
		JMenu temp = new JMenu("Account");
		Accounts = new JMenuItem("Accounts");
		Accounts.addActionListener(this);
		temp.add(Accounts);
		return temp;
	}
	public void actionPerformed(ActionEvent ae){
		try{
			if(ae.getSource()==uploadImage){
				try{
					  ImageIcon newIcon = UploadImageClass.UploadImage(400,400);
					  locApp.setBackgroundImage(newIcon);
					}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ae.getSource() == setLogo){
				try{
					System.out.println("Inside setting Logo");
					JPanel temp = new JPanel();
					temp.setLayout(new GridLayout(3,2));
					temp.setPreferredSize(new Dimension(300,100));
					JLabel mainLogo,subLogo;
					mainLogo = new JLabel("Enter Logo :");
					subLogo =new JLabel("Enter subLogo");
					txtMainLogo = new JTextField(20);
					txtSubLogo = new JTextField(20);
					setLogoDone = new JButton("Done");
					setLogoDone.addActionListener(this);
					JFrame frame = new JFrame();
					temp.add(mainLogo);temp.add(txtMainLogo);
					temp.add(subLogo);temp.add(txtSubLogo);
					temp.add(setLogoDone);
					frame.add(temp);
					frame.setSize(300,150);
					frame.setVisible(true);
					frame.setLocation(300,300);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ae.getSource()==Accounts){
				try{
					new AccountMenu();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(ae.getSource()==newAdmission){
				try{
					JFrame admissionFrame = new JFrame();
					admissionFrame.setVisible(true);
					admissionFrame.setResizable(false);
					admissionFrame.setSize(570,500);
					admissionFrame.setLocation(300,200);
					admissionFrame.add(new studendAdmissionForm());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(ae.getSource() == setLogoDone){
				try{
					locApp.setLogo(txtMainLogo.getText(),txtSubLogo.getText());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}