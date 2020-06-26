
package emailapplication;
import static emailapplication.class2.m;
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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class class3 extends EmailApplication {
    
public Session s;
static MimeMessage m;
private static String user="";
private static  String pass="";
public static String strfile="";
    public class3(String to,String sub,String msg,String user,String pass,Session s) throws IOException
    {
        System.out.println("hh");
        System.out.println(this.strfile);
        


       this.pass=pass;
      this.user=user;
      this.s=s;
      String emailregax="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
      Pattern emailpat=Pattern.compile(emailregax,Pattern.CASE_INSENSITIVE);
      Matcher matcher=emailpat.matcher(user);
      
      boolean bool=matcher.find();
      if(bool)
      {
      
       try{
          
          m=new MimeMessage(s);
          m.setFrom(new InternetAddress(user));
          m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          
      MimeBodyPart attach=new MimeBodyPart();
      String filename=this.strfile;
      //System.out.println(filename);
      DataSource source=new FileDataSource(filename);
      attach.setDataHandler(new DataHandler(source));
      attach.setFileName(filename);
      
      Multipart multi=new MimeMultipart();
      
      multi.addBodyPart(attach);
      m.setSubject(sub);
      m.setDescription(msg);
      m.setContent(multi);
      
      Transport.send(m);
       
        
     
          
          JDialog mailsuccess=new JDialog(frame,"Succeeded",true);
          mailsuccess.setBounds(450, 200, 300, 130);
          Container mailsuccesscont=mailsuccess.getContentPane();
          mailsuccesscont.setBackground(Color.lightGray);
          mailsuccess.setLayout(null);
          JLabel mailsuccessmsg=new JLabel("Mail sent successfully.");
          mailsuccessmsg.setBounds(50, 10, 170, 30);
          JButton mailsuccessbut=new JButton("Ok");
          mailsuccessbut.setBounds(80,50,100,30);
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
          userorpassincorrect.setBounds(450, 200, 300, 130);
          Container userorpassincorrectcont=userorpassincorrect.getContentPane();
          userorpassincorrectcont.setBackground(Color.lightGray);
          userorpassincorrect.setLayout(null);
          JLabel userorpassincorrectmsg=new JLabel("Email or Password is incorrect.");
          userorpassincorrectmsg.setBounds(50, 10, 200, 30);
          JButton userorpassincorrectbut=new JButton("Ok");
          userorpassincorrectbut.setBounds(80,50,100,30);
          userorpassincorrectbut.setBackground(Color.lightGray);
          userorpassincorrect.add(userorpassincorrectbut);
          userorpassincorrect.add(userorpassincorrectmsg);
          
          
          
          
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
          JLabel mailinvalidmsg=new JLabel("Mail Invalid.");
          mailinvalidmsg.setBounds(50, 10, 170, 30);
          JButton mailinvalidbut=new JButton("Ok");
          mailinvalidbut.setBounds(80,50,100,30);
          mailinvalidbut.setBackground(Color.lightGray);
          mailinvalid.add(mailinvalidbut);
          mailinvalid.add(mailinvalidmsg);
          
          mailinvalid.setVisible(true);
          
          
          mailinvalidbut.addActionListener(new ActionListener()
          {
              public void actionPerformed(ActionEvent ae)
              {
                  mailinvalid.setEnabled(false);
                  
              }
          });
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

