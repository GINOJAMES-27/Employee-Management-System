
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cempid;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lempid = new JLabel("EMP_ID");
        lempid.setFont(new Font("arial",Font.PLAIN,18));
        lempid.setBounds(50, 50, 100, 30);
        add(lempid);
        
        cempid = new Choice();
        cempid.setBounds(200, 50, 150, 30);
        add(cempid);
        
        try{
            conn c= new conn();
            String query = "select *from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("arial",Font.PLAIN,18));
        name.setBounds(50, 100, 100, 30);
        add(name);
        
        JLabel lname = new JLabel();
        lname.setFont(new Font("arial",Font.PLAIN,18));
        lname.setBounds(200, 100, 100, 30);
        add(lname);
        
        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("arial",Font.PLAIN,18));
        phone.setBounds(50, 150, 100, 30);
        add(phone);
        
        JLabel lphone = new JLabel();
        lphone.setFont(new Font("arial",Font.PLAIN,18));
        lphone.setBounds(200, 150, 100, 30);
        add(lphone);
        
        JLabel email = new JLabel("Email");
        email.setFont(new Font("arial",Font.PLAIN,18));
        email.setBounds(50, 200, 100, 30);
        add(email);
        
        JLabel lemail = new JLabel();
        lemail.setFont(new Font("arial",Font.PLAIN,18));
        lemail.setBounds(200, 200, 100, 30);
        add(lemail);
        
        try{
            conn c= new conn();
            String query = "select* from employee where empid ='"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lname.setText(rs.getString("name"));
                lphone.setText(rs.getString("phone"));
                lemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent ie){
              try{
                conn c= new conn();
                String query = "select * from employee where empid ='"+cempid.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    lname.setText(rs.getString("name"));
                    lphone.setText(rs.getString("phone"));
                    lemail.setText(rs.getString("email"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
          }
    });
        
        delete =new JButton("DELETE");
        delete.setBounds(80, 400, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back =new JButton("BACK");
        back.setBounds(220, 400, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpeg"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000,500);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == delete){
            try{
                conn c = new conn();
                String query ="delete from employee where empid ='"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Home(); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home(); 
        }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
