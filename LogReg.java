import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LogReg extends JTabbedPane{
	public LogReg(){
		addTab("Login",new loginComponent());
		addTab("Register",new registerComponent());
	}
}