
package university.management.system;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Login extends UniversityManagementSystem{
  
    String name="",passw="",dbname="",dbpass="";
    JFrame warning;
    JButton ok;
    Login()
    {
        Dialog login=new Dialog(homepage,"Admin Login",true);
        login.setLayout(null);
        login.setBounds(450,200,450,300);
        login.setBackground(Color.lightGray);
        ImageIcon icon=new ImageIcon("E:\\eidulfitr\\login4.jpg");
        JLabel loginimage=new JLabel(icon,JLabel.LEFT);
        loginimage.setBounds(20,100,100,100);
        login.add(loginimage);
        JLabel un=new JLabel("User Name");
        un.setBounds(150,90,80,50);
        un.setFont(new Font("aa",Font.BOLD,15));
        login.add(un);
        JTextField user=new JTextField(15);
        user.setBounds(250,97,150,30);
        
        login.add(user);
        
        JLabel pa=new JLabel("Password");
        pa.setBounds(150,140,80,50);
        pa.setFont(new Font("aa",Font.BOLD,15));
        login.add(pa);
        JPasswordField password=new JPasswordField(15);
        password.setBounds(250,147,150,30);
        password.setEchoChar('*');
        login.add(password);
        
        JButton submit=new JButton("Login");
        submit.setBounds(250,197,150,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        login.add(submit);
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                name=user.getText();
                passw=password.getText();
                try {
                    
                    ResultSet rs=st.executeQuery("select * from Login;");
                    rs.next();
                    dbname=rs.getString(1);
                    dbpass=rs.getString(2);
                   if(dbname.equals(name) && dbpass.equals(passw))
                   {
                       bool=true;
                       login.dispose();
                   }
                   else
                   {
                       homepage.dispose();
                       homepage.setVisible(false);
                      
                       warning=new JFrame("Warning");
                       warning.setLayout(null);
                       warning.setBounds(600,300,320,150);
                       warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       JLabel warn=new JLabel("your password or username was incorrect.");
                       warn.setBounds(30,10,250,40);
                       warning.add(warn);
                       ok=new JButton("Ok");
                       ok.setBounds(110,60,90,30);
                       warning.add(ok);
                       ok.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               warning.dispose();
                               homepage.dispose();
                           }
                       });
                       warning.setVisible(true);
                   }
                    
                } catch (SQLException ex) {
                    System.out.println("Something went wrong.........");
                }
                    
            }

        });
     
        login.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                
                
                homepage.dispose();
            }
        });
        login.setVisible(true);
        
    }
    
}
