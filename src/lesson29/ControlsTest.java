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

public class ControlsTest extends JFrame {
	public ControlsTest() throws IOException {
		getContentPane().setLayout(new GridLayout(10, 1));
		final JLabel	label = new JLabel("dfkjsdhkfjhsdkjh");
		
		getContentPane().add(label);
		label.setOpaque(true);
//		label.setVisible(true);
//		getContentPane().setVisible(true);
//		label.setEnabled(true);
//		getContentPane().setEnabled(false);
		label.setText("<html><h1>123456</h1></html>");
		label.setToolTipText("<html>ghjjj <font color=red>duihsdmnsdfkljh</font> skjlkjsdgk</html>");
		label.setName("sdsdsdsdsd");
//		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
//		label.setBorder(new LineBorder(Color.RED, 3));
		label.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GREEN, 3), "title"));
		
		Icon	icon = new ImageIcon(ImageIO.read(new File("c:/temp/zzz.png")));
			
		label.setIcon(icon);
		
		JCheckBox	check = new JCheckBox("<html>slkdfjkljs<br>dlkfjslkdfj</html>");
		
		check.setSelected(false);
		check.addActionListener((e)->{
			System.err.println("Check state = "+check.isSelected());
		});
		//check.setIcon(icon);
		
		getContentPane().add(check);
		
		ButtonGroup		group = new ButtonGroup();
		JRadioButton	radio1 = new JRadioButton("Alt 1");
		JRadioButton	radio2 = new JRadioButton("Alt 2");
		
		group.add(radio1);
		group.add(radio2);
//		group.add(check);
		
		getContentPane().add(radio1);
		getContentPane().add(radio2);
		
		JButton		btn = new JButton("dflkjlskdjf", icon);
		
		getContentPane().add(btn);

		
		JToggleButton	toggle = new JToggleButton("111111111", icon);
		
		getContentPane().add(toggle);
		

		JSlider		slider = new JSlider(0, 100, 50);
		
		getContentPane().add(slider);
		
		slider.addChangeListener((e)->{
			System.err.println("Value="+slider.getValue());
		});

		getContentPane().add(slider);

		
		JScrollBar	bar = new JScrollBar(JScrollBar.HORIZONTAL, 50, 10, 0, 100);

		getContentPane().add(bar);

		JProgressBar	progress = new JProgressBar(0, 100);
		
		getContentPane().add(progress);
		progress.setValue(50);
		
		progress.setStringPainted(true);

		slider.addChangeListener((e)->{
			System.err.println("Value="+slider.getValue());
			progress.setValue(slider.getValue());
			progress.setString("value="+slider.getValue());		
		});
		
		getContentPane().add(new JLabel("THE END"));
		
		setSize(1024, 768);
		setLocationRelativeTo(null);
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ControlsTest ct = new ControlsTest();
		
		ct.setVisible(true);
	}

}
