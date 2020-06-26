
package emailapplication;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;
public class EmailApplication {
//public static Session se;
public static Session s;
public static JFrame frame;
//public static String strfile="";
public static boolean check=true;
public static JButton send;

 public static void main(String[] args) throws InstantiationException, IllegalAccessException {
       
 ////////////////////////////////////////////////////////////////////////////////
 /////////////////////////INITIALIZER BLOCK/////////////////////////////////////
 JFrame init=new JFrame("Initializer");
 init.setLayout(null);
 init.setResizable(false);
 init.setUndecorated(true);
 JButton initclose=new JButton("Close");
 initclose.setBounds(340, 0, 70, 20);
 initclose.setBackground(Color.lightGray);
 init.add(initclose);

 Container initcontainer=init.getContentPane();
 initcontainer.setBackground(Color.lightGray);
 ImageIcon initlogo=new ImageIcon("D:\\mail1.png");
 init.setIconImage(initlogo.getImage());
 JLabel Google_Account=new JLabel("Google Account");
 Google_Account.setBounds(100, 10, 200, 30);
 Google_Account.setFont(new Font("",Font.BOLD,25));
 Google_Account.setForeground(Color.red);
 init.add(Google_Account);
 init.setBackground(Color.lightGray);
 init.setBounds(450, 180, 400, 300);
 
 JLabel initmaillabel=new JLabel("Gmail");
 initmaillabel.setFont(new Font("",Font.BOLD,20));
 initmaillabel.setBounds(10, 70, 100, 30);
 init.add(initmaillabel);
 JTextField initmailtext=new JTextField(30);
 initmailtext.setBounds(120, 70, 240, 40);
 initmailtext.setFont(new Font("",Font.BOLD,17));
 initmailtext.setOpaque(false);
 init.add(initmailtext);
 JLabel initpasslabel=new JLabel("Password");
 initpasslabel.setBounds(10,140, 100,30);
 initpasslabel.setFont(new Font("",Font.BOLD,20));
 init.add(initpasslabel);
 JPasswordField initpasstext=new JPasswordField(30);
 initpasstext.setBounds(120, 140, 240, 40);
 initpasstext.setFont(new Font("",Font.BOLD,17));
 initpasstext.setOpaque(false);
 initpasstext.setEchoChar('*');
 init.add(initpasstext);
 JRadioButton see=new JRadioButton();
 see.setBounds(370,140,20,10);
 see.setBackground(Color.lightGray);
 init.add(see);
 see.setSelected(false);
 see.addItemListener(new ItemListener()
 {
     @Override
     public void itemStateChanged(ItemEvent e) {

         if(e.getStateChange()==ItemEvent.DESELECTED)
         {
             initpasstext.setEchoChar('*');
         }
         else
         {
             initpasstext.setEchoChar((char)0);
         }
         
     }
     
 });
 JLabel seel=new JLabel("See");
 seel.setBounds(370,160,30,10);
 init.add(seel);
 JButton initbut=new JButton("Login");
 initbut.setBounds(160, 200, 150, 40);
 initbut.setBackground(Color.lightGray);
 init.add(initbut);
 init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  initclose.addActionListener(new ActionListener()
 {
     public void actionPerformed(ActionEvent ae)
     {
         init.dispose();
     }
 });
  initbut.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ae)
      {
          
          init.dispose();
          
 ///////////////////////////JFRAME SENDING BOCK/////////////////////////////////////////////
frame=new JFrame();
frame.setLayout(null);
frame.setBounds(350, 100, 500, 400);
JPanel fpanel=new JPanel();
fpanel.setLayout(null);
fpanel.setBounds(10, 30, 480, 360);
fpanel.setBackground(Color.lightGray);
Border panelborder=BorderFactory.createLineBorder(Color.MAGENTA, 5, true);
fpanel.setBorder(panelborder);
Container container=frame.getContentPane();
container.setBackground(Color.black);
ImageIcon sendlogo=new ImageIcon("E:\\eidulfitr\\mail1.png");
frame.setIconImage(sendlogo.getImage());
frame.add(fpanel);
frame.setResizable(false);
Font font=new Font("",Font.BOLD,15);
frame.setUndecorated(true);
JLabel lto=new JLabel("To: ");
lto.setBounds(10, 10, 40, 30);
lto.setFont(font);
fpanel.add(lto);
JTextField tTO =new JTextField();
tTO.setText(" ");
tTO.setBounds(50, 10, 420, 30);
tTO.setFont(font);
tTO.setOpaque(false);
tTO.setCaretColor(Color.darkGray);
tTO.setSelectedTextColor(Color.blue);
fpanel.add(tTO);
JLabel lsub=new JLabel("Sub: ");
lsub.setBounds(10, 50, 50, 30);
lsub.setFont(font);
fpanel.add(lsub);
JTextField tsub=new JTextField(30);
tsub.setText(" ");
tsub.setBounds(50,50,420,30);
tsub.setFont(font);
tsub.setSelectedTextColor(Color.blue);
tsub.setOpaque(false);
fpanel.add(tsub);
JLabel lmsg=new JLabel("Msg:");
lmsg.setBounds(10,90,40, 30);
lmsg.setFont(font);
fpanel.add(lmsg);
TextArea tmsg=new TextArea();
tmsg.setText(" ");
tmsg.setBounds(50,90, 420,200);
tmsg.setFont(font);
tmsg.setBackground(Color.lightGray);
fpanel.add(tmsg);
JButton close=new JButton("Close");
close.setBounds(380, 0, 100, 20);
close.setBackground(Color.lightGray);

frame.add(close);
close.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        frame.dispose();
    }
});



