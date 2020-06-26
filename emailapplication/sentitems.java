
package emailapplication;

import static emailapplication.EmailApplication.frame;
import static emailapplication.EmailApplication.s;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class sentitems{
 
    String user="";
    String pass="";
    Session s;
   public sentitems(Session s,String user,String pass)
  {
  
        this.user=user;
        this.pass=pass;
        this.s=s;
       
        JFrame inboxframe=new JFrame("Sent Items");
        inboxframe.setLayout(null);
        inboxframe.setBounds(0, 0, 1350, 600);
       // inboxframe.setUndecorated(true);

       
       
     
        TextArea inboxmsgs=new TextArea();
        inboxmsgs.setBackground(Color.lightGray);
        inboxmsgs.setFont(new Font("",Font.BOLD,30));
        inboxmsgs.setBounds(0, 0, 1340, 550);
        try (Store store = s.getStore("imaps")) {
            store.connect("smtp.gmail.com", user, pass);
            
            inboxframe.add(inboxmsgs);
            
            
            Folder folder = store.getFolder("[Gmail]/Sent Mail");
           
            int messageCount = folder.getMessageCount();
            System.out.println(messageCount);
            inboxmsgs.setForeground(Color.blue);
            inboxmsgs.setText("Total Messages : "+(messageCount)+"\n");
            
            
            
           // Message[] messages = folder.getMessages();
             folder.open(Folder.READ_ONLY);
  Message[] msg = folder.getMessages();
System.out.println(msg.length);
  for (int i =msg.length-1; i>240 ;i--) {
      
  inboxmsgs.setText(inboxmsgs.getText()+" \n------------ Message " + (i + 1) + " ------------");
  String from = InternetAddress.toString(msg[i].getFrom());
  if (from != null) {
  inboxmsgs.setText(inboxmsgs.getText()+"\nFrom: " + from);
  }

  String replyTo = InternetAddress.toString(
  msg[i].getReplyTo());
  if (replyTo != null) {
  inboxmsgs.setText(inboxmsgs.getText()+"\nReply-to: " + replyTo);
  }
  String to = InternetAddress.toString(
  msg[i].getRecipients(Message.RecipientType.TO));
  if (to != null) {
  inboxmsgs.setText(inboxmsgs.getText()+"\nTo: " + to);
  }

  String subject = msg[i].getSubject();
  if (subject != null) {
  inboxmsgs.setText(inboxmsgs.getText()+"\nSubject: " + subject);
  }
  Date sent = msg[i].getSentDate();
  if (sent != null) {
  inboxmsgs.setText(inboxmsgs.getText()+"\nSent: " + sent);
  }
try{

    
    System.out.println("Message : ");
    
     Object mp = (Object) msg[i].getContent();

                    if (mp instanceof String)  
                    {  
                        String body = (String)mp;
                        if(!(body.contains("<head>")) &&!(body.contains("com.sun.mail.util.BASE64DecoderStream@2a50ac6e")))
                        {   
                        inboxmsgs.setText(inboxmsgs.getText()+"\nMSG Body : " + body);
                        //inboxmsgs.setText(inboxmsgs.getText()+"\nInstance of String");
                        }
                        else
                        {
                            continue;
                        }
                    }  
                    else if (mp instanceof Multipart)  
                    {  
                        MimeMultipart mpp = (MimeMultipart)mp;
                        final MimeBodyPart bp = (MimeBodyPart) mpp.getBodyPart(0);
                       // inboxmsgs.setText(inboxmsgs.getText()+"\nInstance of MP");
                        inboxmsgs.setText(inboxmsgs.getText()+"\nMsg Body: " +bp.getContent().toString());
                    } else {
                       // System.out.println("Inside else");
                        Multipart mpp = (Multipart)mp;
                        final BodyPart bp = mpp.getBodyPart(0);
                        inboxmsgs.setText(inboxmsgs.getText()+"\nText: " +bp.getContent().toString());
                    }
 
//   folder.close(true);
  //store.close();
  
   
    inboxmsgs.setText(inboxmsgs.getText()+"\n\n");
    inboxmsgs.setText(inboxmsgs.getText()+"----------------------------------------------------------------------");    
 
       
  inboxframe.setVisible(true);
  inboxframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }catch(MessagingException e)
        {
             JDialog userorpassincorrect=new JDialog(frame,"Failed",true);
          userorpassincorrect.setBounds(450, 200, 300, 300);
          Container userorpassincorrectcont=userorpassincorrect.getContentPane();
          userorpassincorrectcont.setBackground(Color.lightGray);
          userorpassincorrect.setLayout(null);
          JLabel userorpassincorrectmsg1=new JLabel("Error occured while fetching your inbox");
          JLabel userorpassincorrectmsg2=new JLabel("This is because either your");
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
        
        }       catch (IOException ex) {
                    Logger.getLogger(inboxclass.class.getName()).log(Level.SEVERE, null, ex);
                }
       
        }      
}       catch (NoSuchProviderException ex) {        
            Logger.getLogger(inboxclass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(inboxclass.class.getName()).log(Level.SEVERE, null, ex);
        }          
}
}  

