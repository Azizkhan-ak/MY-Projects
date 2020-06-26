
package emailapplication;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class class2 extends EmailApplication{    
public Session s;
static MimeMessage m;
private static String user="";
private static  String pass="";

    public class2(String to,String sub,String msg,String user,String pass,Session s) throws NoSuchProviderException, MessagingException, IOException
   {
      this.pass=pass;
      this.user=user;
      this.s=s;
      
      String emailregax1="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
      Pattern emailpat1=Pattern.compile(emailregax1,Pattern.CASE_INSENSITIVE);
      Matcher matcher1=emailpat1.matcher(user);
     // String emailregax2="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
      //Pattern emailpat2=Pattern.compile(emailregax2,Pattern.CASE_INSENSITIVE);
      //Matcher matcher2=emailpat2.matcher(to);
      
      boolean bool1=matcher1.find();
      //boolean bool2=matcher2.find();
      if(bool1)
      {
  
    
      try{
          
          m=new MimeMessage(s);
         
          m.setFrom(new InternetAddress(user));
          m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          m.setSubject(sub);
          m.setText(msg);
       
          Transport.send(m);
     
          
          JDialog mailsuccess=new JDialog(frame,"Succeeded",true);
          mailsuccess.setBounds(450, 200, 400, 130);
          Container mailsuccesscont=mailsuccess.getContentPane();
          mailsuccesscont.setBackground(Color.lightGray);
          mailsuccess.setLayout(null);
         
          JLabel mailsuccessmsg=new JLabel("Mail sent successfully.");
          mailsuccessmsg.setBounds(100, 10, 170, 30);
          JButton mailsuccessbut=new JButton("Ok");
          mailsuccessbut.setBounds(130,50,100,30);
          mailsuccessbut.setBackground(Color.lightGray);
          mailsuccess.add(mailsuccessbut);
          mailsuccess.add(mailsuccessmsg);
          
          
          
          
          mailsuccessbut.addActionListener(new ActionListener()
          {
              public void actionPerformed(ActionEvent ae)
              {
                  mailsuccess.dispose();
                  
              }
          });
          mailsuccess.setVisible(true);
          
      }catch(Exception e)
      {
        
          System.out.println(e);
          JDialog userorpassincorrect=new JDialog(frame,"Failed",true);
          userorpassincorrect.setBounds(450, 200, 300, 300);
          Container userorpassincorrectcont=userorpassincorrect.getContentPane();
          userorpassincorrectcont.setBackground(Color.lightGray);
          userorpassincorrect.setLayout(null);
          JLabel userorpassincorrectmsg1=new JLabel("Error occured while sending mail");
          JLabel userorpassincorrectmsg2=new JLabel("This is because either you");
          JLabel userorpassincorrectmsg3=new JLabel("mail or password was incorrect or the");
          JLabel userorpassincorrectmsg4=new JLabel("content type was blocked by google");
          JLabel userorpassincorrectmsg5=new JLabel("it may be connection issue as well.");
          JLabel userorpassincorrectmsg6=new JLabel("Make sure check all above conditions");
          userorpassincorrectmsg1.setBounds(50, 10, 250, 30);
          userorpassincorrectmsg2.setBounds(50, 40, 250, 30);
          userorpassincorrectmsg3.setBounds(50, 70, 250, 30);
          userorpassincorrectmsg4.setBounds(50, 100, 250, 30);
          userorpassincorrectmsg5.setBounds(50, 130, 250, 30);
          userorpassincorrectmsg6.setBounds(50, 160, 250, 30);
          JButton userorpassincorrectbut=new JButton("Ok");
          userorpassincorrectbut.setBounds(100,210,100,30);
          userorpassincorrectbut.setBackground(Color.lightGray);
          userorpassincorrect.add(userorpassincorrectbut);
          userorpassincorrect.add(userorpassincorrectmsg1);
          userorpassincorrect.add(userorpassincorrectmsg2);
          userorpassincorrect.add(userorpassincorrectmsg3);
          userorpassincorrect.add(userorpassincorrectmsg4);
          userorpassincorrect.add(userorpassincorrectmsg5);
          userorpassincorrect.add(userorpassincorrectmsg6);
          
         
          
          
          userorpassincorrectbut.addActionListener(new ActionListener()
          {
              public void actionPerformed(ActionEvent ae)
              {
                 
                  userorpassincorrect.dispose();
              }
          });
           userorpassincorrect.setVisible(true);
      }
 
 
   }
      
   else
   {
          JDialog mailinvalid=new JDialog(frame,"Failed",true);
          mailinvalid.setBounds(450, 200, 300, 130);
          Container mailinvalidcont=mailinvalid.getContentPane();
          mailinvalidcont.setBackground(Color.lightGray);
          mailinvalid.setLayout(null);
          JLabel mailinvalidmsg=new JLabel(" User's Mail was Invalid.");
          mailinvalidmsg.setBounds(50, 10, 170, 30);
          JButton mailinvalidbut=new JButton("Ok");
          mailinvalidbut.setBounds(80,50,100,30);
          mailinvalidbut.setBackground(Color.lightGray);
          mailinvalid.add(mailinvalidbut);
          mailinvalid.add(mailinvalidmsg);
          
          
          
          
          mailinvalidbut.addActionListener(new ActionListener()
          {
              public void actionPerformed(ActionEvent ae)
              {
                  mailinvalid.dispose();
                  
              }
          });
          mailinvalid.setVisible(true);
   }
}
    public static String getusername()
    {
        return user;
    }
    public static String getpass()
    {
        return pass;
    }
    
   
}