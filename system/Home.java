
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener
{
    JButton ad,view,update,remove,back;
    Home()
    {
        setLayout(null);
        
        //getContentPane().setBackground(Color.white);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home5.jpeg"));
        Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel h=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        h.setBounds(175,20,800,40);
        h.setFont(new Font("algerian",Font.BOLD,45));
        h.setForeground(Color.black);
        image.add(h);
        
        ad=new JButton("ADD EMPLOYEE");
        ad.setBounds(300,100,220,220);
        ad.setFocusable(false);
        ad.setBackground(Color.black);
        ad.setForeground(Color.white.darker());
        ad.setFont(new Font("arial",Font.BOLD,18));
        ad.addActionListener(this);
        image.add(ad);
        
        view=new JButton("VIEW EMPLOYEES");
        view.setBounds(560,100,220,220);
        view.setFocusable(false);
        view.setBackground(Color.black);
        view.setForeground(Color.white.darker());
        view.addActionListener(this);
        view.setFont(new Font("arial",Font.BOLD,18));
        
        image.add(view);
        
        update=new JButton("UPDATE EMPLOYEE");
        update.setBounds(300,340,220,220);
        update.setFocusable(false);
        update.setBackground(Color.black);
        update.setForeground(Color.white.darker());
        update.setFont(new Font("arial",Font.BOLD,18));
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("REMOVE EMPLOYEE");
        remove.setBounds(560,340,220,220);
        remove.setFocusable(false);
        remove.setBackground(Color.black);
        remove.setForeground(Color.white.darker());
        remove.setFont(new Font("arial",Font.BOLD,18));
        remove.addActionListener(this);
        image.add(remove);
        
        
        back=new JButton("<<BACK");
        back.setBounds(10,540,150,40);
        back.setFocusable(false);
        back.setBackground(Color.black);
        back.setForeground(Color.white.darker());
        back.setFont(new Font("arial",Font.BOLD,12));
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(1120,630);
        setLocation(350,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ad)
        {
           setVisible(false);
           new AddEmployee();
        }
        else if(e.getSource()==view)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else if(e.getSource()==update)
        {
            setVisible(false);
            new UpdateEmployee();
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Front();
        }
        else
        {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    
    
    
    
    public static void main(String[] args)
    {
        new Home();
    }
}
