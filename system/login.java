
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener
{
    JTextField tu;
    JPasswordField tp;

    login()
    {
      getContentPane().setBackground(Color.white);
      setLayout(null);
      
      JLabel u=new JLabel("USERNAME");
      u.setBounds(40, 20,100, 30);
      add(u);
      
      tu=new JTextField();
      tu.setBounds(150,20,150,30);
      add(tu);
      
      JLabel p=new JLabel("PASSWORD");
      p.setBounds(40, 70,100, 30);
      add(p);
      
      tp=new JPasswordField();
      //tp.setEchoChar('*');
      tp.setBounds(150,70,150,30);
      add(tp);
      
      JButton B2=new JButton("LOGIN");
      B2.setBounds(150,140,150,30);
      B2.setBackground(Color.black);
      B2.setForeground(Color.white);
      B2.setFocusable(false);
      B2.addActionListener(this);
      add(B2);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
      Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(350, 0, 200, 200);
      add(image);
      
      
      
      
      
      setSize(600,300);
      setLocation(700,300);
      setVisible(true);
      
    }
    public void actionPerformed(ActionEvent e)
    {
       try
       {
          String username=tu.getText();
          String password=tp.getText();
          
          conn c=new conn();
          String query="select* from login where username= '"+username+"' and password='"+password+"'";
          
          ResultSet rs=c.s.executeQuery(query);
          if (rs.next())
          {
              setVisible(false);
              new Home();
          }
          else
          {
              JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD");
              setVisible(false);
          }
          
          
       }
       catch(Exception eb)
       {
           eb.printStackTrace();
       }
    }
    
    
    
    public static void main(String args[])
    {
        new login();
    }
}
