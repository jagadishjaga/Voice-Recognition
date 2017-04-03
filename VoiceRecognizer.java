package demo.sphinx.voice;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.recognizer.Recognizer.State;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.speech.recognition.ResultToken;

@SuppressWarnings("unused")
public class VoiceRecognizer implements Runnable
{
	 private Microphone microphone;
     private Recognizer recognizer;
 
	 
	 static int i=1;
	 static String resultText;
	 
	 public VoiceRecognizer() throws IOException
	 {
		 
		try
		{
			URL url = this.getClass().getResource("helloworld.config.xml");
	        if (url == null) 
	        {
	             throw new IOException("Can't find helloworld.config.xml");
	        }
			ConfigurationManager cm = new ConfigurationManager(url);

	         recognizer = (Recognizer) cm.lookup("recognizer");
			 microphone = (Microphone) cm.lookup("microphone");
		}
		catch (PropertyException e) 
		{
            throw new IOException("Problem configuring VoiceRecognizer " + e);
        }
        
	}
	
	public boolean microphoneOn() throws IOException
	{			
        new Thread(this).start();
        return true;
		
    }
	

	public void microphoneOff() 
	{
        microphone.stopRecording();
    }
	
	public void startup() throws IOException
	{
		recognizer.allocate();
		microphone.startRecording();
		//run();

		while(true)
		{
		Result result=recognizer.recognize();
	//	microphone.stopRecording();
		if (result != null) 
		{
            String resultText = result.getBestFinalResultNoFiller();
			
			if(resultText.equalsIgnoreCase("one"))
    		{
    			try
    			{
    				Process p;
    				p = Runtime.getRuntime().exec("cmd /c start cmd");
			 				
    			}
    			catch(Exception er)
    			{}
    		}
    		
    		else if (resultText.equalsIgnoreCase("two"))
    		{
    			try
    			{
    				Process p;	
    				p = Runtime.getRuntime().exec("cmd /c start excel");
    				
    			}
    			catch(Exception ae)
    			{}
    		}
    		else if (resultText.equalsIgnoreCase("three"))
    		{
    			try
    			{
    				Process p;	
    				p = Runtime.getRuntime().exec("cmd /c start calc");
	     
    			}
    			catch(Exception ae)
    			{}
    		}
    		else if (resultText.equalsIgnoreCase("four"))
    		{
    			try
    			{
    				Process p;	
    				p = Runtime.getRuntime().exec("cmd /c start msaccess");
    				
    			}
    			catch(Exception ae)
    			{}
    		}
    		else if (resultText.equalsIgnoreCase("five"))
    		{
    			try
    			{
    				Process p;
	      				p = Runtime.getRuntime().exec("cmd /c start wmplayer");
    			
    			}
    			catch(Exception ae){}
    		}
    		else if (resultText.equalsIgnoreCase("six"))
    		{
    			try
    			{
    				Process p;
    				p = Runtime.getRuntime().exec("cmd /c control");
    			}
    			catch(Exception ae){}
    		}
    		else if(resultText.equalsIgnoreCase("seven"))
    		{
    			try
    			{
    				Process p;
			    	    p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
			        }
    			catch(Exception ae){}
    		}
    		
    		else if (resultText.equalsIgnoreCase("eight"))
    		{
    			try
    			{
    				Process p;
    				p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
	      
    			}
    			catch(Exception ae){}
    		}
		
    		else if(resultText.equalsIgnoreCase("nine"))
    		{
    			try
    			{
    				Process p;
		    	        p = Runtime.getRuntime().exec("cmd /c start acrord32.exe");
		            }
    			catch(Exception ae){}
    		}
    		else if(resultText.equalsIgnoreCase("zero"))
    		{	 
    			try	
    			{
    				Process p,q,r,s,t,u,v,w,x;
	    	
    				p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
    				q = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
    				r = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
    				s = Runtime.getRuntime().exec("cmd /c start taskkill /im msaccess.exe /f");
    				t = Runtime.getRuntime().exec("cmd /c start taskkill /im wmplayer.exe /f");
    				u = Runtime.getRuntime().exec("cmd /c start taskkill /im control.exe /f");
    				v = Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
    				w = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
    				x = Runtime.getRuntime().exec("cmd /c start taskkill /im acrord32.exe /f");
    			}
    			catch(Exception ae){}
    		}
    		
    
		}
		}
	}
	
	
	public void shutdown()
	{
		microphoneOff();
		if (recognizer.getState() == State.ALLOCATED) 
		{
            recognizer.deallocate();
        }
    }

	public void run() 
	{
		// TODO Auto-generated method stub
	}		
}

	

			
