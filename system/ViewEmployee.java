
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmployee extends JFrame implements ActionListener
{
    JTable table;
    Choice h;
    JButton search,print,back;
    
    
    ViewEmployee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l=new JLabel("SEARCH BY EMPLOYEE ID");
        l.setBounds(20,20,150,20);
        add(l);
        
        h=new Choice();
        h.setBounds(180,20,150,20);
        add(h);
        
        table=new JTable();
        
        try
        {
            conn c=new conn();
            ResultSet k=c.s.executeQuery("select * from employee");
            
            while(k.next())
            {
                h.add(k.getString("empid"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            conn c=new conn();
            ResultSet k=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(k));
            
            while(k.next())
            {
                h.add(k.getString("empid"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane p=new JScrollPane(table);
        p.setBounds(0,100,900,600);
        add(p);
        
        
        
        search =new JButton("SEARCH");
        search.setBounds(20,70,85,20);
        search.addActionListener(this);
        search.setFocusable(false);
        add(search);
        
        print =new JButton("PRINT");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        print.setFocusable(false);
        add(print);
        
        
        
        back =new JButton("BACK");
        back.setBounds(220,70,80,20);
        back.addActionListener(this);
        back.setFocusable(false);
        add(back);
        
        
        setSize(900,700);
        setLocation(500,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==search)
        {
            String query="select* from employee where empid='"+h.getSelectedItem()+"'";
            try  
            {
                conn n=new conn();
                ResultSet f=n.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(f));
            }
            catch(Exception o)
            {
                o.printStackTrace();
            }
        }
        else if(e.getSource()==print)
        {
            try
            {
               table.print();
            }
            catch(Exception j)
            {
                j.printStackTrace();
            }
        }
     
        else
        {
            setVisible(false);
            new Home();
        }
    }
    
    
    public static void main(String[] args)
    {
        new ViewEmployee();
    }
}
