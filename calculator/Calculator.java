
package calculator;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.text.BadLocationException;
public class Calculator {

static double firstnumber,secondnumber,result,temp1,temp2;
static String Operations;
private Object math;
public static JButton Back,one,two,three,four,five,six,seven,eight,nine,zero,Plus,Minus,Multiply
        ,Divide,Remainder,c,equal,sin,cos,tan,log,sinh,cosh,sec,cosec,logbase10
        ,cot,backward,forward,acos,asin,atan,on,off;
public static JTextField Text;
    public static void main(String[] args) {

        
        
        JFrame f=new JFrame("Simple Calculator");
        
        Container cntr=f.getContentPane();
        cntr.setBackground(Color.LIGHT_GRAY);
        
        f.setLayout(null);
        f.setSize(600,460);
        f.setLocation(400,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ii=new ImageIcon("E:\\eidulfitr\\calculator.png");
        f.setIconImage(ii.getImage());
        f.setResizable(false);
        
        
        
        
         one=new JButton("1");
        one.setBounds(10,250,50,50);
        one.setBackground(Color.black);
        one.setForeground(Color.white);
        one.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
              String iNUm=Text.getText()+one.getText();
              Text.setText(iNUm);
              
            }
        });
        f.add(one);
        two=new JButton("2");
        two.setBounds(70,250,50,50);
        two.setBackground(Color.black);
        two.setForeground(Color.white);
        two.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+two.getText();
                Text.setText(iNUm);
            }
        });
        
        f.add(two);
        three=new JButton("3");
        three.setBounds(130,250,50,50);
        three.setBackground(Color.black);
        three.setForeground(Color.white);
        three.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+three.getText();
                Text.setText(iNUm);
            }
        });
        f.add(three);
        four=new JButton("4");
        four.setBounds(10,190,50,50);
        four.setBackground(Color.black);
        four.setForeground(Color.white);
        four.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+four.getText();
                Text.setText(iNUm);
            }
        });
        f.add(four);
        five=new JButton("5");
        five.setBounds(70,190, 50, 50);
        five.setBackground(Color.black);
        five.setForeground(Color.white);
        five.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+five.getText();
                Text.setText(iNUm);
            }
        });
        f.add(five);
        six=new JButton("6");
        six.setBounds(130,190,50,50);
        six.setBackground(Color.black);
        six.setForeground(Color.white);
        six.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+six.getText();
                Text.setText(iNUm);
            }
        });
        f.add(six);
        seven=new JButton("7");
        seven.setBounds(10,130, 50, 50);
        seven.setBackground(Color.black);
        seven.setForeground(Color.white);
        seven.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+seven.getText();
                Text.setText(iNUm);
            }
        });
        f.add(seven);
        eight=new JButton("8");
        eight.setBounds(70, 130, 50, 50);
        eight.setBackground(Color.black);
        eight.setForeground(Color.white);
        eight.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+eight.getText();
                Text.setText(iNUm);
            }
        });
        f.add(eight);
        nine=new JButton("9");
        nine.setBounds(130, 130, 50, 50);
        nine.setBackground(Color.black);
        nine.setForeground(Color.white);
        nine.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+nine.getText();
                Text.setText(iNUm);
            }
        });
        f.add(nine);
        zero=new JButton("0");
        zero.setBounds(70,310, 50, 50);
        zero.setBackground(Color.black);
        zero.setForeground(Color.white);
        zero.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String iNUm=Text.getText()+zero.getText();
                Text.setText(iNUm);
            }
        });
        f.add(zero);
        JButton dot=new JButton(".");
        dot.setBounds(10,310,50,50);
        dot.setBackground(Color.black);
        dot.setForeground(Color.white);
        dot.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(!Text.getText().contains("."))
                {
                    Text.setText(Text.getText()+dot.getText());
                    
                }
            }
        });
        
        f.add(dot);
        JButton sqrt=new JButton("sq");
        sqrt.setBounds(130,310, 50, 50);
        sqrt.setBackground(Color.blue);
        sqrt.setForeground(Color.white);
        f.add(sqrt);
        sqrt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(Text.getText().toString());
                ops=Math.sqrt(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        Plus=new JButton("+");
        Plus.setBounds(190,250,50,50);
        Plus.setBackground(Color.blue);
        Plus.setForeground(Color.white);
        Plus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               firstnumber=Double.parseDouble(Text.getText());
               Text.setText(null);
               Operations=("+");
               
            }
        });
        f.add(Plus);
        Minus=new JButton("-");
        Minus.setBounds(250,250,50,50);
        Minus.setBackground(Color.blue);
        Minus.setForeground(Color.white);
        Minus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               firstnumber=Double.parseDouble(Text.getText());
               Text.setText(null);
               Operations=("-");
            }
        });
        f.add(Minus);
        Multiply=new JButton("x");
        Multiply.setBounds(190,190,50,50);
        Multiply.setBackground(Color.blue);
        Multiply.setForeground(Color.white);
        Multiply.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               firstnumber=Double.parseDouble(Text.getText());
               Text.setText(null);
               Operations=("*");
            }
        });
        f.add(Multiply);
        Divide=new JButton("/");
        Divide.setBounds(250,190, 50,50);
        Divide.setBackground(Color.blue);
        Divide.setForeground(Color.white);
        Divide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(Text.getText());
               Text.setText(null);
               Operations=("/");
            }
        });
        f.add(Divide);
        Remainder=new JButton("%");
        Remainder.setBounds(190, 130, 50, 50);
        Remainder.setBackground(Color.blue);
        Remainder.setForeground(Color.white);
        f.add(Remainder);
        Remainder.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(Text.getText());
               Text.setText(null);
               Operations="%";
            }
        });
        
        sin=new JButton("sin");
        sin.setBounds(310,130, 60, 50);
        sin.setBackground(Color.blue);
        sin.setForeground(Color.white);
        f.add(sin);
        sin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.sin(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        
        cos=new JButton("cos");
        cos.setBounds(380,130, 60, 50);
        cos.setBackground(Color.blue);
        cos.setForeground(Color.white);
        f.add(cos);
          cos.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.cos(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        tan=new JButton("tan");
        tan.setBounds(310,190 , 60, 50);
        tan.setBackground(Color.blue);
        tan.setForeground(Color.white);
        f.add(tan);
          tan.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.tan(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        log=new JButton("log");
        log.setBounds(520,130, 60, 50);
        log.setBackground(Color.blue);
        log.setForeground(Color.white);
        f.add(log);
          log.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.log(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        JButton pi=new JButton("PI");
        pi.setBounds(450,310, 60, 50);
        pi.setBackground(Color.blue);
        pi.setForeground(Color.white);
        f.add(pi);
        pi.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=(3.1415926535897932384626433832795);
                Text.setText(String.valueOf(ops));
                
            }
        });
        JButton xpowy=new JButton("x^y");
        xpowy.setBounds(520,190, 60, 50);
        xpowy.setBackground(Color.blue);
        xpowy.setForeground(Color.white);
        f.add(xpowy);
        xpowy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                Text.setText(null);
                Operations="xpowy";
            }
        });
        JButton xpow2=new JButton("x^2");
        xpow2.setBounds(520, 250, 60, 50);
        xpow2.setBackground(Color.blue);
        xpow2.setForeground(Color.white);
        xpow2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(Text.getText().toString());
                firstnumber=Math.pow(firstnumber,2);
                String ans=String.valueOf(firstnumber);
                Text.setText(ans);
            }
        });
        f.add(xpow2);
        JButton xpow3=new JButton("x^3");
        xpow3.setBounds(520,310,60, 50);
        xpow3.setBackground(Color.blue);
        xpow3.setForeground(Color.white);
        xpow3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(Text.getText().toString());
                firstnumber=Math.pow(firstnumber,3);
                String ans=String.valueOf(firstnumber);
                Text.setText(ans);
            }
        });
        f.add(xpow3);
        logbase10=new JButton("L10");
        logbase10.setBounds(450, 130, 60, 50);
        logbase10.setBackground(Color.blue);
        logbase10.setForeground(Color.white);
        logbase10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.log10(firstnumber);
                Text.setText(String.valueOf(firstnumber));
            }
        });
        f.add(logbase10);
        backward=new JButton("<<");
        backward.setBounds(450,190, 60, 50);
        backward.setBackground(Color.blue);
        backward.setForeground(Color.white);
        backward.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a=Text.getCaretPosition();
                Text.setCaretPosition(a-1);
                
            }
        });
        f.add(backward);
        forward=new JButton(">>");
        forward.setBounds(450,250, 60, 50);
        forward.setBackground(Color.blue);
        forward.setForeground(Color.white);
        forward.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a=Text.getCaretPosition();
               
            }
        });
        f.add(forward);
        cot=new JButton("cot");
        cot.setBounds(380,190, 60, 50);
        cot.setBackground(Color.blue);
        cot.setForeground(Color.white);
        cot.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                temp1=Math.cos(firstnumber);
                temp2=Math.sin(firstnumber);
                firstnumber=temp1/temp2;
                Text.setText(String.valueOf(firstnumber));
            }
        });
        f.add(cot);
        
        sinh=new JButton("sinh");
        sinh.setBounds(310,250, 60, 50);
        sinh.setBackground(Color.blue);
        sinh.setForeground(Color.white);
        f.add(sinh);
        sinh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.sinh(ops);
                Text.setText(String.valueOf(ops));
            }
        });
        
        cosh=new JButton("coh");
        cosh.setBounds(380,250, 60, 50);
        cosh.setBackground(Color.blue);
        cosh.setForeground(Color.white);
        f.add(cosh);
          cosh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                double ops=Double.parseDouble(String.valueOf(Text.getText()));
                ops=Math.cosh(ops);
                Text.setText(String.valueOf(ops));
            }
        });
          
        sec=new JButton("sec");
        sec.setBounds(310, 310, 60, 50);
        sec.setBackground(Color.blue);
        sec.setForeground(Color.white);
        f.add(sec);
        sec.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.cos(firstnumber);
                firstnumber=1/firstnumber;
                Text.setText(String.valueOf(firstnumber));
            }
        });
        cosec=new JButton("csc");
        cosec.setBounds(380,310,60, 50);
        cosec.setBackground(Color.blue);
        cosec.setForeground(Color.white);
        cosec.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.sin(firstnumber);
                firstnumber=1/firstnumber;
                Text.setText(String.valueOf(firstnumber));
            }
        });
        f.add(cosec);
        acos=new JButton("cos-1");
        acos.setBounds(10,370,182, 50);
        acos.setBackground(Color.blue);
        acos.setForeground(Color.white);
        acos.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.acos(firstnumber);
                Text.setText(String.valueOf(firstnumber));
            }
        });
        
        f.add(acos);
        asin=new JButton("sin-1");
        asin.setBounds(203,370,182, 50);
        asin.setBackground(Color.blue);
        asin.setForeground(Color.white);
        asin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.asin(firstnumber);
                Text.setText(String.valueOf(firstnumber));
            }
        });
        f.add(asin);
        atan=new JButton("tan-1");
        atan.setBounds(396,370,182, 50);
        atan.setBackground(Color.blue);
        atan.setForeground(Color.white);
        atan.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                firstnumber=Double.parseDouble(String.valueOf(Text.getText()));
                firstnumber=Math.atan(firstnumber);
                Text.setText(String.valueOf(firstnumber));
            }
        });
        f.add(atan);
        on=new JButton("ON");
        on.setBounds(10,85, 280, 35);
        on.setBackground(Color.red);
        on.setForeground(Color.white);
        on.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                Text.setText(null);
                Text.show();
            }
        });
        
        f.add(on);
        off=new JButton("OFF");
        off.setBounds(300,85, 280, 35);
        off.setBackground(Color.red);
        off.setForeground(Color.white);
        off.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
               Text.setText(null);
               Text.hide();
               
              
           }
        });
        f.add(off);
        
        equal =new JButton("=");
        equal.setBounds(250,310, 50, 50);
        equal.setBackground(Color.blue);
        equal.setForeground(Color.white);
        f.add(equal);
     
        equal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String answer;
                
                secondnumber=Double.parseDouble(Text.getText());
                if(Operations=="+")
                {
                    result=firstnumber+secondnumber;
                    answer=String.valueOf(result);
                    Text.setText(answer);
                }
               else if(Operations=="-")
                {
                    result=firstnumber-secondnumber;
                    answer=String.valueOf(result);
                    Text.setText(answer);
                }
               else if(Operations=="*")
                {
                    result=firstnumber*secondnumber;
                    answer=String.valueOf(result);
                    Text.setText(answer);
                }
               else if(Operations=="/")
                {
                    result=firstnumber/secondnumber;
                    answer=String.valueOf(result);
                    Text.setText(answer);
                }
               else if(Operations=="%")
                {
                    result=firstnumber%secondnumber;
                    answer=String.valueOf(result);
                    Text.setText(answer);
                }
               else if(Operations=="sin")
               {
                   secondnumber=Double.parseDouble(Text.getText());
                   
               }
               else if(Operations=="xpowy")
               {
                   secondnumber=Double.parseDouble(String.valueOf(Text.getText()));
                   result=Math.pow(firstnumber,secondnumber);
                   answer=String.valueOf(result);
                   Text.setText(answer);
               }
               
            }
        });
        c=new JButton("c");
        c.setBounds(250,130, 50, 50);
        c.setBackground(Color.red);
        c.setForeground(Color.white);
        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               Text.setText(null);
            }
        });
        f.add(c);
        
        
        
        
      
        Back=new JButton("D");
        Back.setBounds(190, 310, 50, 50);
        Back.setBackground(Color.blue);
        Back.setForeground(Color.white);
        Back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) 
            {
          
               
                    String str0=Text.getText();
                try {
                    
                    String str1=Text.getText(0,str0.length()-1);
                    Text.setText(str1);
                } catch (BadLocationException ex) { }
               }
               
               
                
            
        });
        f.add(Back);
        
        Text=new JTextField();
        Text.setBounds(10,10,575,70);
        Text.setFont(new Font("A",Font.BOLD,30));
        Text.setBackground(Color.DARK_GRAY);
        Text.setForeground(Color.white);
        
        Text.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if((c<'0')||(c>'9'))
                {
                    ke.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                
            }
        });
        f.add(Text);
      
        
        f.setVisible(true);
    
        
        
    }
    
}
