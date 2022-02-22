/*--------------------------------------------------------------------------------------*/
/*  GetInShape.java  - Get In Shape teaches students geometry. It provides lessons on concepts*/
/*  such as perimeter and area for example. They can also quiz themselves on their learning
 *  using the quiz in the game*/
/*--------------------------------------------------------------------------------------*/
/*  Author: Ginoth Kumar                                                                */
/*--------------------------------------------------------------------------------------*/
/*  Input: User can click a lessons button, a quiz button or an exit button             */
/*  Output: If they click lessons, several lessons pages will show up. If they click quiz
 *  a quiz page can show up where they answer geometry questions. If they click exit, the
 *  program will shut down.                                                             */
/*--------------------------------------------------------------------------------------*/
import java.awt.*;
import java.applet.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GetInShape extends Applet implements MouseListener {
	// variables for menu options
	int userChoice;
	Font textFont = new Font("Comic Sans MS", Font.BOLD, 30);
	Font title = new Font("Comic Sans MS", Font.BOLD, 60);
	
	//variables to open other classes
	public static JFrame jf;
	Lessons l;
	Quiz q;

	public void init() { //initialize the applet
		setBackground(Color.cyan);
		userChoice = 0;
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		// display title
		g.setFont(textFont);
		g.setColor(Color.magenta);
		g.drawString("Welcome to", 170, 100);
		g.setFont(title);
		g.drawString("GET IN SHAPE", 20, 150);

		// draw buttons
		g.setFont(textFont);
		// draw boxes for buttons
		g.fillRect(100, 250, 100, 50); // learn
		g.fillRect(300, 250, 100, 50); // quiz
		g.fillRect(380, 400, 100, 50); // exit
		// draw labels for buttons
		g.setColor(Color.white);
		g.drawString("Learn", 110, 285);
		g.drawString("Quiz", 315, 285);
		g.drawString("Exit", 400, 435);

		switch (userChoice) {
		case 1: //if they choose lesson
			//open lesssons
			l = new Lessons();
			jf = new JFrame();
			jf.setSize(1200, 680); // size of lessons page
			jf.setVisible(true);
			jf.add(l);
			break;
			
		case 2: //if they choose quiz
			//open quiz
			q = new Quiz();
			jf = new JFrame();
			jf.setSize(1200, 680); // size of quiz page
			jf.setVisible(true);
			jf.add(q);
			break;
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		// if user selects learn
		if (((e.getX() >= 100) && (e.getX() <= 200)) && ((e.getY() >= 250) && (e.getY() <= 300))) {
			userChoice = 1;
		}
		// if user selects quiz
		else if (((e.getX() >= 300) && (e.getX() <= 400)) && ((e.getY() >= 250) && (e.getY() <= 300))) {
			userChoice = 2;
		}
		// if user selects exit
		else if (((e.getX() >= 380) && (e.getX() <= 480)) && ((e.getY() >= 400) && (e.getY() <= 450))) {
			System.exit(0);
		}
		repaint();
	}
}