package lesson28;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameTest extends JFrame {
	public JFrameTest() {
		setTitle("Application window !!!!!");
		setSize(400,200);
		//setLocation(200,600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JFrameTest.this.dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		addContainerListener(new ContainerListener() {

			@Override
			public void componentAdded(ContainerEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Add component "+e);
			}

			@Override
			public void componentRemoved(ContainerEvent e) {
				// TODO Auto-generated method stub
				
			}
		});		
		
		
//		getContentPane().setLayout(new BorderLayout());
		final JLabel label = new JLabel("ARARARARARARARA");
		getContentPane().add(label, BorderLayout.SOUTH);
		final JLabel label1 = new JLabel(">>>>>");
		getContentPane().add(label1, BorderLayout.NORTH);
		final JLabel label2 = new JLabel("<<<<<");
		getContentPane().add(label2, BorderLayout.WEST);
		final JLabel label3 = new JLabel("dkjhfjkdh");
		getContentPane().add(label3, BorderLayout.EAST);
		
		label3.setPreferredSize(new Dimension(200,200));
		
		final JButton 		button = new JButton("Press me");
		
		button.addActionListener((e)->{
			System.err.println("Button pressed");
		});
		
		addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.err.println("REsize: "+e);
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		
		
		final JCheckBox 	box = new JCheckBox("Click here");
		final JTextArea		text = new JTextArea("Click here");
		
		final JScrollPane	scroll = new JScrollPane(text);
		
		final JTabbedPane	tabs = new JTabbedPane();
		
		tabs.addTab("box", box);
		tabs.addTab("text string", scroll);
		
		
		final JSplitPane	pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, button, tabs);

		
		getContentPane().add(pane, BorderLayout.CENTER);
	
		button.setPreferredSize(new Dimension(100, 100));
		
//		button.setSize(100,100);
		
//		label.setSize(100,100);
//		label.setLocation(50,50);
//		label.setVisible(true);
		
		JMenuItem	item1 = new JMenuItem("Item 1");
		JMenuItem	item2 = new JMenuItem("Item 2");
		JMenuItem	item3 = new JMenuItem("Item 3");
		
		item1.addActionListener((e)->{
			System.err.println("Item1 selected");
		});
		item2.addActionListener((e)->{
			System.err.println("Item2 selected");
		});
		item3.addActionListener((e)->{
			System.err.println("Item3 selected");
		});
		
		
		JMenu		submenu = new JMenu("submenu");
		
		submenu.add(item1);
		submenu.add(item2);
		
		JMenuBar	bar = new JMenuBar();
		bar.add(submenu);
		bar.add(item3);
		
		setJMenuBar(bar);
		
		System.err.println("Width="+dim.width);
		System.err.println("Height="+dim.height);
		setLocationRelativeTo(null);
	
	}
	



	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrameTest	test = new JFrameTest();
		
		test.setVisible(true);
	
	}

}
