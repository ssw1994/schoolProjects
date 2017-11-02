import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

public class imageDemo extends JFrame implements ActionListener{
   public static void main(String args[]){
       new imageDemo();
   }
   JButton upLoad ;
   int addedImage = 0;
   JPanel display;
   boolean uploadedImage = false;
   public imageDemo(){
	   try{
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		   display = new JPanel(new FlowLayout());
		   upLoad = new JButton("UploadImage");
		   upLoad.addActionListener(this);
		   display.add(upLoad);
		   add(display);
           setSize(400,400);
           setVisible(true);
           setLocation(500,200);		   
	   }catch(Exception e){
		   JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
	   }
   }
   public void actionPerformed(ActionEvent ae){
	    try{
		    JFileChooser uploadFile = new JFileChooser();
			int fileSelected = uploadFile.showOpenDialog(null);
			if(fileSelected == JFileChooser.APPROVE_OPTION){
				BufferedImage image = null;
			    File f = uploadFile.getSelectedFile();
				image = ImageIO.read(f);
			    ImageIcon icon = new ImageIcon(image);
				Image img = icon.getImage();
				Image newImg = img.getScaledInstance(120, 120,Image.SCALE_SMOOTH);
				ImageIcon newIcon = new ImageIcon(newImg);
				JLabel label;
				if(uploadedImage == false){
				   label =new JLabel();
				   label .setIcon(newIcon);		 
			 	   label.setPreferredSize(new Dimension(150, 100));
				   label.setLocation(27, 20);
				   display.add(label);
				   this.revalidate();	
				   uploadedImage = true;
				}
				else{
				   label = new JLabel();
				   label .setIcon(newIcon);		 
			 	   label.setPreferredSize(new Dimension(150, 100));
				   label.setLocation(27, 20);
				   display.add(label);
				   this.revalidate();	
				   uploadedImage = true;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}