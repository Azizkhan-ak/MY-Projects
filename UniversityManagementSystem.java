
package university.management.system;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;


public class UniversityManagementSystem extends Thread{
// public static String Day,Month,Year; 
public  static JFrame homepage;
public static Connection con;
public static Statement st;
public static boolean bool=false;
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        
        
        
        
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/UMS","root","123456789");
            st=con.createStatement();
        
        
        
        
        Container c;
        homepage=new JFrame("University Management System");
       ImageIcon i=new ImageIcon("‪E:/eidulfitr/d3.jpg");
       
        c=homepage.getContentPane();
      
        c.setBackground(Color.black);
        int h,w=350;
        
        int x=350,y=200;
        JLabel dawood=new JLabel("Dawood University Management System");
        dawood.setBounds(170,250,1200,100);
        dawood.setForeground(Color.red);
        dawood.setFont(new Font("aa",Font.BOLD,50));
        c.add(dawood);
        
        for(h=250;h<=740;h=h+54)
        {
        
        
        w=w+120;
        homepage.setBounds(x,y, w, h);
        
        homepage.setLayout(null);
        homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
    homepage.setIconImage(ii.getImage());
        homepage.setVisible(true);
        x=x-40;
        y=y-22;
        Thread.sleep(100);
        }
        
    Login lo=new Login(); 
    if(bool)
    {
        
    
    JMenuBar homemenubar=new JMenuBar();
    
    
    JMenu Student =new JMenu("Student");
    JMenuItem Admission=new JMenuItem("Admission");
    JMenuItem Exclusion=new JMenuItem("Exclusion");
    JMenuItem Dataofstudent=new JMenuItem("Data Of Student");
    JMenuItem Listofstudent=new JMenuItem("List Of Students");
    Student.add(Admission);
    Student.add(Exclusion);
    Student.add(Dataofstudent);
    Student.add(Listofstudent);
    homemenubar.add(Student);
    Admission.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            new Admission();
        }
    });
    Exclusion.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            //new Exclusion(Day,Month,Year);this is not used
            new Exclusion();
        }
    });
    Dataofstudent.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            new DataOfStudent();
        }
    });
    Listofstudent.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            try {
                new ListOfStudents();
            } catch (SQLException ex) {
                Logger.getLogger(UniversityManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        /* NewJFrame()
         {
             
         }*/
        
        }
    });
    JMenu Teacher=new JMenu("Teacher");
    JMenuItem AddTeacher=new JMenuItem("Add Teacher");
    JMenuItem RemoveTeacher=new JMenuItem("Remove Teacher");
    JMenuItem TeacherData=new JMenuItem("Teacher's Information");
    JMenuItem Listofteacher=new JMenuItem("List of Teachers");
    Teacher.add(AddTeacher);
    Teacher.add(RemoveTeacher);
    Teacher.add(TeacherData);
    Teacher.add(Listofteacher);
    homemenubar.add(Teacher);
    AddTeacher.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            new AddTeacher();
        }
    });
    RemoveTeacher.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            new RemoveTeacher();
        }
    });
    TeacherData.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            new TeacherInformation();
        }
    });
    Listofteacher.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            try {
                new TeachersList();
            } catch (SQLException ex) {
                Logger.getLogger(UniversityManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    homepage.setJMenuBar(homemenubar);
    homepage.setVisible(true);
  }
    
 else
    {
        homepage.dispose();
    }
}

}