///////////////////////////SESSSION OBJECT ///////////////////////////

  Properties p=new Properties();
      p.put("mail.smtp.host","smtp.gmail.com");
      p.put("mail.smtp.socketFactory.port","465");
      p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      p.put("mail.smtp.auth","true");
      p.put("mail.smtp.port","465");
      p.put("mail.smtp.port","587");
      p.put("mail.smtp.host","smtp.gmail.com");
      p.put("mail.smtp.starttls.enable","true");
      p.put("mail.smtp.auth","true");
      p.put("mail.smtp.ssl.trust","smtp.gmail.com");
  s=Session.getInstance(p,new javax.mail.Authenticator()
      {
          @Override
          protected javax.mail.PasswordAuthentication getPasswordAuthentication()
          {
              return new javax.mail.PasswordAuthentication(initmailtext.getText(),initpasstext.getText());
          }
       });

/////////////////////////////////////////////////////////////////////
send=new JButton("Send");
send.setBounds(400, 310, 70, 30);
send.setBackground(Color.lightGray);
fpanel.add(send);

send.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        if(check)////////////////////CHECK IS TRUE/////////////////////////////////////////
        {
        try {
         class2 object1 = new class2(tTO.getText(),tsub.getText(),tmsg.getText(),initmailtext.getText(),initpasstext.getText(),s);
         
        } catch (MessagingException ex) {
            Logger.getLogger(EmailApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else///////////////////////////CHECK IS NOT TRUE////////////////////////////
        {
            try {
                class3 object3=new class3(tTO.getText(),tsub.getText(),tmsg.getText(),initmailtext.getText(),initpasstext.getText(),s);
            } catch (IOException ex) {
                Logger.getLogger(EmailApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
});
JButton inboxbut=new JButton("Inb");
inboxbut.setBounds(140, 310, 65, 30);
inboxbut.setBackground(Color.lightGray);
fpanel.add(inboxbut);
inboxbut.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        new inboxclass(s,initmailtext.getText(),initpasstext.getText());
        frame.dispose();
    }
});
JButton attachfile=new JButton("Atch");
attachfile.setBounds(330, 310, 70, 30);
attachfile.setBackground(Color.lightGray);
fpanel.add(attachfile);
attachfile.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        check=false;
        FileDialog filedialog=new FileDialog(frame,"Attach File");
        filedialog.setVisible(true);
       
        class3.strfile=filedialog.getDirectory()+filedialog.getFile();
        System.out.println(class3.strfile);
        
        
    }
});
JButton back=new JButton("Back");
back.setBackground(Color.lightGray);
back.setBounds(10, 310, 65, 30);
fpanel.add(back);
back.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {
        frame.dispose();
        init.setVisible(true);
    }
});
  JButton sentitem=new JButton("SentItm");
  sentitem.setBounds(75,310,78,30);
  sentitem.setBackground(Color.lightGray);
  fpanel.add(sentitem);
  sentitem.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ae)
      {
          new sentitems(s,initmailtext.getText(),initpasstext.getText());
      }
  });
  JButton drafts=new JButton("Drafts");
  drafts.setBackground(Color.lightGray);
  drafts.setBounds(205, 310, 70, 30);
  fpanel.add(drafts);
  drafts.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ae)
      {
          new Drafts(s,initmailtext.getText(),initpasstext.getText());
      }
  });
  JButton spam=new JButton("Spam");
  spam.setBackground(Color.lightGray);
  spam.setBounds(270,310,70,30);
  fpanel.add(spam);
  spam.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ae)
      {
          new Spam(s,initmailtext.getText(),initpasstext.getText());
      }
  });
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

/////////////////////////////////SENDING BLOCK ENDED///////////////////////////////
          
      }
  });

 init.setVisible(true);
 ///////////////////////////////INITIALIZER BLOCK END///////////////////////////////////////////////

 

    }
 
      
   }

