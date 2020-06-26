
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
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
import javax.swing.border.Border;

public class RemoveTeacher extends UniversityManagementSystem{
PreparedStatement pst;  
JDialog searchdialog,tidnotexist,teacherremoved,checkboxdialog;
JLabel searchmsg,tidnotexistmsg,teacherremovedmsg,checkboxmsg;
JButton searchbutton,tidnotexistbut,teacherremovedbut,checkboxbut;
String teacheridinsearch;
boolean s=false;
    
    public RemoveTeacher()
    {
        JFrame removeteacherframe=new JFrame("Remove Teacher");
        removeteacherframe.setBounds(45,65,1200,600);
        removeteacherframe.setLayout(null);
        
        Container c=removeteacherframe.getContentPane();
        ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
        removeteacherframe.setIconImage(ii.getImage());
        c.setBackground(Color.lightGray);
      
        
         removeteacherframe.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent we)
           {
               removeteacherframe.dispose();
           }
       });
         
         JPanel removeteacherpanel =new JPanel();
         removeteacherpanel.setBounds(390,0,400,60);
         removeteacherpanel.setBackground(Color.lightGray);
         JLabel removeteacherlabel=new JLabel("Remove Teacher");
         removeteacherlabel.setForeground(Color.red);
         removeteacherlabel.setBounds(10,7,300,40);
         removeteacherpanel.add(removeteacherlabel);
         Border border=BorderFactory.createLineBorder(Color.blue,6,true);
         removeteacherpanel.setBorder(border);
         removeteacherlabel.setFont(new Font("",Font.BOLD,40));
         
         
         
         ////////////////////////////////////////////////////////////////////////
         ///////////////////////////////////////////////////////////////////////
         ///////////////////////SETTING COMPONENTS ON FRAME////////////////////
         
         
           
       JLabel ltfname=new JLabel("Teacher First Name");
       ltfname.setBounds(55,75,200,40);
       ltfname.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltfname);
       JLabel ltlname=new JLabel("Teacher Last Name");
       ltlname.setBounds(55,120,200,40);
       ltlname.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltlname);
       JTextField ttlname=new JTextField(30);
       ttlname.setBounds(260,120,250,30);
       ttlname.addKeyListener(new KeyAdapter()
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
       removeteacherframe.add(ttlname);
       
       
       JTextField ttfname=new JTextField(30);
       ttfname.setBounds(260,80,250,30);
       ttfname.addKeyListener(new KeyAdapter()
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
       removeteacherframe.add(ttfname);
       
       
       JLabel ltid=new JLabel("Teacher ID");
       ltid.setBounds(580,75,200,40);
       ltid.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltid);
       JTextField ttid=new JTextField(30);
       ttid.setBounds(755,75,250,30);
       removeteacherframe.add(ttid);
       JLabel ltGender=new JLabel("Teacher Gender");
       ltGender.setBounds(55,165,200,40);
       ltGender.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltGender);
       ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,165,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,165,20,30);
       removeteacherframe.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,165,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,165,20,30);
       removeteacherframe.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,165,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,165,20,30);
       removeteacherframe.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       
       
       
       JLabel ltmail=new JLabel("Teacher Mail");
       ltmail.setBounds(55,210,200,40);
       ltmail.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltmail);
       
       JTextField ttmail=new JTextField(30);
       ttmail.setBounds(260,210,250,30);
       removeteacherframe.add(ttmail);
       
       
       JLabel ltPhone=new JLabel("Techer Phone");
       ltPhone.setBounds(55,255,200,40);
       ltPhone.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltPhone);
       JTextField ttphone=new JTextField();
       ttphone.setColumns(11);
       ttphone.setBounds(260,255,250,30);
       removeteacherframe.add(ttphone);
       ttphone.addKeyListener(new KeyAdapter()
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
       
       
       JLabel ltaddress=new JLabel("Teacher Address");
       ltaddress.setBounds(55,300,200,40);
       ltaddress.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltaddress);
      
        JTextArea ttaddress=new JTextArea();
       ttaddress.setBounds(260,300,250,100);
       removeteacherframe.add(ttaddress);
       
       
       JLabel ltcnic=new JLabel("Teacher CNIC");
       ltcnic.setBounds(580,120,200,40);
       ltcnic.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltcnic);
       JTextField ttcnic=new JTextField();
       ttcnic.setBounds(755,120,250,30);
       removeteacherframe.add(ttcnic);
         
       
       JLabel ltqualification=new JLabel("Teacher's Qualification");
       ltqualification.setBounds(580,165,200,40);
       ltqualification.setFont(new Font("aa",Font.BOLD,15));
       removeteacherframe.add(ltqualification);
       JComboBox ttqualification =new JComboBox();
       ttqualification.addItem("BE");
       ttqualification.addItem("BS");
       ttqualification.addItem("BA");
       ttqualification.addItem("BBA");
       ttqualification.addItem("B.Arch");
       ttqualification.addItem("BSN");
       
       ttqualification.addItem("MA");
       ttqualification.addItem("MBA");
       ttqualification.addItem("MS");
       
       ttqualification.addItem("Ph.D");
       ttqualification.addItem("psy.D");
       
       ttqualification.addItem("M.phil");
       ttqualification.setBounds(755,165,250,30);
       removeteacherframe.add(ttqualification);
       
         
       JLabel ltsubject=new JLabel("Subject Alloted");
       ltsubject.setBounds(580,210,200,40);
       ltsubject.setFont(new Font("aa",Font.BOLD,15));  
       removeteacherframe.add(ltsubject);
       JComboBox csubject=new JComboBox();
       csubject.setBounds(755,210,250,30);
       csubject.addItem("Object Oriented Programming");
       csubject.addItem("Data Structures and Alg");
       csubject.addItem("Calculus");
       csubject.addItem("Linear Algebra");
       csubject.addItem("Islamic Education");
       csubject.addItem("Programming Fundamentals");
       csubject.addItem("Basic electronics");
       csubject.addItem("Digital Logic Design");
       csubject.addItem("xyz");
       csubject.addItem("xyz");
       csubject.addItem("xyz");
       removeteacherframe.add(csubject);
         
       JLabel ltsalary=new JLabel("Salary");
       ltsalary.setBounds(580,255,200,40);
       ltsalary.setFont(new Font("",Font.BOLD,15));
       removeteacherframe.add(ltsalary);
       JTextField ttsalary=new JTextField(30);
       ttsalary.setBounds(755,255,250,30);
     
       removeteacherframe.add(ttsalary);
       
       
      
       
        JCheckBox check=new JCheckBox();
       check.setBounds(55,430,30,20);
       removeteacherframe.add(check);
       JLabel lcheck=new JLabel("Confirm removing Teacher.");
       lcheck.setBounds(90,430,250,20);
       removeteacherframe.add(lcheck);
         
       JLabel searchlabel=new JLabel("Search Teachers'Id");
       searchlabel.setBounds(55,470,250,30);
       searchlabel.setFont(new Font("",Font.BOLD,25));
       removeteacherframe.add(searchlabel);
         
       JTextField searchtext=new JTextField(30);
       searchtext.setBounds(300,470,250,30);
       removeteacherframe.add(searchtext);
       
       //ImageIcon sii=new ImageIcon("‪‪E:\\eidulfitr\\s1.png");
       
       JButton searchbut=new JButton("Search");
       
       searchbut.setBounds(570,470,140,30);
      //   ImageIcon abc=new ImageIcon("E:\\eidulfitr\\s2.png");
        // searchbut.setIcon(abc);
     searchbut.setBackground(Color.black);
     searchbut.setForeground(Color.white);
     removeteacherframe.add(searchbut);
       
     searchbut.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent ae)
         {
             if(searchtext.getText().isEmpty())
             {
                              searchdialog=new JDialog(removeteacherframe,"warning",true);
                              searchdialog.setLayout(null);
                              searchdialog.setBounds(400,250,340,150);
                              Container c=searchdialog.getContentPane();
                              c.setBackground(Color.lightGray);
                              searchmsg=new JLabel("Search box is empty.");
                              searchmsg.setBounds(40,10,300,40);
                              searchdialog.add(searchmsg);
                              searchbutton =new JButton("Go back");
                              searchbutton.setBounds(110,60,100,30);
                              searchbutton.setBackground(Color.black);
                              searchbutton.setForeground(Color.white);
                              searchbutton.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               searchdialog.dispose();
                           }
                       });
                       searchdialog.add(searchbutton);
                       searchdialog.setVisible(true);
             }//if////////////////////////////////////////////////////////////
             else///////////search box is not empty//////////////
             {
                 
                 
                     teacheridinsearch=searchtext.getText();
                     try {
                         ResultSet rs=st.executeQuery("Select Tid from Teacher");
                         while(rs.next())
                         {
                            if(teacheridinsearch.equals(rs.getString("Tid")))
                            {
                                s=true;
                                break;
                            }
                         }
                     } catch (SQLException ex) {
                         Logger.getLogger(RemoveTeacher.class.getName()).log(Level.SEVERE, null, ex);
                     }
 //////////////////////////////////////////////////////////////////////////////                    
                     if(s)//Entered roll num exists 
                     {
                         try {
                             pst=con.prepareStatement("Select * from Teacher where Tid=?;");
                             pst.setString(1, teacheridinsearch);
                             ResultSet rs=pst.executeQuery();
                             while(rs.next())
                             {
                                 ttfname.setText(rs.getString("Tfname"));
                                 ttlname.setText(rs.getString("Tlname"));
                                 if(rs.getString("Tgender").equals("Male"))
                                     male.setSelected(true);
                                 else if(rs.getString("Tgender").equals("Female"))
                                     female.setSelected(true);
                                 else
                                     other.setSelected(true);
                                 ttmail.setText(rs.getString("Tmail"));
                                 ttphone.setText(rs.getString("Tphone"));
                                 ttcnic.setText((rs.getString("Tcnic")));
                                 ttqualification.setSelectedItem(rs.getString("Tqua"));
                                 csubject.setSelectedItem(rs.getString("Tsub"));
                                 ttsalary.setText(String.valueOf(rs.getInt("Tsalary")));
                                 ttaddress.setText(rs.getString("Taddress"));
                                 ttid.setText(rs.getString("Tid"));
                                 
                                 
                                 
                                 
                             }
                             
                         } catch (SQLException ex) {
                             Logger.getLogger(RemoveTeacher.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }else//entered roll num does not exist
                     {
                         
                         
                              tidnotexist=new JDialog(removeteacherframe,"warning",true);
                              tidnotexist.setLayout(null);
                              tidnotexist.setBounds(400,250,340,150);
                              Container c=tidnotexist.getContentPane();
                              c.setBackground(Color.lightGray);
                              tidnotexistmsg=new JLabel("Selected Teacher ID Does not exist.");
                              tidnotexistmsg.setBounds(40,10,300,40);
                              tidnotexist.add(tidnotexistmsg);
                              tidnotexistbut =new JButton("Go back");
                              tidnotexistbut.setBounds(110,60,100,30);
                              tidnotexistbut.setBackground(Color.black);
                              tidnotexistbut.setForeground(Color.white);
                              tidnotexistbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               tidnotexist.dispose();
                           }
                       });
                       tidnotexist.add(tidnotexistbut);
                       tidnotexist.setVisible(true);
                         
                         
                     }
