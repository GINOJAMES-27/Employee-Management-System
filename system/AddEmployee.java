
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener
{
    Random ran=new Random();
    int num=ran.nextInt(999999);
    JButton add,back;
    JTextField tn,faname,tsalary,taddress,tphone,temail,tdes;
    JComboBox cbedu;
    JDateChooser dc;
    JLabel lempid;
    
    
    
    
    AddEmployee()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel h=new JLabel("ADD EMPLOYEE DETAILS");
        h.setBounds(310,30,500,50);
        h.setFont(new Font("algerian",Font.BOLD,25));
        add(h);
        
        JLabel ln=new JLabel("Name");
        ln.setBounds(50,150,150,30);
        ln.setFont(new Font("arial",Font.BOLD,18));
        add(ln);
        
        tn=new JTextField();
        tn.setFont(new Font("arial",Font.BOLD,15));
        tn.setBounds(200,150,150,30);
        add(tn);
        
        JLabel fn=new JLabel("Father's name");
        fn.setBounds(400,150,150,30);
        fn.setFont(new Font("arial",Font.BOLD,18));
        add(fn);
        
        faname=new JTextField();
        faname.setFont(new Font("arial",Font.BOLD,15));
        faname.setBounds(600,150,150,30);
        add(faname);
         
        
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("arial",Font.BOLD,18));
        add(dob);
        
        dc=new JDateChooser();
        dc.setFont(new Font("arial",Font.BOLD,15));
        dc.setBounds(200,200,150,30);
        add(dc);
        
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
       
       JLabel des = new JLabel("Designation");
       des.setBounds(50, 350, 150, 30);
       des.setFont(new Font("arial",Font.BOLD,18));
       add(des);
       
       tdes = new JTextField();
       tdes.setFont(new Font("arial",Font.BOLD,15));
       tdes.setBounds(200, 350, 150, 30);
       add(tdes);
       
       JLabel empid = new JLabel("Employee ID");
       empid.setBounds(400, 350, 150, 30);
       empid.setFont(new Font("arial",Font.BOLD,18));
       add(empid);
       
       lempid = new JLabel(""+num);
       lempid.setBounds(600, 350, 150, 30);
       lempid.setFont(new Font("arial",Font.BOLD,18));
       add(lempid);
       
       add = new JButton("Add Details");
       add.setBounds(250, 550, 150, 40);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
        
       back = new JButton("Back");
       back.setBounds(450,550, 150, 40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
        
        
        
        
        setSize(900,700);
        setLocation(500,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            String name = tn.getText();
            String fname = faname.getText();
            String dob =((JTextField) dc.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email =temail.getText();
            String education = (String)cbedu.getSelectedItem();
            String designation = tdes.getText();
            String empid = lempid.getText();
            
            try
            {
                conn con=new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+empid+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"DETAILS ADDED SUCCESSFULLY");
                setVisible(false);
                new Home();
            }
            catch(Exception g)
            {
                g.printStackTrace();
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
        new AddEmployee();
    }
}
