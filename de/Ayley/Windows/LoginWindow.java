package Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Interface.Interface;
import MySQL.MySQL;
import MySQL.MySQLUser;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.11.2018
 * @author 
 */

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {
  // Anfang Attribute
    private JButton jButton1 = new JButton();
    private ImageIcon jButton1Icon = new ImageIcon(getClass().getResource("/Login.png"));
    private JButton jButton2 = new JButton();
    private ImageIcon jButton2Icon = new ImageIcon(getClass().getResource("/Schlieﬂen.png"));
    private JLabel username = new JLabel();
    private JLabel lPassword = new JLabel();
    private JTextField tfMinecraftName = new JTextField();
    private JTextField tPassword = new JTextField();
  // Ende Attribute
  
  public LoginWindow() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 499; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("LoginWindow");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    cp.setBackground(Color.GRAY);
    jButton1.setBounds(49, 190, 123, 33);
    jButton1.setText("");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFocusPainted(true);
    jButton1.setIcon(jButton1Icon);
    cp.add(jButton1);
    jButton2.setBounds(313, 190, 123, 33);
    jButton2.setText("");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jButton2.setIcon(jButton2Icon);
    cp.add(jButton2);
    username.setBounds(40, 20, 150, 20);
    username.setText("MinecraftName");
    username.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 18));
    username.setForeground(Color.BLACK);
    cp.add(username);
    tfMinecraftName.setBounds(169, 20, 140, 20);
    tfMinecraftName.setBackground(Color.GRAY);
    tfMinecraftName.setText("MinecraftName");
    tfMinecraftName.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 16));
    tfMinecraftName.setForeground(Color.BLACK);
    tfMinecraftName.setToolTipText("Hier deinen Minecraft Namen eingeben");
    cp.add(tfMinecraftName);
    
    lPassword.setBounds(40, 60, 150, 20);
    lPassword.setText("Password");
    lPassword.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 18));
    lPassword.setForeground(Color.BLACK);
    cp.add(lPassword);
    
    tPassword.setBounds(169, 60, 140, 20);
    tPassword.setBackground(Color.GRAY);
    tPassword.setText("Passwort");
    tPassword.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 16));
    tPassword.setForeground(Color.BLACK);
    tPassword.setToolTipText("Hier deinen Passwort eingeben");
    cp.add(tPassword);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public LoginWindow
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new LoginWindow();
    MySQL.connect();
    if(MySQL.isConnected()) {
    	MySQLUser.Table();
    	JOptionPane.showMessageDialog(null, "MySQL ist Verbunden", "MySQL", WindowConstants.DISPOSE_ON_CLOSE);
    }else {
    	JOptionPane.showMessageDialog(null, "MySQL ist nicht Verbunden", "MySQL", WindowConstants.DISPOSE_ON_CLOSE);
    }
	
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
	  String user = tfMinecraftName.getText();
	  String password = tPassword.getText();
	  if(MySQLUser.User(user)) {
		  if(MySQLUser.Password(password)) {
			  dispose();
			  new Interface().main(null);
		  }else {
			  JOptionPane.showMessageDialog(null, "Passwort oder Minecraft name ist Falsch!");
		  }
	  }else {
		  JOptionPane.showMessageDialog(null, "Passwort oder Minecraft name ist Falsch!");
	  }
	  
    
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
	 dispatchEvent(new WindowEvent( this, WindowEvent.WINDOW_CLOSING));
    
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class LoginWindow
