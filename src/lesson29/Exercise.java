package lesson29;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Exercise extends JFrame {
	public Exercise() throws IOException {
		final String	caption = "Hello world";
		
		getContentPane().setLayout(new GridLayout(2, 1));
		final JLabel	label = new JLabel("");
		
		getContentPane().add(label);

		JSlider		slider = new JSlider(0, caption.length()-1, 0);
		
		getContentPane().add(slider);
		
		slider.addChangeListener((e)->{
			label.setText(buildString(slider.getValue(), caption));
		});

		getContentPane().add(slider);
		
		label.setText(buildString(slider.getValue(), caption));

		
		setSize(1024, 768);
		setLocationRelativeTo(null);
	}
	
	private String buildString(final int redIndex, final String caption) {
		final StringBuilder	sb = new StringBuilder();
		
		sb.append("<html><font size=72>");
		for(int index = 0; index < caption.length(); index++) {
			if (index == redIndex) {
				sb.append("<font color=red>").append(caption.charAt(index)).append("</font>");
			}
			else {
				sb.append(caption.charAt(index));
			}
		}
		return sb.append("</font></html>").toString();
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Exercise ct = new Exercise();
		
		ct.setVisible(true);
	}

}
