package demo.sphinx.voice;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
  
@SuppressWarnings("serial")
public class Home extends JFrame
{
	private JTextField messageTextField;
	private JButton speakButton,btnCancel;
	private JLabel label,lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,label_1,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,lblNewLabel_8;
	private boolean continuousMode=true;
	
	private VoiceRecognizer voiceRecognizer;
	
	public Home(boolean continuousMode)
	{
		super("VOICE RECOGNITION");
		this.continuousMode = continuousMode;
		setTitle("Welcome");
	
		setSize(800,800);
		getContentPane().setLayout(null);
		
		display();
        setMessage("Loading...Select and speak a number");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
                if (voiceRecognizer != null) 
				{
                    voiceRecognizer.shutdown();
                }
                System.exit(0);
            }
        });
		
		speakButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent ae)
			{
            	
                if (speakButton.isEnabled()) 
				{
                	setMessage("Select and speak a number...");
                    speakButton.setEnabled(false);
                    try
                    {
                    	startListening();
                    }
                    catch(IOException e)
                    {
                    	e.printStackTrace();
                    }
				}
			}
        });
		
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(btnCancel.isEnabled())
				{
					btnCancel.setEnabled(false);
					System.exit(0);
				}
			}
		});
    }
	

	private void startListening() throws IOException
	{
		go();
    }
	
	public void go() 
	{
        try 
		{                  
            setMessage("Loading recognizer...");
            voiceRecognizer = new VoiceRecognizer();

            setMessage("Starting recognizer...");
            voiceRecognizer.startup();

            if (continuousMode) 
            {
                startListening();
            } else 
            {
                setMessage("Ready");
            }
        } catch (Throwable e) {
            setMessage("Error: " + e.getMessage());
        }
    }
	
	public void display()
	{
		  getContentPane().setBackground(new java.awt.Color(102,253,170));
		
		  speakButton = new JButton("SPEAK");
		  speakButton.setFont(new Font("Algerian", Font.PLAIN, 20));
		  speakButton.setBounds(174, 646, 164, 50);
		  speakButton.setBackground(new java.awt.Color(234,21,74));
		  getContentPane().add(speakButton);
		  
		  label = new JLabel("1. Command Prompt");
		  label.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  label.setBounds(28, 92, 215, 23);
		  label.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(label);
		  
		  lblNewLabel = new JLabel("2. Microsoft Excel");
		  lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel.setBounds(28, 135, 215, 23);
		  lblNewLabel.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel);
		  
		  lblNewLabel_1 = new JLabel("3. Calculator");
		  lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_1.setBounds(28, 176, 196, 23);
		  lblNewLabel_1.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_1);
		  
		  lblNewLabel_2 = new JLabel("4. Microsoft Access");
		  lblNewLabel_2.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_2.setBounds(28, 221, 215, 23);
		  lblNewLabel_2.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_2);
		  
		  lblNewLabel_3 = new JLabel("5. Media Player");
		  lblNewLabel_3.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_3.setBounds(28, 265, 215, 23);
		  lblNewLabel_3.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_3);
		  
		  label_1 = new JLabel("6. Control Panel");
		  label_1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  label_1.setBounds(28, 309, 196, 23);
		  label_1.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(label_1);
		  
		  lblNewLabel_4 = new JLabel("7. Google");
		  lblNewLabel_4.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_4.setBounds(28, 353, 196, 23);
		  lblNewLabel_4.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_4);
		  
		  lblNewLabel_5 = new JLabel("8. Task Manager");
		  lblNewLabel_5.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_5.setBounds(28, 398, 196, 23);
		  lblNewLabel_5.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_5);
		  
		  lblNewLabel_6 = new JLabel("9. Adobe Reader");
		  lblNewLabel_6.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_6.setBounds(28, 444, 196, 23);
		  lblNewLabel_6.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_6);
		  
		  lblNewLabel_7 = new JLabel("0. Close all programs");
		  lblNewLabel_7.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		  lblNewLabel_7.setBounds(28, 488, 215, 23);
		  lblNewLabel_7.setForeground(new java.awt.Color(234,21,74));
		  getContentPane().add(lblNewLabel_7);
		  
		  lblNewLabel_8 = new JLabel("Voice Recognition System");
		  lblNewLabel_8.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		  lblNewLabel_8.setBounds(190, 24, 375, 40);
		  lblNewLabel_8.setForeground(new java.awt.Color(53,31,250));
		  getContentPane().add(lblNewLabel_8);
		  
		  btnCancel = new JButton("Cancel");
		  btnCancel.setFont(new Font("Algerian", Font.PLAIN, 20));
		  btnCancel.setBounds(444, 646, 164, 50);
		  btnCancel.setBackground(new java.awt.Color(36,132,19));
		  getContentPane().add(btnCancel);
		  
		  messageTextField=new JTextField("   ");
		  messageTextField.setFont(new Font("Lucida Handwriting",Font.PLAIN,18));
		  messageTextField.setBounds(175,580,250,50);
		  getContentPane().add(messageTextField);
	}
	
	 public void setMessage(final String message) 
	 {
	        SwingUtilities.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                messageTextField.setText(message);
	            }
	        });
	   }
	 
	 public void setSpeakButtonEnabled(final boolean enabled) 
	 {
		 SwingUtilities.invokeLater(new Runnable() 
		 {
			 public void run() 
			 {
				 speakButton.setEnabled(enabled);
	          }
	      });
	  }
	 
	 public void setBtnCancelEnabled(final boolean enabled) 
	 {
		 SwingUtilities.invokeLater(new Runnable() 
		 {
			 public void run() 
			 {
				 btnCancel.setEnabled(enabled);
	          }
	      });
	  }
	 
	 
	 private static void usage() 
	 {
	        System.out.println("Usage:  Home [-continuous] [-help]");
	 
	 }
	 
	 public static void main(String args[])
	 {
		  boolean continuous = false;

	      for (String arg : args) 
	      {
	            if (arg.equals("-continuous")) 
	            {
	                continuous = true;
	            } else 
	            {
	                usage();
	                System.exit(0);
	            }
	        }

	      Home hm = new Home(continuous);
	      hm.setVisible(true);
	      hm.go();
	 }
}