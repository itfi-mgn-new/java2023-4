package lesson32;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StdDlgTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JOptionPane	pane;
//		JOptionPane.showMessageDialog(null, "Hello world");
//		JOptionPane.showMessageDialog(null, new JLabel("<html><font size=32><b>Hello</b> <i>world</i></font></html>"));
	
		JPanel	panel = new JPanel(new BorderLayout());
		JLabel  caption = new JLabel("I'm HUNGRY!");
		JRadioButton meat = new JRadioButton("Give me MEAT!!!");
		JRadioButton fish = new JRadioButton("Give me FISH!!!");
		JRadioButton drink = new JRadioButton("Give me DRINK!!!");
		ButtonGroup bg = new ButtonGroup();
		bg.add(meat);
		bg.add(fish);
		bg.add(drink);
		JPanel center = new JPanel(new GridLayout(3,1));
		
		center.add(meat);
		center.add(fish);
		center.add(drink);
		
		panel.add(caption, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		
		int rc = JOptionPane.showConfirmDialog(null, panel, "Title djksdhjkh", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		
		if (rc == JOptionPane.YES_OPTION) {
			System.err.println("YES pressed");
		}
		else if (rc == JOptionPane.NO_OPTION) {
			System.err.println("NO pressed");
		}
		else if (rc == JOptionPane.CANCEL_OPTION) {
			System.err.println("CANCEL pressed");
		}
		else {
			System.err.println("none pressed");
		}
	
		
	}

}
