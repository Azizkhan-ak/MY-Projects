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
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static university.management.system.UniversityManagementSystem.homepage;


public class Exclusion extends UniversityManagementSystem{
   public String rn,temp="null";   //temp variable for checking if desired roll num is found or not.
   ResultSet rs2;
   PreparedStatement pst;
   public JDialog valuenotfounddialog,rollnonotspecifieddialog,checkboxerror,successdialog;
   public JLabel valuenotfoundmsg,rollnonotspecifiedmsg,checkboxerrormsg,successmsg;
   public JButton valuenotfoundbut,rollnonotspecifiedbut,checkboxerrorbut,successbut;
   
   // public Exclusion(String Day,String Month,String Year) This is not Used.
   public Exclusion() 
   {
         JFrame exclusionframe=new JFrame("Exclusion");
        exclusionframe.setBounds(45,65,1200,600);
        exclusionframe.setLayout(null);
        Container c=exclusionframe.getContentPane();
        c.setBackground(Color.green);
      
        
         exclusionframe.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent we)
           {
               exclusionframe.dispose();
           }
       });
     


       
       JLabel lsfname=new JLabel("Student First Name");
       lsfname.setBounds(55,75,200,40);
       lsfname.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsfname);
       JLabel lslname=new JLabel("Student Last Name");
       lslname.setBounds(55,120,200,40);
       lslname.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lslname);
     //  JLabel lsDob=new JLabel("Student DateOfBirth");
       //lsDob.setBounds(55,165,200,40);
       //lsDob.setFont(new Font("aa",Font.BOLD,15));
       //exclusionframe.add(lsDob);
       JLabel lsGender=new JLabel("Student Gender");
       lsGender.setBounds(55,170,200,40);
       lsGender.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsGender);
       JLabel lsmail=new JLabel("Student Mail");
       lsmail.setBounds(55,220,200,40);
       lsmail.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsmail);
       JLabel lsPhone=new JLabel("Student Phone");
       lsPhone.setBounds(55,275,200,40);
       lsPhone.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsPhone);
       JLabel lsaddress=new JLabel("Student Address");
       lsaddress.setBounds(55,325,200,40);
       lsaddress.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsaddress);
       JTextField fname=new JTextField(30);
       fname.setBounds(260,80,250,30);
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
       exclusionframe.add(fname);
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
       exclusionframe.add(lname);
     
       ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,175,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,175,20,30);
       exclusionframe.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,175,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,175,20,30);
       exclusionframe.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,175,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,175,20,30);
       exclusionframe.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       
       
       JTextField tsmail=new JTextField(30);
       tsmail.setBounds(260,225,250,30);
       exclusionframe.add(tsmail);
       
       JTextField tsphone=new JTextField();
       tsphone.setColumns(11);
       tsphone.setBounds(260,275,250,30);
       exclusionframe.add(tsphone);
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
       tsaddress.setBounds(260,340,250,100);
       exclusionframe.add(tsaddress);
       
      
       JLabel lscnic=new JLabel("Student CNIC");
       lscnic.setBounds(580,120,200,40);
       lscnic.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lscnic);
       JTextField tscnic=new JTextField();
       tscnic.setBounds(755,120,250,30);
       exclusionframe.add(tscnic);
       JLabel lsinter=new JLabel("Intermediate %");
       lsinter.setBounds(580,165,200,40);
       lsinter.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsinter);
       JTextField tsinter=new JTextField();
       tsinter.setBounds(755,165,250,30);
       exclusionframe.add(tsinter);
       JLabel lsMetric=new JLabel("Metric %");
       lsMetric.setBounds(580,210,200,40);
       lsMetric.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsMetric);
       JTextField tsmetric=new JTextField();
       tsmetric.setBounds(755,210,250,30);
       exclusionframe.add(tsmetric);
       JLabel lsdepartment=new JLabel("Department");
       lsdepartment.setBounds(580,255,200,40);
       lsdepartment.setFont(new Font("aa",Font.BOLD,15));
       exclusionframe.add(lsdepartment);
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
       exclusionframe.add(csdepartment);
      
       JCheckBox check=new JCheckBox();
       check.setBounds(55,470,30,20);
       exclusionframe.add(check);
       JLabel lcheck=new JLabel("Confirm Exclusion of student from University.");
       lcheck.setBounds(90,470,340,20);
       exclusionframe.add(lcheck);
       
       //search button settings..................  
         
     
       JLabel lsroll=new JLabel(" Search Student's Roll No.");
       lsroll.setBounds(55,10,500,40);
       lsroll.setFont(new Font("aa",Font.BOLD,30));
       exclusionframe.add(lsroll);
       JTextField tsroll=new JTextField();
       tsroll.setBounds(470,15,250,40);
       exclusionframe.add(tsroll);
       JButton search=new JButton("Search");
       search.setBounds(750,15,100,40);
       search.setBackground(Color.black);
       search.setForeground(Color.white);
       exclusionframe.add(search);
       search.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               try {
                   rn=tsroll.getText();
                   ResultSet rs=st.executeQuery("SELECT Sroll FROM Admission;");
                   while(rs.next())
                   {
                       
                       if(rn.equals(rs.getString("Sroll")))
                       {
                          temp=rs.getString("Sroll");
                          pst= con.prepareStatement("Select * from Admission Where Sroll=?");
                          pst.setString(1, rn);
                          rs2 =pst.executeQuery();
                          rs2.next();
                          fname.setText(rs2.getString("Sfname"));
                          lname.setText(rs2.getString("Slname"));
                          tsmail.setText(rs2.getString("Smail"));
                          tsphone.setText(rs2.getString("Sphone"));
                          tsaddress.setText(rs2.getString("Saddress"));
                          tscnic.setText(rs2.getString("Scnic"));
                          tsinter.setText(rs2.getString("Sinter"));
                          tsmetric.setText(rs2.getString("Smetric"));
                          csdepartment.setSelectedItem(rs2.getString("Sdepartment"));
                         /* day.setSelectedItem(Day);
                          month.setSelectedItem(Month);these are not used
                          year.setSelectedItem(Year);*/
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
                          
                       }
                      
                    }
                    if(temp.equals("null"))
                       {
                           valuenotfounddialog=new JDialog(exclusionframe,"Warning",true);
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
                 
                   
                   
               } catch (SQLException ex) {
                   Logger.getLogger(Exclusion.class.getName()).log(Level.SEVERE, null, ex);
               }
                  
                   
                   
              
           }
       });
       
       JButton Delete=new JButton("Exclude");
       Delete.setBounds(755, 350,150,30);
       Delete.setBackground(Color.black);
       Delete.setForeground(Color.lightGray);
       exclusionframe.add(Delete);
       Delete.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               if(tsroll.getText().isEmpty())
               {
                   rollnonotspecifieddialog=new JDialog(exclusionframe,"Warning",true);
                   rollnonotspecifieddialog.setLayout(null);
                   rollnonotspecifieddialog.setBounds(400,250,350,150);
                   Container c=rollnonotspecifieddialog.getContentPane();
                   c.setBackground(Color.lightGray);
                   rollnonotspecifiedmsg=new JLabel("Roll no. not specified.");
                   rollnonotspecifiedmsg.setBounds(120,20,400,20);
                   rollnonotspecifieddialog.add(rollnonotspecifiedmsg);
                   rollnonotspecifiedbut=new JButton("Go back");
                   rollnonotspecifiedbut.setBounds(125,60,100,30);
                   rollnonotspecifiedbut.setBackground(Color.black);
                   rollnonotspecifiedbut.setForeground(Color.white);
                   rollnonotspecifieddialog.add(rollnonotspecifiedbut);
                   rollnonotspecifiedbut.addActionListener(new ActionListener()
                   {
                       public void actionPerformed(ActionEvent ae)
                       {
                           rollnonotspecifieddialog.dispose();
                       }
                   });
                   rollnonotspecifieddialog.setVisible(true);
               }
               else
               {
                   if(check.isSelected())
                   {
                   try {
                       pst=con.prepareStatement("Delete from Admission where Sroll=?");
                       pst.setString(1,rn);
                       pst.executeUpdate();
                       
                           successdialog=new JDialog(exclusionframe,"Warning",true);
                           successdialog.setBounds(400,250,350,150);
                           successdialog.setLayout(null);
                           Container c=successdialog.getContentPane();
                           c.setBackground(Color.lightGray);
                           successmsg=new JLabel("Student Excluded successfully.");
                           successmsg.setBounds(100,20,400,20);
                           successdialog.add(successmsg);
                           successbut=new JButton("Ok");
                           successbut.setBounds(125,60,100,30);
                           successbut.setBackground(Color.black);
                           successbut.setForeground(Color.white);
                           successdialog.add(successbut);
                           
                           
                           successbut.addActionListener(new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae)
                               {
                                   successdialog.dispose();
                               }
                           });
                           successdialog.setVisible(true);
                       
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(Exclusion.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   }
                   else
                   {
                   checkboxerror=new JDialog(exclusionframe,"Warning",true);
                   checkboxerror.setLayout(null);
                   checkboxerror.setBounds(400,250,455,150);
                   Container c=checkboxerror.getContentPane();
                   c.setBackground(Color.lightGray);
                   checkboxerrormsg=new JLabel("your have not confirmed Exclusion.please check box to confirm.");  
                   checkboxerrormsg.setBounds(30,20,400,20);
                   checkboxerror.add(checkboxerrormsg);
                   checkboxerrorbut=new JButton("Go Back");
                   checkboxerrorbut.setBounds(175,60,100,30);
                   checkboxerrorbut.setBackground(Color.black);
                   checkboxerrorbut.setForeground(Color.white);
                   checkboxerrorbut.addActionListener(new ActionListener()
                   {
                       public void actionPerformed(ActionEvent ae)
                       {
                           checkboxerror.dispose();
                       }
                   });
                   checkboxerror.add(checkboxerrorbut);
                   
                   checkboxerror.setVisible(true);
                   }
               }
           }
       });
            ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
            exclusionframe.setIconImage(ii.getImage());
            exclusionframe.setVisible(true);
    }
}
