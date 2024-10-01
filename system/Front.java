
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Front extends JFrame implements ActionListener
{
    
    Front()
    {
      getContentPane().setBackground(Color.gray.brighter());
      
      JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
      heading.setFont(new Font("algerian",Font.BOLD,60));
      heading.setForeground(Color.black);
      add(heading);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front5.jpeg"));
      Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0, 0, 1170, 850);
      add(image);
      
      JButton B1=new JButton("CLICK HERE TO CONTINUE");
      B1.setBounds(400,400,300,70);
      B1.setBackground(Color.black);
      B1.setForeground(Color.white.darker());
      B1.setFont(new Font("arial",Font.BOLD,15));
      B1.setFocusable(false);
      B1.addActionListener(this);
      image.add(B1);
      
      setLayout(null);
      heading.setBounds(100,30,1200,60);
      setSize(1170,850);
      setLocation(350,80);
      
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       setVisible(false);
       new login();
    }
    
   public static void main(String args[]) 
   {
       new Front();
   }
}
