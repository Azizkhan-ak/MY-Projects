
package university.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.*;

public class TeacherInformation extends UniversityManagementSystem{
    JDialog tiddoesnotexist,searchboxempty;
    JLabel tiddoesnotexistmsg,searchboxemptymsg;
    JButton tiddoesnotexistbut,searchboxemptybut;
    String TID="";
    boolean eq=false;
    public TeacherInformation()
    {
         JFrame teacherinfoframe=new JFrame("Teacher's Information");
         Container c=teacherinfoframe.getContentPane();
         c.setBackground(Color.lightGray);
         teacherinfoframe.setBounds(45,65,1200,600);
         ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
         teacherinfoframe.setLayout(null);
         teacherinfoframe.setIconImage(ii.getImage());
         JPanel teacherinfopanel =new JPanel();
         teacherinfopanel.setBounds(370,0,450,60);
         teacherinfopanel.setBackground(Color.lightGray);
         JLabel teacherinfolabel=new JLabel("Teacher's Information");
         teacherinfolabel.setForeground(Color.red);
         teacherinfolabel.setBounds(10,7,300,40);
         Border border=BorderFactory.createLineBorder(Color.blue,6,true);
         teacherinfopanel.setBorder(border);
         teacherinfolabel.setFont(new Font("",Font.BOLD,40));
         teacherinfopanel.add(teacherinfolabel);
         
         
         
          
///////////////////////////////////////////////////////////////////////////
/////////////////////Creating JPanel for components //////////////////////////

JPanel allcomponents=new JPanel();
allcomponents.setLayout(null);
allcomponents.setBounds(55,53,1070,380);
allcomponents.setBackground(Color.red);

allcomponents.setVisible(false);
teacherinfoframe.add(allcomponents);

JLabel lfname=new JLabel("Teacher's First Name");
lfname.setFont(new Font("",Font.BOLD,15));
lfname.setBounds(55,30,200,30);
allcomponents.add(lfname);
JTextField tfname=new JTextField(30);
tfname.setBounds(270,30,250,30);
allcomponents.add(tfname);
JLabel llname=new JLabel("Teacher's Last Name");
llname.setBounds(55,70,200,30);
llname.setFont(new Font("",Font.BOLD,15));
allcomponents.add(llname);
JTextField tlname=new JTextField(30);
tlname.setBounds(270,70,250,30);
allcomponents.add(tlname);
JLabel lgender=new JLabel("Teacher's Gender");
lgender.setBounds(55,110,200,30);
lgender.setFont(new Font("",Font.BOLD,15));
allcomponents.add(lgender);
 ButtonGroup gender=new ButtonGroup();
       JLabel Male=new JLabel("Male");
       Male.setBounds(260,110,40,30);
       Male.setFont(new Font("aa",Font.BOLD,15));
       allcomponents.add(Male);
       JRadioButton male=new JRadioButton();
       male.setBounds(300,110,20,30);
       allcomponents.add(male);
       JLabel Female=new JLabel("Female");
       Female.setBounds(330,110,60,30);
       Female.setFont(new Font("aa",Font.BOLD,15));
       allcomponents.add(Female);
       JRadioButton female=new JRadioButton();
       female.setBounds(391,110,20,30);
       allcomponents.add(female);
       JLabel Other=new JLabel("Other");
       Other.setBounds(420,110,60,30);
       Other.setFont(new Font("aa",Font.BOLD,15));
       allcomponents.add(Other);
       JRadioButton other=new JRadioButton();
       other.setBounds(470,110,20,30);
       allcomponents.add(other);
       gender.add(male);
       gender.add(female);
       gender.add(other);
       JLabel lmail=new JLabel("Teacher's mail");
       lmail.setFont(new Font("",Font.BOLD,15));
       lmail.setBounds(55,150,200,30);
       allcomponents.add(lmail);
       JTextField tmail=new JTextField(30);
       tmail.setBounds(270,150,250,30);
       allcomponents.add(tmail);
       JLabel laddress=new JLabel("Teacher's Address");
       laddress.setFont(new Font("",Font.BOLD,15));
       laddress.setBounds(55,190,200,30);
       allcomponents.add(laddress);
       TextArea taddress=new TextArea();
       taddress.setBounds(270,190,250,100);
       allcomponents.add(taddress);
       JLabel lphone=new JLabel("Teacher's Phone");
       lphone.setFont(new Font("",Font.BOLD,15));
       lphone.setBounds(55,300,200,30);
       allcomponents.add(lphone);
       JTextField tphone=new JTextField(30);
       tphone.setBounds(270,300,250,30);
       allcomponents.add(tphone);
       JLabel lid=new JLabel("Teacher ID");
       lid.setFont(new Font("",Font.BOLD,15));
       lid.setBounds(600,30,200,30);
       allcomponents.add(lid);
       JTextField tid=new JTextField(30);
       tid.setBounds(800,30,250,30);
       allcomponents.add(tid);
       JLabel lcnic=new JLabel("Teacher CNIC");
       lcnic.setFont(new Font("",Font.BOLD,15));
       lcnic.setBounds(600,70,200,30);
       allcomponents.add(lcnic);
       JTextField tcnic=new JTextField(30);
       tcnic.setBounds(800,70,250,30);
       allcomponents.add(tcnic);
       JLabel ltqualification=new JLabel("Teacher's Qualification");
       ltqualification.setBounds(600,110,200,40);
       ltqualification.setFont(new Font("aa",Font.BOLD,15));
       allcomponents.add(ltqualification);
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
       ttqualification.setBounds(800,110,250,30);
       allcomponents.add(ttqualification);
       JLabel ltsubject=new JLabel("Subject Alloted");
       ltsubject.setBounds(600,150,200,40);
       ltsubject.setFont(new Font("aa",Font.BOLD,15));  
       allcomponents.add(ltsubject);
       JComboBox csubject=new JComboBox();
       csubject.setBounds(800,150,250,30);
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
       allcomponents.add(csubject);
       JLabel ltsalary=new JLabel("Salary");
       ltsalary.setBounds(600,190,200,30);
       ltsalary.setFont(new Font("",Font.BOLD,15));
       allcomponents.add(ltsalary);
       JTextField ttsalary=new JTextField(30);
       ttsalary.setBounds(800,190,250,30);
     
       allcomponents.add(ttsalary);
       
////////////////////////////////////////////////////////////////////////////////
///////////////////////JPanel End/////////////////////////////////////////////






        
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
////////////////////////Search Teacher's ID////////////////////////////////////////

JLabel searchteacheridlabel=new JLabel("Search Teacher's ID");
searchteacheridlabel.setBounds(55,470,300,30);
searchteacheridlabel.setFont(new Font("",Font.BOLD,30));
teacherinfoframe.add(searchteacheridlabel);
JTextField searchteacheridtext=new JTextField(30);
searchteacheridtext.setBounds(360,470,250,40);
teacherinfoframe.add(searchteacheridtext);
JButton searchteacheridbut=new JButton("Search");
searchteacheridbut.setBounds(615,470,80,40);
searchteacheridbut.setBackground(Color.black);
searchteacheridbut.setForeground(Color.white);
teacherinfoframe.add(searchteacheridbut);
searchteacheridbut.addActionListener(new ActionListener()
{
 public void actionPerformed(ActionEvent ae)
 {
     
     if(!(searchteacheridtext.getText().isEmpty()))/////////////Searchbox is not empty/////////////////
     {
       //  System.out.println("Box is not empty");
         
     TID=searchteacheridtext.getText();
     try {
         ResultSet rs=st.executeQuery("SELECT Tid from Teacher;");
         
         while(rs.next())//fetching TID from Teacher Table
         {
             if(TID.equals(rs.getString("Tid")))//check if TID is in TEacher or not?
             {
                 eq=true;
                 break;
             }
         }
         if(eq)//IF teacher I present then Execute this block
         {
            // System.out.println("Tid exists");
            allcomponents.setVisible(true);
            PreparedStatement pst=con.prepareStatement("Select * from Teacher where Tid=?;");
            pst.setString(1, TID);
            ResultSet rs1=pst.executeQuery();
            rs1.next();
            //Now we have result set of Teachers data with roll no TID
            
            tfname.setText(rs1.getString("Tfname"));
            tlname.setText(rs1.getString("Tlname"));
            String GENDER;
            if(rs1.getString("Tgender").equals("Male"))
                male.setSelected(true);
            else if(rs1.getString("Tgender").equals("Female"))
             female.setSelected(true);
            else
                other.setSelected(true);
            tmail.setText(rs1.getString("Tmail"));
            tphone.setText(String.valueOf(rs1.getString("Tphone")));
            taddress.setText(rs1.getString("Taddress"));
            tid.setText(rs1.getString("Tid"));
            tcnic.setText(String.valueOf(rs1.getString("Tcnic")));
            ttqualification.setSelectedItem(rs1.getString("Tqua"));
            csubject.setSelectedItem(rs1.getString("Tsub"));
            ttsalary.setText(String.valueOf(rs1.getString("Tsalary")));
            //System.out.println("Data fetched");
            
       
    ///////////////////////////DATA FETCHED SUCCESSFULLY////////////////
    
            
            
            
            
            
         }else//if Teacher id is not in  Teacher table then exceute this block;
         {
    //////////////////ROLL NO DOES NOT exist
                       tiddoesnotexist=new JDialog(teacherinfoframe,"warning",true);
                       tiddoesnotexist.setLayout(null);
                       tiddoesnotexist.setBounds(400,250,340,150);
                       Container c=tiddoesnotexist.getContentPane();
                       c.setBackground(Color.lightGray);
                       tiddoesnotexistmsg=new JLabel("Teacher Id does not exist");
                       tiddoesnotexistmsg.setBounds(40,10,300,40);
                       tiddoesnotexist.add(tiddoesnotexistmsg);
                       tiddoesnotexistbut =new JButton("Go back");
                       tiddoesnotexistbut.setBounds(110,60,100,30);
                       tiddoesnotexistbut.setBackground(Color.black);
                       tiddoesnotexistbut.setForeground(Color.white);
                       tiddoesnotexistbut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               tiddoesnotexist.dispose();
                           }
                       });
                       tiddoesnotexist.add(tiddoesnotexistbut);
                       tiddoesnotexist.setVisible(true);
              
             //System.out.println("No");
         }
     } catch (SQLException ex) {
         Logger.getLogger(TeacherInformation.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
     
 else///////////////Search box is empty////////////////////////////////////////////
     {
       //  System.out.println("Search Box is empty");
       
                       searchboxempty=new JDialog(teacherinfoframe,"warning",true);
                       searchboxempty.setLayout(null);
                       searchboxempty.setBounds(400,250,340,150);
                       Container c=searchboxempty.getContentPane();
                       c.setBackground(Color.lightGray);
                       searchboxemptymsg=new JLabel("Search box is empty.");
                       searchboxemptymsg.setBounds(40,10,300,40);
                       searchboxempty.add(searchboxemptymsg);
                       searchboxemptybut =new JButton("Go back");
                       searchboxemptybut.setBounds(110,60,100,30);
                       searchboxemptybut.setBackground(Color.black);
                       searchboxemptybut.setForeground(Color.white);
                       searchboxemptybut.addActionListener(new ActionListener()
                       {
                           public void actionPerformed(ActionEvent ae)
                           {
                               searchboxempty.dispose();
                           }
                       });
                       searchboxempty.add(searchboxemptybut);
                       searchboxempty.setVisible(true);
       
     }
 }
});
         
///////////////////////////////////////////////////////////////////////////
//////////////////Search Button Logic End//////////////////////////////////
         


         teacherinfoframe.add(teacherinfopanel);
         teacherinfoframe.setVisible(true);
    }
    
}
