import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class UploadImageClass{
    public static ImageIcon UploadImage(int width,int height)throws Exception{
       JFileChooser uploadFile = new JFileChooser();
	   ImageIcon newIcon=null;
	   int fileSelected = uploadFile.showOpenDialog(null);
	   if(fileSelected == JFileChooser.APPROVE_OPTION){
	   BufferedImage image = null;
	   File f = uploadFile.getSelectedFile();
	   image = ImageIO.read(f);
	   ImageIcon icon = new ImageIcon(image);
	   Image img = icon.getImage();
	   Image newImg = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
	   newIcon = new ImageIcon(newImg);
      }
	  if(newIcon !=null){
		  return newIcon;
	  }
	  else{
		  return null;
	  }
	}
}


					