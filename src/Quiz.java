
/*--------------------------------------------------------------------------------------*/
/*  Quiz.java  - This is the quiz portion of the program. A question along with a diagram
 * will be displayed and a text field will be displayed. If the user answers correctly, they
 *  can go on to the next question. Also, if they get the question wrong, the correct answer will
 *  display and the user can try it again.                                              */
/*--------------------------------------------------------------------------------------*/
/*  Author: Ginoth Kumar                                                                */
/*--------------------------------------------------------------------------------------*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Quiz extends Applet implements ActionListener, MouseListener {

	private static void createWindow() { // creates window to allow changes in layout
		JFrame f = new JFrame("Window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel textLabel = new JLabel("Hello", SwingConstants.CENTER);
		textLabel.setPreferredSize(new Dimension(1200, 680));
		f.getContentPane().add(textLabel, BorderLayout.CENTER);

		// Display window
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}

	public void read(String file, String[] words) throws IOException { // method to read info from text
																		// file
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		int count = 0;
		while ((line = reader.readLine()) != null) {
			words[count] = line;
			count++;
		}
		reader.close();
	}

	// variables
	String[] questions = new String[10]; // array that contains 10 question
	String[] answers = new String[10]; // array with the corresponding answers
	TextField ans = new TextField(3); // textbox for user to enter answer
	Button check = new Button("Check!");
	int qNum = 0;
	String correct, temp; // correct answer for each question and temporary string to hold user answer
	String userAns = null; // user entered answer

	// variables to open other classes
	public static JFrame jf;
	GetInShape gis;
	Lessons l;

	public void init() {
		setBackground(Color.cyan);
		addMouseListener(this);
		try {
			read("questions", questions);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		try {
			read("answers", answers);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		// add text field and button for user to enter questions
		add(ans);
		add(check);
		check.addActionListener(this);
	}

	public void paint(Graphics g) {
		Font textFont = new Font("Comic Sans MS", Font.BOLD, 32);
		g.setColor(Color.magenta);
		g.setFont(textFont);
		g.drawString(questions[qNum], 0, 75);
		g.setColor(Color.white);

		correct = answers[qNum];// correct answer
		if (userAns != null) {
			temp = userAns;
		}

		// change screen depending on the question
		switch (qNum) {
		// draw diagrams based on the questions
		case 0: // pythagorean question
			// triangle
			int[] x = { 350, 350, 850 };
			int[] y = { 100, 400, 400 };
			g.fillPolygon(x, y, 3);
			// labels
			g.setColor(Color.black);
			g.drawString("6", 320, 240);
			g.drawString("8", 600, 440);
			g.drawString("c", 600, 230);
			g.setColor(Color.black);
			g.drawRect(350, 350, 50, 50);
			break;

		case 1: // circumference question
			g.drawString("Note: Use alt + p to write π", 0, 150);
			// circle
			g.fillOval(450, 150, 300, 300);
			g.setColor(Color.black);
			// labels
			g.drawLine(450, 300, 600, 300);
			g.drawString("10", 525, 295);
			break;

		case 2: // triangle area question
			// triangle
			int[] xTri = { 400, 600, 800 };
			int[] yTri = { 425, 125, 425 };
			g.fillPolygon(xTri, yTri, 3);
			// labels
			g.setColor(Color.black);
			g.drawLine(600, 125, 600, 425);
			g.drawRect(600, 400, 25, 25);
			g.drawString("A = 18", 800, 150);
			g.drawString("2", 600, 460);
			break;

		case 3: // trapezoid area question
			// trapezoid
			int[] xTrap = { 400, 500, 700, 800 };
			int[] yTrap = { 350, 150, 150, 350 };
			g.fillPolygon(xTrap, yTrap, 4);
			// labels
			g.setColor(Color.black);
			g.drawString("3", 600, 130);
			g.drawString("4", 600, 380);
			g.drawLine(600, 150, 600, 350);
			g.drawRect(600, 325, 25, 25);
			g.drawString("4", 610, 250);
			break;

		case 4: // hexagon angle question
			int[] x6 = { 400, 500, 650, 750, 650, 500 };
			int[] y6 = { 300, 150, 150, 300, 450, 450 };
			g.fillPolygon(x6, y6, 6);
			break;

		case 5: // circle area question
			g.drawString("Note: Use alt + p to write π", 0, 150);
			// circle
			g.fillOval(450, 150, 300, 300);
			g.setColor(Color.black);
			// labels
			g.drawLine(450, 300, 600, 300);
			g.drawString("7", 525, 295);
			break;

		case 6: // parallelogram area question
			// parallelogram
			int[] xPar = { 400, 500, 900, 800 };
			int[] yPar = { 400, 150, 150, 400 };
			g.fillPolygon(xPar, yPar, 4);
			// labels
			g.setColor(Color.black);
			g.drawString("A = 144", 300, 200);
			g.drawLine(500, 150, 500, 400);
			g.drawString("12", 500, 275);
			break;

		case 7: // pythagorean question
			// triangle
			int[] xTri2 = { 350, 350, 850 };
			int[] yTri2 = { 100, 400, 400 };
			g.fillPolygon(xTri2, yTri2, 3);
			// labels
			g.setColor(Color.black);
			g.drawString("a", 320, 240);
			g.drawString("12", 600, 440);
			g.drawString("15", 600, 230);
			g.setColor(Color.black);
			g.drawRect(350, 350, 50, 50);
			break;

		case 8: // triangle area
			// triangle
			int[] xTri3 = { 400, 600, 800 };
			int[] yTri3 = { 425, 125, 425 };
			g.fillPolygon(xTri3, yTri3, 3);
			// labels
			g.setColor(Color.black);
			g.drawLine(600, 125, 600, 425);
			g.drawRect(600, 400, 25, 25);
			g.drawString("12", 600, 275);
			g.drawString("5", 600, 460);
			break;

		case 9: // rectangle perimeter
			g.fillRect(400, 200, 400, 200);
			g.setColor(Color.black);
			g.drawString("24", 350, 300);
			g.drawString("45", 600, 175);
			break;
		}

		ans.setBounds(550, 500, 100, 50);
		check.setBounds(650, 500, 100, 50);

		// congratulatory message if answer was right
		if (temp.contentEquals(correct)) {
			g.setColor(Color.green.darker());
			g.drawString("CORRECT!", 900, 400);
			// button to go to next question
			if (qNum != 9) {
				g.setColor(Color.magenta);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
				g.fillRect(1050, 600, 100, 50);
				g.setColor(Color.white);
				g.drawString("Next ->", 1060, 630);
			}
		} else if (!temp.contentEquals(answers[qNum - 1])) {
			g.setColor(Color.red);
			g.drawString("The correct answer was " + correct, 700, 470);
		}

		// buttons to go to main menu and quiz
		g.setColor(Color.magenta);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.fillRect(500, 600, 125, 50);
		g.fillRect(670, 600, 100, 50);
		g.setColor(Color.white);
		g.drawString("Main Menu", 510, 630);
		g.drawString("Lessons", 685, 630);

		// button to go to previous lesson
		if (qNum != 0) {
			g.setColor(Color.magenta);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			g.fillRect(20, 600, 125, 50);
			g.setColor(Color.white);
			g.drawString("<- Previous", 20, 630);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		try {
			userAns = ans.getText();
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(null, "Exception or error " + t + " has occured!", "Exception or Error", 0);
		}

		if (evt.getSource() == check) {
			repaint();
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
		if (temp.contentEquals(correct)) {
			if (qNum != 9) { // if its not the last question
				if ((e.getX() >= 1050) && (e.getX() <= 1150) && (e.getY() >= 600) && (e.getY() <= 650)) { // if next
																											// button
					// is clicked
					qNum = qNum + 1;
					userAns = null;
					repaint();
				}
			}
		}

		if (qNum != 0) { // if its not the first lesson
			if ((e.getX() >= 20) && (e.getX() <= 145) && (e.getY() >= 600) && (e.getY() <= 650)) { // if the previous
																									// button is clicked
				qNum = qNum - 1;
				userAns = null;
				repaint();
			}
		}

		if ((e.getX() >= 500) && (e.getX() <= 625) && (e.getY() >= 600) && (e.getY() <= 650)) { // if main menu button
																								// is clicked
			gis = new GetInShape();
			jf = new JFrame();
			jf.setSize(500, 500); // size of lessons page
			jf.setVisible(true);
			jf.add(gis);
		} else if ((e.getX() >= 670) && (e.getX() <= 770) && (e.getY() >= 600) && (e.getY() <= 650)) { // if lesson
																										// button is
																										// clicked
			l = new Lessons();
			jf = new JFrame();
			jf.setSize(1200, 680); // size of lessons page
			jf.setVisible(true);
			jf.add(l);
		}
	}

	public static void main(String[] args) { // create the applet window
		createWindow();
	}
}