
package university.management.system;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Admission extends UniversityManagementSystem {
public String Afname,Alname,Adob,Agender,Amail,Aaddress,
        Adepartment;
public int Ainter,Ametric,Arollno;
public long Aphone,Acnic;
JDialog checkboxerror,rollnull,successdialog;
JLabel checkboxerrormsg,rollnullerror,successmsg;
JButton checkboxerrorbut,rollnullerrorbut,successbut;
    
    public Admission()
    {
        JFrame admissionframe=new JFrame("Admission");
        admissionframe.setBounds(45,65,1200,600);
        admissionframe.setLayout(null);
        Container c=admissionframe.getContentPane();
        c.setBackground(Color.green);
       admissionframe.addWindowListener(new WindowAdapter()
       {
           public void windowClosing(WindowEvent we)
           {
               admissionframe.dispose();
           }
       });
     
      
       JLabel lsfname=new JLabel("Student First Name");
       lsfname.setBounds(55,75,200,40);
       lsfname.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsfname);
       JLabel lslname=new JLabel("Student Last Name");
       lslname.setBounds(55,120,200,40);
       lslname.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lslname);
       JLabel lsDob=new JLabel("Student DateOfBirth");
       lsDob.setBounds(55,165,200,40);
       lsDob.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsDob);
       JLabel lsGender=new JLabel("Student Gender");
       lsGender.setBounds(55,210,200,40);
       lsGender.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsGender);
       JLabel lsmail=new JLabel("Student Mail");
       lsmail.setBounds(55,255,200,40);
       lsmail.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsmail);
       JLabel lsPhone=new JLabel("Student Phone");
       lsPhone.setBounds(55,300,200,40);
       lsPhone.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsPhone);
       JLabel lsaddress=new JLabel("Student Address");
       lsaddress.setBounds(55,345,200,40);
       lsaddress.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsaddress);
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
       admissionframe.add(fname);
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
       admissionframe.add(lname);
       
       JComboBox day=new JComboBox();   
       day.setBounds(260,160,80,30);
       admissionframe.add(day);
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
       admissionframe.add(month);
       String montharr[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
       for(int i=0;i<12;i++)
       {
           month.addItem(montharr[i]);
       }
       Date d= new Date();
       JComboBox year=new JComboBox();   
       year.setBounds(420,160,80,30);
       admissionframe.add(year);
       for(int i=1900;i<=d.getYear()+1900;i++)
       {
           String str=String.valueOf(i);
       year.addItem(str);
       }
       
       ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,210,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,210,20,30);
       admissionframe.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,210,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,210,20,30);
       admissionframe.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,210,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,210,20,30);
       admissionframe.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       
       
       JTextField tsmail=new JTextField(30);
       tsmail.setBounds(260,260,250,30);
       admissionframe.add(tsmail);
       
       JTextField tsphone=new JTextField();
       tsphone.setColumns(11);
       tsphone.setBounds(260,300,250,30);
       admissionframe.add(tsphone);
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
       admissionframe.add(tsaddress);
       
       JLabel lsroll=new JLabel("Student Roll No.");
       lsroll.setBounds(580,75,200,40);
       lsroll.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsroll);
       JTextField tsroll=new JTextField();
       tsroll.setBounds(755,75,250,30);
       admissionframe.add(tsroll);
       JLabel lscnic=new JLabel("Student CNIC");
       lscnic.setBounds(580,120,200,40);
       lscnic.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lscnic);
       JTextField tscnic=new JTextField();
       tscnic.setBounds(755,120,250,30);
       admissionframe.add(tscnic);
       JLabel lsinter=new JLabel("Intermediate %");
       lsinter.setBounds(580,165,200,40);
       lsinter.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsinter);
       JTextField tsinter=new JTextField();
       tsinter.setBounds(755,165,250,30);
       admissionframe.add(tsinter);
       JLabel lsMetric=new JLabel("Metric %");
       lsMetric.setBounds(580,210,200,40);
       lsMetric.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsMetric);
       JTextField tsmetric=new JTextField();
       tsmetric.setBounds(755,210,250,30);
       admissionframe.add(tsmetric);
       JLabel lsdepartment=new JLabel("Department");
       lsdepartment.setBounds(580,255,200,40);
       lsdepartment.setFont(new Font("aa",Font.BOLD,15));
       admissionframe.add(lsdepartment);
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
       admissionframe.add(csdepartment);
      
       JCheckBox check=new JCheckBox();
       check.setBounds(55,470,30,20);
       admissionframe.add(check);
       JLabel lcheck=new JLabel("Confirm submitting details of new student.");
       lcheck.setBounds(90,470,250,20);
       admissionframe.add(lcheck);
       
       
        JButton submit=new JButton("Submit");
       submit.setBounds(755, 350,150,30);
       submit.setBackground(Color.black);
       submit.setForeground(Color.white);
       admissionframe.add(submit);
       submit.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent ae)
           {
               if(check.isSelected())
               {
                   if((tsroll.getText()).isEmpty())
                   {
                       
                       rollnull=new JDialog(admissionframe,"warning",true);
                       rollnull.setLayout(null);
                       rollnull.setBounds(400,250,340,150);
                       Container c=rollnull.getContentPane();
                       c.setBackground(Color.lightGray);
                       rollnullerror=new JLabel("Roll No. cannot be empty.please fill roll no.");
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
                   else
                   {
                       try {
                           Afname=fname.getText();
                           Alname=lname.getText();
                          String Day=day.getSelectedItem().toString();
                           String Month=month.getSelectedItem().toString();
                           String Year=year.getSelectedItem().toString();
                           Adob=Day+"-"+Month+"-"+Year;
                           if(male.isSelected())
                           {
                               Agender="Male";
                           }
                           else if(female.isSelected())
                           {
                               Agender="Female";
                           }
                           else
                           {
                               Agender="Other";
                           }
                           Amail=tsmail.getText();
                           Aphone=Long.parseLong(tsphone.getText());
                           Aaddress=tsaddress.getText();
                           Arollno=Integer.parseInt(tsroll.getText());
                           Acnic=Long.parseLong(tscnic.getText());
                           Ainter=Integer.parseInt(tsinter.getText());
                           Ametric=Integer.parseInt(tsmetric.getText());
                           Adepartment=csdepartment.getSelectedItem().toString();
                          // st.executeUpdate("insert into Admission (Sfname,Sroll)values('Aziz',1);");
                           PreparedStatement pst=con.prepareStatement("insert into Admission (Sfname,Slname,Sdob,Sgender,Smail,Sphone,Saddress,Sroll,Scnic,Sinter,Smetric,Sdepartment)values(?,?,?,?,?,?,?,?,?,?,?,?);");
                           pst.setString(1,Afname);
                           pst.setString(2,Alname);
                           pst.setString(3,Adob);
                           pst.setString(4,Agender);
                           pst.setString(5,Amail);
                           pst.setLong(6,Aphone);
                           pst.setString(7,Aaddress);
                           pst.setInt(8,Arollno);
                           pst.setLong(9, Acnic);
                           pst.setInt(10, Ainter);
                           pst.setInt(11, Ametric);
                           pst.setString(12,Adepartment);
                           pst.executeUpdate();
                           
                           
                           successdialog=new JDialog(admissionframe,"Succeeded",true);
                           successdialog.setLayout(null);
                           successdialog.setBounds(400,250,455,150);
                           Container c=successdialog.getContentPane();
                           c.setBackground(Color.lightGray);
                           successmsg=new JLabel("Student added successfully.");
                           successmsg.setBounds(30,20,400,20);
                           successdialog.add(successmsg);
                           successbut=new JButton("Ok");
                           successbut.setBounds(175,60,100,30);
                           successbut.setBackground(Color.black);
                           successbut.setForeground(Color.white);
                           successbut.addActionListener(new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae)
                               {
                                   successdialog.dispose();
                               }
                           });
                           
                           successdialog.add(successbut);
                           successdialog.setVisible(true);
                       } catch (SQLException ex) {
                           Logger.getLogger(Admission.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
               }
               else
               {
                   checkboxerror=new JDialog(admissionframe,"Warning",true);
                   checkboxerror.setLayout(null);
                   checkboxerror.setBounds(400,250,455,150);
                   Container c=checkboxerror.getContentPane();
                   c.setBackground(Color.lightGray);
                   checkboxerrormsg=new JLabel("You have not confirmed submission.please check the checkBox.");  
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
       });
            ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
            admissionframe.setIconImage(ii.getImage());
            admissionframe.setVisible(true);
    }

}