import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class schoolApp extends JFrame{
	public static void main(String args[]){
		new schoolApp();
	}
	//Border blackLine;
	JLabel image,logo,subLogo;
    JPanel container= new JPanel();
	JPanel logoPanel;
	msMenuFile menu = new msMenuFile(this);
	public schoolApp(){
		try{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			setJMenuBar(addSchoolMenu());
			setVisible(true);
			JPanel wallpaper = new JPanel();
			image = new JLabel();
			if(image.getText()==""){
				image.setText("No Wallpaper Selected");
				image.setFont(new Font("Console",Font.BOLD,20));
				image.setForeground(Color.white);
				image.setLocation(100,100);
			}
			JPanel loginWindow = new loginComponent();
			loginWindow.setBackground(new Color(140,180,100));
			loginWindow.setPreferredSize(new Dimension(300,200));
			wallpaper.add(image);
			wallpaper.setBackground(Color.black);
			wallpaper.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
			wallpaper.setPreferredSize(new Dimension(500,400));
			wallpaper.setLocation(100,50);
            container.setBackground(new Color(130,170,190));	
            container.add(createLogoPanel());			
			container.add(wallpaper,BorderLayout.CENTER);
			container.add(loginWindow,BorderLayout.EAST);
			container.setPreferredSize(new Dimension(900,600));
			add(container);
			setSize(1000,600);
			setLocation(200,100);
		}catch(Exception e){
			
		}
	}
	
	public JPanel createLogoPanel(){
		logoPanel = new JPanel();
		logoPanel.setLayout(new GridLayout(2,1));
		logoPanel.setBackground(new Color(130,170,190));
		logo = new JLabel();
		subLogo = new JLabel();
		logo.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,25));
		logo.setForeground(Color.red);
		subLogo.setFont(new Font("helvetica",Font.BOLD,18));
		subLogo.setForeground(Color.red);
		logoPanel.add(logo);logoPanel.add(subLogo);
		logoPanel.setVisible(false);
		logoPanel.setPreferredSize(new Dimension(500,80));
		return logoPanel;
	}
	public void setLogo(String mainLogo,String subLog){
		try{
			logo.setText(mainLogo);
			subLogo.setText(subLog);
			if(logo.getText().equals("") && subLogo.getText().equals("")){
				logoPanel.setVisible(false);
			}
			else{
				logoPanel.setVisible(true);
			}
			this.revalidate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public JMenuBar addSchoolMenu(){
	    return (menu.createSchoolMenu());
	}
	public void setBackgroundImage(ImageIcon icon){
		image.setIcon(icon);		 
	    image.setPreferredSize(new Dimension(500, 400));
		this.revalidate();
	}
	
}