////////////////////////////////////////////////////////////////////////////////
             }
         
             }
         
     });
      
       
     ////////////////////////////////////////////////////////////////////////
     ////////////////////REMOVE BUTTON LOGIC////////////////////////////////
       JButton removeteacherbut=new JButton("Remove");
       removeteacherbut.setBounds(755,380,250,40);
       removeteacherbut.setBackground(Color.black);
       removeteacherbut.setForeground(Color.white);
       removeteacherframe.add(removeteacherbut);
       removeteacherbut.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               if(check.isSelected()&& !(teacheridinsearch.isEmpty()))
               {
                   try {
                       PreparedStatement pst=con.prepareStatement("Delete From Teacher where Tid=?;");
                       pst.setString(1, teacheridinsearch);
                       pst.executeUpdate();
                       
                              teacherremoved=new JDialog(removeteacherframe,"warning",true);
                              teacherremoved.setLayout(null);
                              teacherremoved.setBounds(400,250,340,150);
                              Container c=teacherremoved.getContentPane();
                              c.setBackground(Color.lightGray);
                              teacherremovedmsg=new JLabel("Teacher removed successfully.");
                              teacherremovedmsg.setBounds(40,10,300,40);
                              teacherremoved.add(teacherremovedmsg);
                              teacherremovedbut =new JButton("Go back");
                              teacherremovedbut.setBounds(110,60,100,30);
                              teacherremovedbut.setBackground(Color.black);
                              teacherremovedbut.setForeground(Color.white);
                              teacherremovedbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               teacherremoved.dispose();
                           }
                       });
                       teacherremoved.add(teacherremovedbut);
                       teacherremoved.setVisible(true);
                               
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(RemoveTeacher.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else/////CHECKBOXNOTSELECTED///////////////////////////////////
               {
                              checkboxdialog=new JDialog(removeteacherframe,"warning",true);
                              checkboxdialog.setLayout(null);
                              checkboxdialog.setBounds(400,250,400,150);
                              Container c=checkboxdialog.getContentPane();
                              c.setBackground(Color.lightGray);
                              checkboxmsg=new JLabel("You have not confirmed removal,please check checkbox");
                              checkboxmsg.setBounds(40,10,400,40);
                              checkboxdialog.add(checkboxmsg);
                              checkboxbut =new JButton("Go back");
                              checkboxbut.setBounds(140,60,100,30);
                              checkboxbut.setBackground(Color.black);
                              checkboxbut.setForeground(Color.white);
                              checkboxbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               checkboxdialog.dispose();
                           }
                       });
                       checkboxdialog.add(checkboxbut);
                       checkboxdialog.setVisible(true);
               }
           }
       });
     
     
         removeteacherframe.add(removeteacherpanel);
         removeteacherframe.setVisible(true);
     
    }
}
