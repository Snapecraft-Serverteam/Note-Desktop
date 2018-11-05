package Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.11.2018
 * @author 
 */

@SuppressWarnings("serial")
public class Interface extends JFrame {
  // Anfang Attribute
  private JButton Notizen = new JButton();
    private ImageIcon NotizenIcon = new ImageIcon(getClass().getResource("/Notizen.png"));
  // Ende Attribute
  
  public Interface() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 641; 
    int frameHeight = 321;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Interface");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    cp.setBackground(Color.GRAY);
    Notizen.setBounds(49, 35, 131, 33);
    Notizen.setText("");
    Notizen.setMargin(new Insets(2, 2, 2, 2));
    Notizen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Notizen_ActionPerformed(evt);
      }
    });
    Notizen.setIcon(NotizenIcon);
    cp.add(Notizen);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Interface
  
  // Anfang Methoden
  
  public void main(String[] args) {
    new Interface();
  } // end of main
  
  public void Notizen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of Notizen_ActionPerformed

  // Ende Methoden
} // end of class Interface
