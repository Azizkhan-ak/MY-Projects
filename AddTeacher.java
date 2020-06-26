
package university.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;

public class AddTeacher extends UniversityManagementSystem {
 public String tid; 
 boolean ch=false;
 JDialog tidempty,teacheradded,rollnull,checkbox;//copied from admission class
 JLabel tidemptymsg,teacheraddedmsg,rollnullerror,checkboxmsg;//copied from admission class
 JButton tidemptybut,teacheraddedbut,rollnullerrorbut,checkboxbut;//copied from addmision class
    public AddTeacher()
    {
         JFrame addteacherframe=new JFrame("Add Teacher");
         Container c=addteacherframe.getContentPane();
         c.setBackground(Color.lightGray);
         addteacherframe.setBounds(45,65,1200,600);
         ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
         addteacherframe.setLayout(null);
         addteacherframe.setIconImage(ii.getImage());
         JPanel addteacherpanel =new JPanel();
         addteacherpanel.setBounds(390,0,400,60);
         addteacherpanel.setBackground(Color.lightGray);
         JLabel addteacherlabel=new JLabel("Add Teacher");
         addteacherlabel.setForeground(Color.red);
         addteacherlabel.setBounds(10,7,300,40);
         Border border=BorderFactory.createLineBorder(Color.blue,6,true);
         addteacherpanel.setBorder(border);
         addteacherlabel.setFont(new Font("",Font.BOLD,40));
         
         
         
         
         
         ///////////////////////////////////////////////////////////////
         /////////////////////////////////////////////////////////////////
         //////////////////////////////////////////////////////////////////////
         ////////////////COMPONENETS////////////////////////////
         
         
       JLabel ltfname=new JLabel("Teacher First Name");
       ltfname.setBounds(55,75,200,40);
       ltfname.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltfname);
       JLabel ltlname=new JLabel("Teacher Last Name");
       ltlname.setBounds(55,120,200,40);
       ltlname.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltlname);
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
       addteacherframe.add(ttlname);
       
       
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
       addteacherframe.add(ttfname);
       
       
       JLabel ltid=new JLabel("Teacher ID");
       ltid.setBounds(580,75,200,40);
       ltid.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltid);
       JTextField ttid=new JTextField(30);
       ttid.setBounds(755,75,250,30);
       addteacherframe.add(ttid);
       
       
      
       JLabel ltDob=new JLabel("Teacher DateOfBirth");
       ltDob.setBounds(55,165,200,40);
       ltDob.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltDob);
       JComboBox day=new JComboBox();   
       day.setBounds(260,160,80,30);
       addteacherframe.add(day);
       String[] dayarr=new String[31];
       int num=1;
       for(int i=0;i<31;i++)
       {
           dayarr[i]=String.valueOf(num);
           day.addItem(dayarr[i]);
           num++;
       }
       JComboBox month=new JComboBox();   
       month.setBounds(340,160,80,30);
       addteacherframe.add(month);
       String montharr[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
       for(int i=0;i<12;i++)
       {
           month.addItem(montharr[i]);
       }
       Date d= new Date();
       JComboBox year=new JComboBox();   
       year.setBounds(420,160,80,30);
       addteacherframe.add(year);
       for(int i=1900;i<=d.getYear()+1900;i++)
       {
           String str=String.valueOf(i);
       year.addItem(str);
       }
       
       
       
       JLabel ltGender=new JLabel("Teacher Gender");
       ltGender.setBounds(55,210,200,40);
       ltGender.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltGender);
       ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,210,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,210,20,30);
       addteacherframe.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,210,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,210,20,30);
       addteacherframe.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,210,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,210,20,30);
       addteacherframe.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       
       
       
       JLabel ltmail=new JLabel("Teacher Mail");
       ltmail.setBounds(55,255,200,40);
       ltmail.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltmail);
       
       JTextField ttmail=new JTextField(30);
       ttmail.setBounds(260,260,250,30);
       addteacherframe.add(ttmail);
       
       
       JLabel ltPhone=new JLabel("Techer Phone");
       ltPhone.setBounds(55,300,200,40);
       ltPhone.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltPhone);
       JTextField ttphone=new JTextField();
       ttphone.setColumns(11);
       ttphone.setBounds(260,300,250,30);
       addteacherframe.add(ttphone);
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
       ltaddress.setBounds(55,345,200,40);
       ltaddress.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltaddress);
      
        JTextArea ttaddress=new JTextArea();
       ttaddress.setBounds(260,340,250,100);
       addteacherframe.add(ttaddress);
       
       
       JLabel ltcnic=new JLabel("Teacher CNIC");
       ltcnic.setBounds(580,120,200,40);
       ltcnic.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltcnic);
       JTextField ttcnic=new JTextField();
       ttcnic.setBounds(755,120,250,30);
       addteacherframe.add(ttcnic);
         
       
       JLabel ltqualification=new JLabel("Teacher's Qualification");
       ltqualification.setBounds(580,165,200,40);
       ltqualification.setFont(new Font("aa",Font.BOLD,15));
       addteacherframe.add(ltqualification);
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
       addteacherframe.add(ttqualification);
       
         
       JLabel ltsubject=new JLabel("Subject Alloted");
       ltsubject.setBounds(580,210,200,40);
       ltsubject.setFont(new Font("aa",Font.BOLD,15));  
       addteacherframe.add(ltsubject);
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
       addteacherframe.add(csubject);
         
       JLabel ltsalary=new JLabel("Salary");
       ltsalary.setBounds(580,255,200,40);
       ltsalary.setFont(new Font("",Font.BOLD,15));
       addteacherframe.add(ltsalary);
       JTextField ttsalary=new JTextField(30);
       ttsalary.setBounds(755,255,250,30);
     
       addteacherframe.add(ttsalary);
       
       
       JButton addteacherbut=new JButton("Add");
       addteacherbut.setBounds(755,380,250,40);
       addteacherframe.add(addteacherbut);
       
        JCheckBox check=new JCheckBox();
       check.setBounds(55,470,30,20);
       addteacherframe.add(check);
       JLabel lcheck=new JLabel("Confirm submitting details of new Teacher.");
       lcheck.setBounds(90,470,250,20);
       addteacherframe.add(lcheck);
       
       
       
       
       ////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////
       ////////////////ADDING BUTTON///////////////////////////////////////////
       
       addteacherbut.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               if(!(ttid.getText().isEmpty()))
               {
                   
                   if(check.isSelected())
                   {
                       tid=ttid.getText();
                   
                       try {
                           st=con.createStatement();
                           ResultSet rs=st.executeQuery("Select Tid from Teacher");
                          
                           while(rs.next())
                           {
                               if(tid.equals(rs.getString("Tid")))
                               {
                                   ch=true;
                                   break;
                               }
                           }
                           if(ch)
                           {
                              tidempty=new JDialog(addteacherframe,"warning",true);
                              tidempty.setLayout(null);
                              tidempty.setBounds(400,250,340,150);
                              Container c=tidempty.getContentPane();
                              c.setBackground(Color.lightGray);
                              tidemptymsg=new JLabel("Selected Teacher ID already exist.");
                              tidemptymsg.setBounds(40,10,300,40);
                              tidempty.add(tidemptymsg);
                              tidemptybut =new JButton("Go back");
                              tidemptybut.setBounds(110,60,100,30);
                              tidemptybut.setBackground(Color.black);
                              tidemptybut.setForeground(Color.white);
                              tidemptybut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               tidempty.dispose();
                           }
                       });
                       tidempty.add(tidemptybut);
                       tidempty.setVisible(true);
                           }
                           else
                           {
                               
                               PreparedStatement pst=con.prepareStatement("Insert into Teacher (Tfname,Tlname,Tgender,Tmail,Tphone,Taddress,Tid,Tcnic,Tqua,Tsub,Tsalary)values(?,?,?,?,?,?,?,?,?,?,?);");
                               pst.setString(1,ttfname.getText());
                               pst.setString(2,ttlname.getText());
                               ///////////////////////////////////////////
                               //Setting for gender in database
                               String Gender="";
                               if(male.isSelected())
                               {
                                   Gender="Male";
                               }
                               else if(female.isSelected())
                               {
                                   Gender="Female";
                               }
                               else
                               {
                                   Gender="Other";
                               }
                               pst.setString(3,Gender);
                               pst.setString(4,ttmail.getText());
                               pst.setString(5,ttphone.getText());
                               pst.setString(6,ttaddress.getText());
                               pst.setString(7,ttid.getText());
                               pst.setString(8,ttcnic.getText());
                               pst.setString(9,ttqualification.getSelectedItem().toString());
                               pst.setString(10,csubject.getSelectedItem().toString());
                               pst.setString(11,String.valueOf(ttsalary.getText()));
                               pst.executeUpdate();
                               
                               
                               
                               //////////////////////////////////////////////////
                               /////////SUCCESSFULLY SUBMITED BOX/////////////
                       teacheradded=new JDialog(addteacherframe,"warning",true);
                       teacheradded.setLayout(null);
                       teacheradded.setBounds(400,250,340,150);
                       Container c=teacheradded.getContentPane();
                       c.setBackground(Color.lightGray);
                       teacheraddedmsg=new JLabel("Teacher Added Successfully.");
                       teacheraddedmsg.setBounds(40,10,300,40);
                       teacheradded.add(teacheraddedmsg);
                       teacheraddedbut =new JButton("Go back");
                       teacheraddedbut.setBounds(110,60,100,30);
                       teacheraddedbut.setBackground(Color.black);
                       teacheraddedbut.setForeground(Color.white);
                       teacheraddedbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               teacheradded.dispose();
                           }
                       });
                       teacheradded.add(teacheraddedbut);
                       teacheradded.setVisible(true);
                               
                               
                               
                               
                           }
                           
                           
                           
                           
                       } catch (SQLException ex) {
                           Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   else
                   {
       /////////////////////////////////////////////////////////////////////////////////////////////////////
                       /////////////////CHECKBOX NOT SELECTED ERROR////////////////////////////////////////
                       checkbox=new JDialog(addteacherframe,"warning",true);
                       checkbox.setLayout(null);
                       checkbox.setBounds(400,250,400,150);
                       Container c=checkbox.getContentPane();
                       c.setBackground(Color.lightGray);
                       checkboxmsg=new JLabel("you have not confirm submission please check checkbox.");
                       checkboxmsg.setBounds(40,10,400,40);
                       checkbox.add(checkboxmsg);
                       checkboxbut =new JButton("Go back");
                       checkboxbut.setBounds(140,60,100,30);
                       checkboxbut.setBackground(Color.black);
                       checkboxbut.setForeground(Color.white);
                       checkboxbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               checkbox.dispose();
                           }
                       });
                       checkbox.add(checkboxbut);
                       checkbox.setVisible(true);
                       
                       
                   }
               }
               else
               {
                   
                   
                       rollnull=new JDialog(addteacherframe,"warning",true);
                       rollnull.setLayout(null);
                       rollnull.setBounds(400,250,340,150);
                       Container c=rollnull.getContentPane();
                       c.setBackground(Color.lightGray);
                       rollnullerror=new JLabel("Teacher ID cannot be empty.please fill.");
                       rollnullerror.setBounds(40,10,300,40);
                       rollnull.add(rollnullerror);
                       rollnullerrorbut =new JButton("Go back");
                       rollnullerrorbut.setBounds(110,60,100,30);
                       rollnullerrorbut.setBackground(Color.black);
                       rollnullerrorbut.setForeground(Color.white);
                       rollnullerrorbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               rollnull.dispose();
                           }
                       });
                       rollnull.add(rollnullerrorbut);
                       rollnull.setVisible(true);
                   
                   
               }
           }
       });
       
       
         addteacherpanel.add(addteacherlabel);
         addteacherframe.add(addteacherpanel);
         addteacherframe.setVisible(true);
    }
    
}
