
package university.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static university.management.system.UniversityManagementSystem.con;
import static university.management.system.UniversityManagementSystem.homepage;

public class DataOfStudent extends UniversityManagementSystem {
PreparedStatement pst;
int a=0;
String rn="";
JDialog valuenotfounddialog;
JLabel valuenotfoundmsg;
JButton valuenotfoundbut;
ResultSet rs1,rs2;
    public DataOfStudent()
    {
         JFrame dataofstudentframe=new JFrame("Admission");
         dataofstudentframe.setBounds(45,65,1200,600);
         ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
         dataofstudentframe.setIconImage(ii.getImage());
         dataofstudentframe.setVisible(true);
        
        //creating panel and its componen
        JPanel panel=new JPanel();
        panel.setBounds(50,60,1080,370);
        panel.setBackground(Color.blue);
        panel.setLayout(null);
        panel.setVisible(false);
       JLabel lsfname=new JLabel("Student First Name");
       lsfname.setBounds(55,65,200,40);
       lsfname.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsfname);
       JLabel lslname=new JLabel("Student Last Name");
       lslname.setBounds(55,120,200,40);
       lslname.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lslname);
      /* JLabel lsDob=new JLabel("Student DateOfBirth");
       lsDob.setBounds(55,165,200,40);
       lsDob.setFont(new Font("aa",Font.BOLD,15));
       dataofstudentframe.add(lsDob);*/
      
       JLabel lsGender=new JLabel("Student Gender");
       lsGender.setBounds(55,170,200,40);
       lsGender.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsGender);
       JLabel lsmail=new JLabel("Student Mail");
       lsmail.setBounds(55,225,200,40);
       lsmail.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsmail);
       JLabel lsPhone=new JLabel("Student Phone");
       lsPhone.setBounds(55,275,200,40);
       lsPhone.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsPhone);
       JLabel lsaddress=new JLabel("Student Address");
       lsaddress.setBounds(55,320,200,40);
       lsaddress.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsaddress);
       JTextField fname=new JTextField(30);
       fname.setBounds(260,65,250,30);
       fname.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent ke)
            {
                
                char c=ke.getKeyChar();
                if((c>'z')||(c<'A'))
                {
                    
                    ke.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                
            }
        });
        panel.add(fname);
       JTextField lname=new JTextField(30);
       lname.setBounds(260,120,250,30);
       lname.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if((c>'z')||(c<'A'))
                {
                    ke.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                
            }
        });
       panel.add(lname);
     
       
       ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,170,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       panel.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,170,20,30);
       panel.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,170,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       panel.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,170,20,30);
       panel.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,170,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       panel.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,170,20,30);
       panel.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       
       
       JTextField tsmail=new JTextField(30);
       tsmail.setBounds(260,225,250,30);
       panel.add(tsmail);
       
       JTextField tsphone=new JTextField();
       tsphone.setColumns(11);
       tsphone.setBounds(260,275,250,30);
       panel.add(tsphone);
       tsphone.addKeyListener(new KeyAdapter()
       {
           public void keyTyped(KeyEvent ke)
           {
               char c=ke.getKeyChar();
               if(c<'0'||c>'9')
               {
                   ke.consume();
                   Toolkit.getDefaultToolkit().beep();
               }
           }
       });
       
       
       
       JTextArea tsaddress=new JTextArea();
       tsaddress.setBounds(260,320,250,100);
       panel.add(tsaddress);
       
      
       
       JLabel lscnic=new JLabel("Student CNIC");
       lscnic.setBounds(580,120,200,40);
       lscnic.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lscnic);
       JTextField tscnic=new JTextField();
       tscnic.setBounds(755,120,250,30);
       panel.add(tscnic);
       JLabel lsinter=new JLabel("Intermediate %");
       lsinter.setBounds(580,165,200,40);
       lsinter.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsinter);
       JTextField tsinter=new JTextField();
       tsinter.setBounds(755,165,250,30);
       panel.add(tsinter);
       JLabel lsMetric=new JLabel("Metric %");
       lsMetric.setBounds(580,210,200,40);
       lsMetric.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsMetric);
       JTextField tsmetric=new JTextField();
       tsmetric.setBounds(755,210,250,30);
       panel.add(tsmetric);
       JLabel lsdepartment=new JLabel("Department");
       lsdepartment.setBounds(580,255,200,40);
       lsdepartment.setFont(new Font("aa",Font.BOLD,15));
       panel.add(lsdepartment);
       JComboBox csdepartment=new JComboBox();
       csdepartment.addItem("Computer System Engineering");
       csdepartment.addItem("Electronics Engineering");
       csdepartment.addItem("Chemical Engineering");
       csdepartment.addItem("Architecture and Planning");
       csdepartment.addItem("Metallurgy and Material Engineering");
       csdepartment.addItem("Energy and Environment Engineering");
       csdepartment.addItem("Industrial Engineering");
       csdepartment.addItem("Petroleum and Gas Engineering");
       csdepartment.addItem("Telecommunication Engineering");
       csdepartment.setBounds(755,255,250,30);
       panel.add(csdepartment);
       JTextField panelroll=new JTextField();
       panelroll.setBounds(755,300,250,30);
       JLabel panelrolllabel=new JLabel("Roll NO.");
      panelrolllabel.setBounds(580,300,200,40);
       panelrolllabel.setFont(new Font("aa",Font.BOLD,15));
       
      
        
        
        dataofstudentframe.setLayout(null);
        Container c=dataofstudentframe.getContentPane();
        c.setBackground(Color.green);
        dataofstudentframe.add(panel);
        dataofstudentframe.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent we)
           {
               dataofstudentframe.dispose();
           }
       });
     
       //search button coding..............................
       ////////////////////////////||||||||||||||||?/////////////////
       
       
       JLabel lsroll=new JLabel("Search Student's Roll No.");
       lsroll.setBounds(55,450,450,40);
       lsroll.setFont(new Font("aa",Font.BOLD,30));
       
       dataofstudentframe.add(lsroll);
       JTextField tsroll=new JTextField();
       tsroll.setBounds(470,452,300,40);
       dataofstudentframe.add(tsroll);
       JButton search =new JButton("Search");
       search.setBounds(780,452,100,40);
       search.setBackground(Color.black);
       search.setForeground(Color.white);
       dataofstudentframe.add(search);
       
       search.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               
               
               try {
                   rn=tsroll.getText();
                   panelroll.setText(rn);
                   
                   st=con.createStatement();
                   rs1=st.executeQuery("SELECT Sroll FROM Admission;");
                   while(rs1.next())
                   {
                       if(rn.equals(rs1.getString("Sroll")))
                           a=1;
                         //  break;
                       
                   }
                   if(a==1)
                   {
                   System.out.println("1");
                   panel.setVisible(true);
                   rn=tsroll.getText();
                   
                   pst=con.prepareStatement("select * from Admission where Sroll=?");
                   pst.setString(1,rn);
                   ResultSet rs2=pst.executeQuery();
                   rs2.next();
                   
                   
                   
                   fname.setText(rs2.getString("Sfname"));
                   lname.setText(rs2.getString("Slname"));
                   if(rs2.getString("Sgender").equals("Male"))
                   {
                   male.setSelected(true);
                   }
                   else if(rs2.getString("Sgender").equals("Female"))
                   {
                   female.setSelected(true);
                   }
                   else
                   {
                   other.setSelected(true);
                   }
                   tsmail.setText(rs2.getString("Smail"));
                   tsphone.setText(rs2.getString("Sphone"));
                   tscnic.setText(rs2.getString("Scnic"));
                   tsaddress.setText(rs2.getString("Saddress"));
                   tsinter.setText(rs2.getString("Sinter"));
                   tsmetric.setText(rs2.getString("Smetric"));
                   csdepartment.setSelectedItem(rs2.getString("Sdepartment"));
                   panel.add(panelroll);
                   panel.add(panelrolllabel);
                   panel.setVisible(true);
                   tsroll.setVisible(false);
                   search.setVisible(false);
                   lsroll.setVisible(false);
                   dataofstudentframe.add(panel);
                   dataofstudentframe.setVisible(true);
                   }
                   else
                   {
                       System.out.println("0");
                       
                       panel.setVisible(false);
                   valuenotfounddialog=new JDialog(dataofstudentframe,"Warning",true);
                   valuenotfounddialog.setBounds(400,250,350,150);
                   valuenotfounddialog.setLayout(null);
                   Container c=valuenotfounddialog.getContentPane();
                   c.setBackground(Color.lightGray);
                   valuenotfoundmsg=new JLabel("Entered roll no. does not exist.");
                   valuenotfoundmsg.setBounds(100,20,400,20);
                   valuenotfounddialog.add(valuenotfoundmsg);
                   valuenotfoundbut=new JButton("Ok");
                   valuenotfoundbut.setBounds(125,60,100,30);
                   valuenotfoundbut.setBackground(Color.black);
                   valuenotfoundbut.setForeground(Color.white);
                   valuenotfounddialog.add(valuenotfoundbut);
                   
                   
                   valuenotfoundbut.addActionListener(new ActionListener()
                   {
                   public void actionPerformed(ActionEvent ae)
                   {
                   valuenotfounddialog.dispose();
                   }
                   });
                   valuenotfounddialog.setVisible(true);
                   }
                   
                   
                   
                   /*
                   
                   
                   try {
                   st=con.createStatement();
                   ResultSet rs=st.executeQuery("select Sroll from Admission;");
                   rs.next();
                   while(rs.next())
                   {
                   if(tsroll.getText().equals(rs.getString("Sroll")))
                   {
                   a=1;
                   
                   }
                   
                   }
                   
                   
                   //AFter while LOOP.......................
                   //////////////////////////////////////
                   /////////////////////////////////////////////////////////////
                   if(a==1)
                   {
                   
                   System.out.println(1);
                   /*
                   panel.setVisible(true);
                   rn=tsroll.getText();
                   
                   pst=con.prepareStatement("select * from Admission where Sroll=?");
                   pst.setString(1,rn);
                   ResultSet rs2=pst.executeQuery();
                   rs2.next();
                   
                   
                   
                   fname.setText(rs2.getString("Sfname"));
                   lname.setText(rs2.getString("Slname"));
                   if(rs2.getString("Sgender").equals("Male"))
                   {
                   male.setSelected(true);
                   }
                   else if(rs2.getString("Sgender").equals("Female"))
                   {
                   female.setSelected(true);
                   }
                   else
                   {
                   other.setSelected(true);
                   }
                   tsmail.setText(rs2.getString("Smail"));
                   tsphone.setText(rs2.getString("Sphone"));
                   tscnic.setText(rs2.getString("Scnic"));
                   tsaddress.setText(rs2.getString("Saddress"));
                   tsinter.setText(rs2.getString("Sinter"));
                   tsmetric.setText(rs2.getString("Smetric"));
                   csdepartment.setSelectedItem(rs2.getString("Sdepartment"));
                   panel.setVisible(true);
                   dataofstudentframe.add(panel);
                   dataofstudentframe.setVisible(true);
                   }
                   else
                   {
                   
                   System.out.println(0);
                   
                   
                   panel.setVisible(false);
                   valuenotfounddialog=new JDialog(dataofstudentframe,"Warning",true);
                   valuenotfounddialog.setBounds(400,250,350,150);
                   valuenotfounddialog.setLayout(null);
                   Container c=valuenotfounddialog.getContentPane();
                   c.setBackground(Color.lightGray);
                   valuenotfoundmsg=new JLabel("Entered roll no. does not exist.");
                   valuenotfoundmsg.setBounds(100,20,400,20);
                   valuenotfounddialog.add(valuenotfoundmsg);
                   valuenotfoundbut=new JButton("Ok");
                   valuenotfoundbut.setBounds(125,60,100,30);
                   valuenotfoundbut.setBackground(Color.black);
                   valuenotfoundbut.setForeground(Color.white);
                   valuenotfounddialog.add(valuenotfoundbut);
                   
                   
                   valuenotfoundbut.addActionListener(new ActionListener()
                   {
                   public void actionPerformed(ActionEvent ae)
                   {
                   valuenotfounddialog.dispose();
                   }
                   });
                   valuenotfounddialog.setVisible(true);
                   
                   
                   }
                   
                   
                   }       catch (SQLException ex) {
                   Logger.getLogger(DataOfStudent.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   
                   panel.setVisible(false);
                   dataofstudentframe.setVisible(true);
                   
                   
               */  } catch (SQLException ex) {
                   Logger.getLogger(DataOfStudent.class.getName()).log(Level.SEVERE, null, ex);
               }
}});
    }}
       




















                       
                     
                   
                   
              