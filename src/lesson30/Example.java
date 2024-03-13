package lesson30;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Example extends JFrame {
	private static final long serialVersionUID = 1L;

	public Example() {
		final DefaultListModel<String>	leftModel = new DefaultListModel<>(); 
		final DefaultListModel<String>	rightModel = new DefaultListModel<>();
		
		leftModel.addElement("Val1");
		leftModel.addElement("Val2");
		leftModel.addElement("Val3");
		
		final JList<String>				left = new JList<>(leftModel);
		final JList<String>				right = new JList<>(rightModel);

		final JButton					left2Right = new JButton("--->");
		final JButton					right2Left = new JButton("<---");
		final JPanel					buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.add(left2Right);
		buttonPanel.add(right2Left);
		
		getContentPane().add(new JScrollPane(left), BorderLayout.WEST);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		getContentPane().add(new JScrollPane(right), BorderLayout.EAST);
		
		left2Right.addActionListener((e)->{
			final int	index = left.getSelectedIndex();
			
			if (index >= 0) {
				rightModel.addElement(leftModel.remove(index));
			}
		});
		right2Left.addActionListener((e)->{
			final int	index = right.getSelectedIndex();
			
			if (index >= 0) {
				leftModel.addElement(rightModel.remove(index));
			}
		});
		
		setSize(640,480);
		setLocationRelativeTo(null);		
	}

	public static void main(String[] args) {
		final Example	ex = new Example();
		
		ex.setVisible(true);
	}

}
