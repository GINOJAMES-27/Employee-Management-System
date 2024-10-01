package employee.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener
{
 
    JTextField tedu,tname,tfname,taddress,tphone,temail,tsalary,tdes;
    JLabel lempid;
    JButton add,back;
    String empid;
    Choice cempid;
    JComboBox cbedu;
    
    UpdateEmployee()
    {
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel search = new JLabel("SEARCH EMP_ID");
       search.setFont(new Font("arial",Font.PLAIN,18));
       search.setBounds(40, 100, 150, 20);
       add(search);
        
        cempid = new Choice();
        cempid.setBounds(220, 100, 150, 20);
        add(cempid);
        
        try
        {
            conn c= new conn();
            String query = "select *from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
       
       JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
       heading.setBounds(280, 30, 500, 50);
       heading.setFont(new Font("algerian",Font.BOLD,25));
       add(heading);
       
       JLabel name = new JLabel("Name");
       name.setBounds(50, 150, 150, 30);
       name.setFont(new Font("arial",Font.BOLD,18));
       add(name);
       
       JLabel lname = new JLabel();
       lname.setFont(new Font("arial",Font.BOLD,15));
       lname.setBounds(200, 150, 150, 30);
       add(lname);
       
       JLabel fname = new JLabel("Father's Name");
       fname.setBounds(400, 150, 150, 30);
       fname.setFont(new Font("arial",Font.BOLD,18));
       add(fname);
       tfname = new JTextField();
       tfname.setFont(new Font("arial",Font.BOLD,15));
       tfname.setBounds(600, 150, 150, 30);
       add(tfname);
       
       JLabel dob = new JLabel("Date of Birth");
       dob.setBounds(50, 200, 150, 30);
       dob.setFont(new Font("arial",Font.BOLD,18));
       add(dob);
       JLabel ldob = new JLabel();
       ldob.setFont(new Font("arial",Font.BOLD,15));
       ldob.setBounds(200, 200, 150, 30);
       add(ldob);
       
       JLabel salary = new JLabel("Salary");
       salary.setBounds(400, 200, 150, 30);
       salary.setFont(new Font("arial",Font.BOLD,18));
       add(salary);
       tsalary = new JTextField();
       tsalary.setFont(new Font("arial",Font.BOLD,15));
       tsalary.setBounds(600, 200, 150, 30);
       add(tsalary);
       
       JLabel address = new JLabel("Address");
       address.setBounds(50, 250, 150, 30);
       address.setFont(new Font("arial",Font.BOLD,18));
       add(address);
       
       taddress = new JTextField();
       taddress.setFont(new Font("arial",Font.BOLD,15));
       taddress.setBounds(200, 250, 150, 30);
       add(taddress);
       
       JLabel phone = new JLabel("Phone");
       phone.setBounds(400, 250, 150, 30);
       phone.setFont(new Font("arial",Font.BOLD,18));
       add(phone);
       
       tphone = new JTextField();
       tphone.setFont(new Font("arial",Font.BOLD,15));
       tphone.setBounds(600, 250, 150, 30);
       add(tphone);
       
       JLabel email = new JLabel("Email");
       email.setBounds(50, 300, 150, 30);
       email.setFont(new Font("arial",Font.BOLD,18));
       add(email);
       
       temail = new JTextField();
       temail.setFont(new Font("arial",Font.BOLD,15));
       temail.setBounds(200, 300, 150, 30);
       add(temail);
       
       JLabel edu = new JLabel("Education");
       edu.setBounds(400, 300, 150, 30);
       edu.setFont(new Font("arial",Font.BOLD,18));
       add(edu);
      
       String courses[] = {"BTech","BCA","BBA","BSc","MTech","MCA","MBA","MSc","+2"};
       
       cbedu = new JComboBox(courses);
       cbedu.setBackground(Color.WHITE);
       cbedu.setFont(new Font("arial",Font.BOLD,15));
       cbedu.setBounds(600, 300, 150, 30);
       add(cbedu);
       
       tedu = new JTextField();
       tedu.setBackground(Color.WHITE);
       tedu.setFont(new Font("arial",Font.BOLD,15));
       tedu.setBounds(600, 300, 150, 30);
       add(tedu);
       
       JLabel des = new JLabel("Designation");
       des.setBounds(50, 350, 150, 30);
       des.setFont(new Font("arial",Font.BOLD,18));
       add(des);
       
       tdes = new JTextField();
       tdes.setFont(new Font("arial",Font.BOLD,15));
       tdes.setBounds(200, 350, 150, 30);
       add(tdes);
       
       lempid = new JLabel("Employee ID");
       lempid.setBounds(400, 350, 150, 30);
       lempid.setFont(new Font("arial",Font.BOLD,18));
       add(lempid);
       
       lempid = new JLabel();
       lempid.setBounds(600, 350, 150, 30);
       lempid.setFont(new Font("arial",Font.BOLD,15));
       add(lempid);
       
       cbedu.addItemListener(new ItemListener() 
       {
    public void itemStateChanged(ItemEvent ie) 
    {
        tedu.setText(cbedu.getSelectedItem().toString());
    }
    });

       
       try
       {
          conn c = new conn();
          String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
              lname.setText(rs.getString("name"));
              tfname.setText(rs.getString("fname"));
              ldob.setText(rs.getString("dob"));
              taddress.setText(rs.getString("address"));
              tsalary.setText(rs.getString("salary"));
              tphone.setText(rs.getString("phone"));
              temail.setText(rs.getString("email"));
              tedu.setText(rs.getString("education"));
              tdes.setText(rs.getString("designation"));
              lempid.setText(rs.getString("empid"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       cempid.addItemListener(new ItemListener()
       {
          public void itemStateChanged(ItemEvent ie)
          {
              try
              {
              conn c= new conn();
              String query = "select * from employee where empid ='"+cempid.getSelectedItem()+"'";
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next())
              {
              lname.setText(rs.getString("name"));
              tfname.setText(rs.getString("fname"));
              ldob.setText(rs.getString("dob"));
              taddress.setText(rs.getString("address"));
              tsalary.setText(rs.getString("salary"));
              tphone.setText(rs.getString("phone"));
              temail.setText(rs.getString("email"));
              tedu.setText(rs.getString("education"));
              tdes.setText(rs.getString("designation"));
              lempid.setText(rs.getString("empid"));
              }
            }
              catch(Exception e)
            {
                e.printStackTrace();
            }
          }
    });
       
       add = new JButton("Update Details");
       add.setBounds(250, 550, 150, 40);
       add.addActionListener(this);
       add.setFont(new Font("arial",Font.BOLD,15));
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550, 150, 40);
        back.addActionListener(this);
        back.setFont(new Font("arial",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
       
        setSize(900,700);
        setLocation(500,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== add)
        {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email =temail.getText();
            String edu = tedu.getText();
            String des = tdes.getText();
            
            try
            {
                conn conn = new conn();
                String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+edu+"',designation='"+des+"' where empid ='"+cempid.getSelectedItem()+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated succesfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String []args)
    {
        new UpdateEmployee();
    }
}