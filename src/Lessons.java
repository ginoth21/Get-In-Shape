/*--------------------------------------------------------------------------------------*/
/*  Lessons.java  - This is the lesson portion of the program. Information along with a diagram
 * will be displayed. The user has the option to go to a previous lesson, the next lesson,
 * or directly to any lesson they want.                                                 */
/*--------------------------------------------------------------------------------------*/
/*  Author: Ginoth Kumar                                                                */
/*--------------------------------------------------------------------------------------*/
import java.io.*;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lessons extends Applet implements ActionListener, MouseListener {
	public void title(Graphics g, String title) { // method to make titles for each lesson easily
		// set text style for titles of each lesson
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString(title, 450, 100);
	}

	public void information(Graphics g, String file) throws IOException // method to read lesson information from text
																		// file
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String sentence;
		int y = 400;
		while ((sentence = reader.readLine()) != null) { //set sentence equal to the line in the text file
			//draw the string below the last one
			g.drawString(sentence, 0, y);
			y = y + 40;
		}
		reader.close();
	}

	// buttons for user to select what to learn
	Button pTheorem = new Button("Pythagorean Theorem");
	Button perimeter = new Button("Perimeter");
	Button angles = new Button("Angles");
	Button areaRect = new Button("Area of Rectangles");
	Button areaPar = new Button("Area of Parallelograms and Trapezoids");
	Button areaTri = new Button("Area of Triangles");
	Button areaCirc = new Button("Area of Circles");
	int lessonChoice; // number that will track what lesson user wants to do
	Font titleFont = new Font("Comic Sans MS", Font.BOLD, 30);
	Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
	
	//variables to open other classes
	public static JFrame jf;
	GetInShape gis;
	Quiz q;
	

	public void init() {  //initialize applet
		setBackground(Color.cyan);  //set background colour
		//add buttons and mouse listener to applet
		add(pTheorem);
		add(perimeter);
		add(angles);
		add(areaRect);
		add(areaPar);
		add(areaTri);
		add(areaCirc);
		addMouseListener(this);
		lessonChoice = 1;
	}

	public void paint(Graphics g) {
		// display buttons
		pTheorem.addActionListener(this);
		perimeter.addActionListener(this);
		angles.addActionListener(this);
		areaRect.addActionListener(this);
		areaPar.addActionListener(this);
		areaTri.addActionListener(this);
		areaCirc.addActionListener(this);

		// button to go to next lesson
		g.setColor(Color.magenta);
		g.setFont(textFont);
		if (lessonChoice != 7) {
			g.fillRect(1050, 600, 100, 50);
			g.setColor(Color.white);
			g.drawString("Next ->", 1060, 630);
		}
		// button to go to previous lesson
		g.setColor(Color.magenta);
		if (lessonChoice != 1) {
			g.fillRect(20, 600, 125, 50);
			g.setColor(Color.white);
			g.drawString("<- Previous", 20, 630);
		}
		// buttons to go to main menu and quiz
		g.setColor(Color.magenta);
		g.fillRect(500, 600, 125, 50);
		g.fillRect(670, 600, 100, 50);
		g.setColor(Color.white);
		g.drawString("Main Menu", 510, 630);
		g.drawString("Quiz", 695, 630);

		switch (lessonChoice) {
		case 1: // lesson for pythagorean theorem
			title(g, "Pythagorean Theorem");
			int[] x = { 500, 500, 800 };
			int[] y = { 150, 350, 350 };
			g.fillPolygon(x, y, 3);
			g.setColor(Color.magenta);
			g.setFont(textFont);
			try {
				information(g, "pTheorem");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			// labels
			g.setColor(Color.white);
			g.drawString("a", 450, 250);
			g.drawString("b", 650, 370);
			g.drawString("c", 650, 225);

			g.setColor(Color.black);
			g.drawRect(500, 300, 50, 50);
			break;

		case 2: // lesson for perimeter
			title(g, "Perimeter");
			// draw shapes that will help explain perimeter
			g.fillRect(100, 150, 300, 200);
			g.fillOval(600, 150, 200, 200);

			// labels for rectangle
			g.setFont(textFont);
			g.drawString("L", 250, 140);
			g.drawString("W", 410, 250);

			// labels for circle
			g.setColor(Color.black);
			g.drawLine(600, 250, 800, 250);
			g.drawString("Diameter", 660, 230);
			g.setColor(Color.red);
			g.drawLine(600, 250, 700, 250);
			g.drawString("Radius", 610, 270);

			// outline the perimeter of the shapes
			g.setColor(Color.magenta);
			g.drawRect(100, 150, 300, 200);
			g.drawOval(600, 150, 200, 200);

			// perimeter information
			try {
				information(g, "perimInfo");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			break;

		case 3: // lesson for angles
			title(g, "Angles");
			// draw lines to demonstrate common angles
			g.drawLine(100, 200, 300, 200);
			int[] xLine = { 350, 350, 450 };
			int[] yLine = { 150, 250, 250 };
			g.drawPolyline(xLine, yLine, 3);
			// draw triangle
			int[] xTri = { 600, 700, 800 };
			int[] yTri = { 300, 100, 300 };
			g.fillPolygon(xTri, yTri, 3);
			// draw angles on diagrams
			g.setColor(Color.black);
			g.drawArc(175, 185, 25, 25, 0, 180);
			g.drawRect(350, 225, 25, 25);
			// angles on triangle
			g.drawArc(575, 275, 50, 50, 0, 60);
			g.drawArc(780, 270, 50, 50, 135, 60);
			g.drawArc(675, 85, 50, 50, 240, 60);
			g.setFont(textFont);
			// captions for diagrams
			g.drawString("180°", 175, 165);
			g.drawString("90°", 380, 220);
			g.drawString("The angles of a triangle add up to 180°", 750, 200);
			g.setColor(Color.magenta);
			try {
				information(g, "angleInfo");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			break;

		case 4: // lesson for area of rectangle
			title(g, "Area of a Rectangle");
			g.drawRect(450, 150, 300, 150);
			g.setColor(Color.magenta);
			g.fillRect(450, 150, 300, 150);
			g.setFont(textFont);
			try {
				information(g, "areaRectangle");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			// labels
			g.setColor(Color.white);
			g.drawString("L", 600, 145);
			g.drawString("W", 425, 225);
			break;

		case 5: // lesson for area of parallelogram
			title(g, "Area of Parallelograms and Trapezoids");
			// coordinates for parallelogram
			int[] x5 = { 100, 200, 500, 400 };
			int[] y5 = { 350, 150, 150, 350 };
			// coordinates for trapezoid
			int[] xTrap = { 700, 800, 900, 1000 };
			int[] yTrap = { 350, 150, 150, 350 };
			// draw parallelogram and trapezoid
			g.drawPolygon(x5, y5, 4);
			g.drawPolygon(xTrap, yTrap, 4);
			// highlight areas of both shapes
			g.setColor(Color.magenta);
			g.fillPolygon(x5, y5, 4);
			g.fillPolygon(xTrap, yTrap, 4);
			// draw perpendicular lines for each shape
			g.setColor(Color.black);
			g.drawLine(200, 150, 200, 350);
			g.drawRect(200, 325, 25, 25);
			g.drawLine(850, 150, 850, 350);
			g.drawRect(850, 325, 25, 25);
			g.setFont(textFont);
			g.setColor(Color.magenta);
			try {
				information(g, "areaPara");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			// add labels
			g.setColor(Color.white);
			g.drawString("B", 350, 145);
			g.drawString("H", 205, 250);
			g.drawString("a", 850, 145);
			g.drawString("b", 850, 370);
			g.drawString("H", 855, 250);
			break;

		case 6: // lesson for area of triangle
			title(g, "Area of a Triangle");
			// coordinates of points (named with number of case)
			int[] x6 = { 500, 600, 700 };
			int[] y6 = { 325, 125, 325 };
			g.drawPolygon(x6, y6, 3);
			g.setColor(Color.magenta);
			g.fillPolygon(x6, y6, 3);
			g.setFont(textFont);
			try {
				information(g, "areaTriangle");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			// labels
			g.setColor(Color.black);
			g.drawLine(600, 125, 600, 325);
			g.drawRect(600, 300, 25, 25);
			g.setColor(Color.white);
			g.drawString("H", 605, 225);
			g.drawString("B", 600, 350);
			break;

		case 7: // lesson for area of circle
			title(g, "Area of a Circle");
			g.setFont(textFont);
			g.setColor(Color.magenta);
			g.fillOval(450, 120, 250, 250);
			g.setColor(Color.black);
			g.drawLine(450, 245, 575, 245);
			g.setColor(Color.white);
			g.drawOval(450, 120, 250, 250);
			g.drawString("r", 500, 235);
			g.setColor(Color.magenta);
			try {
				information(g, "areaCircle");
			} catch (Throwable t) {
				t.printStackTrace();
			}
			break;
		}
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == pTheorem) // if they choose pythagorean theorem
		{
			lessonChoice = 1;
		} else if (evt.getSource() == perimeter) // if they choose perimeter
		{
			lessonChoice = 2;
		} else if (evt.getSource() == angles) // if they choose angles
		{
			lessonChoice = 3;
		} else if (evt.getSource() == areaRect) // if they choose rectangle area
		{
			lessonChoice = 4;
		} else if (evt.getSource() == areaPar) // if they choose parallelogram area
		{
			lessonChoice = 5;
		} else if (evt.getSource() == areaTri) // if they choose triangle area
		{
			lessonChoice = 6;
		} else if (evt.getSource() == areaCirc) // if they choose circle area
		{
			lessonChoice = 7;
		}
		repaint();
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
		if (lessonChoice != 7) { // if its not the last lesson
			if ((e.getX() >= 1050) && (e.getX() <= 1150) && (e.getY() >= 600) && (e.getY() <= 650)) { // if next button
																										// is clicked
				lessonChoice = lessonChoice + 1;
				repaint();
			}
		}

		if (lessonChoice != 1) { // if its not the first lesson
			if ((e.getX() >= 20) && (e.getX() <= 145) && (e.getY() >= 600) && (e.getY() <= 650)) { // if the previous
																									// button is clicked
				lessonChoice = lessonChoice - 1;
				repaint();
			}
		}
		
		if ((e.getX() >= 500) && (e.getX() <= 625) && (e.getY() >= 600) && (e.getY() <= 650)) { //open get in shape class
			gis = new GetInShape();
			jf = new JFrame();
			jf.setSize(500, 500); // size of lessons page
			jf.setVisible(true);
			jf.add(gis);
		}
		
		if ((e.getX() >= 670) && (e.getX() <= 770) && (e.getY() >= 600) && (e.getY() <= 650)) { //open quiz class
			q = new Quiz();
			jf = new JFrame();
			jf.setSize(1200, 680); // size of lessons page
			jf.setVisible(true);
			jf.add(q);
		}
	}
}
