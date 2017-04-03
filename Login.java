package demo.sphinx.voice;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
  
@SuppressWarnings("serial")
class Authenticate extends JFrame implements ActionListener
{
  JButton SUBMIT;

  JLabel label1,label2;
  final JTextField  text1,text2;
   Authenticate()
   {
	   getContentPane().setBackground(new java.awt.Color(102,253,170));
	   label1 = new JLabel();
	   label1.setText("Username:");
	   label1.setFont(new Font("Algerian", Font.PLAIN, 16));
	   label1.setBounds(100, 84, 106, 31);
	   text1 = new JTextField(15);
	   text1.setBounds(257,89,126,26);
	   
	   label2 = new JLabel();
	   label2.setText("Password:");
	   label2.setFont(new Font("Algerian", Font.PLAIN, 16));
	   label2.setBounds(100, 147, 106, 31);
	   text2 = new JPasswordField(15);
	   text2.setBounds(257, 147, 126, 26);
	   
	   SUBMIT=new JButton("Login");
	   SUBMIT.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
	   SUBMIT.setBounds(197, 225, 106, 31);
	   SUBMIT.setBackground(new java.awt.Color(255,139,74));
   
	   getContentPane().setLayout(null);
	      
	   JLabel lblSpeechRecognition = new JLabel("Voice Recognition");
		lblSpeechRecognition.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblSpeechRecognition.setBounds(134, 11, 248, 58);
		getContentPane().add(lblSpeechRecognition);
	   
	   getContentPane().add(label1);
	   getContentPane().add(label2);
	   getContentPane().add(text1);
	   getContentPane().add(text2);
	   
	   
	   SUBMIT.addActionListener(this);
	   setTitle("USER AUTHENTICATION");
	   getContentPane().add(SUBMIT);
	   
   }
   
  public void actionPerformed(ActionEvent ae)
   {
	  String value1=text1.getText();
	  String value2=text2.getText();
	  if (value1.equals("voice") && value2.equals("recognition"))
	  {
		  	Home page=new Home(rootPaneCheckingEnabled);
		  	page.setVisible(true);
		  	getContentPane().setVisible(false);
		  	
		  	JLabel label = new JLabel("Welcome:"+value1);
		  	page.getContentPane().add(label);
	  }
	  else
	  {
		  System.out.println("Enter the valid username and password");
		  JOptionPane.showMessageDialog(this,"Incorrect login or password",
		     "Error",JOptionPane.ERROR_MESSAGE);
		  text1.setText("");
		  text2.setText("");
	  }
   }
 }
  class Login
 {
   public static void main(String arg[])
   {
   try
   {
	   
	   Authenticate frame=new Authenticate();
	   frame.setSize(500,500);
	   frame.setVisible(true);
	 
	   
   }
   catch(Exception e)
   {
	   JOptionPane.showMessageDialog(null, e.getMessage());
   }
  }
}
 
