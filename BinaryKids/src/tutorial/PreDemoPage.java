package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class PreDemoPage extends JPanel implements ActionListener
{
    
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image crossOutImage;
    
    String explanation1 = "Decimal numbers have digits that represent different places!";
    String explanation1cont = "Each digit represents a power of 10, from small to large";
    String explanation2 = "Decimal numbers are written in base 10. ";
    String explanation2cont = "This means that they can have digits from 0-9";
    String explanation3 = "If a digit goes above 9, then instead of adding 10 there, ";
    String explanation3cont = "1 is added to the place directly larger than it.";
    
    
    String number4 = "4";
    String number3 = "3";
    String number8 = "8";
    
    String hundredsPlace = "Hundreds Place";
    String tensPlace = "Tens Place";
    String onesPlace = "Ones Place";
    
    String baseTen0 = "1";
    String baseTen1 = "10";
    String baseTen2 = "10x10";
    
    public PreDemoPage()
    {

    	setLayout(null);
    	
    	loadImages();
    	
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
		
		timer.start();
		
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 70, 10, this);
    	
    	//strings and explanations
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 100, 100);
    	g.drawString(explanation1cont, 100, 125);
    	
    	g.drawString(explanation2, 30, 440);
    	g.drawString(explanation2cont, 30, 465);
    	
    	g.drawString(explanation3, 190, 520);
    	g.drawString(explanation3cont, 240, 545);
	    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.setColor(WelcomePage.textColor);
    	g.drawString(hundredsPlace, 100, 350);
    	g.drawString(tensPlace, 310, 350);
    	g.drawString(onesPlace, 510, 350);
	    	
    	g.fillRect(250, 180, 5, 200);
    	g.fillRect(450, 180, 5, 200);
	    	
    	g.drawString(baseTen2, 150, 380);
    	g.drawString(baseTen1, 340, 380);
    	g.drawString(baseTen0, 540, 380);
    	
    	
    	if(countAnimation == 0)
    	{
        	g.setFont(new Font("Geneva", 1, 150));
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString(number4, 100, 300);
        	g.drawString(number3, 300, 300);
        	g.drawString(number8, 500, 300);
    	}
    	
    	else if(countAnimation == 1)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, 100, 300);
	    	g.drawString(number3, 300, 300);
	    	g.drawString("9", 500, 300);
	    	
    	}
    	else if(countAnimation == 2)
    	{

	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, 100, 300);
	    	g.drawString(number3, 300, 300);
	    	g.drawString("10", 500, 300);
	    	
    	}
    	else if(countAnimation == 3)
    	{

	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, 100, 300);
	    	g.drawString(number3, 300, 300);
	    	g.drawString("10", 500, 300);
	    	
	    	//DRAW X OVER IT
	    	g.drawImage(crossOutImage, 500, 150, this);
	    	
    	}
    	else if(countAnimation >= 4)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, 100, 300);
	    	g.drawString("4", 300, 300);
	    	g.drawString("0", 500, 300);
	    	
    	}
    	
    	
    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decBasicsPath)); 
		titleImage = titleImage.getScaledInstance(650, 40, Image.SCALE_SMOOTH);
		
		
		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		

    }
    
	
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 15)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	
    

}
