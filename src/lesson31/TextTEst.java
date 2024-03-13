package lesson31;

import java.awt.Color;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class TextTEst extends JFrame {
	public TextTEst() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		final JTextField	tf = new JTextField("text field");
		getContentPane().add(tf);
	
		tf.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				if (tf.getText().length() > 3) {
					tf.setForeground(Color.BLACK);
					return true;
				}
				else {
					tf.setForeground(Color.RED);
					return false;
				}
			}
		});
		
		
		
		tf.addActionListener((e)->{System.err.println("Action");});
		
		final JPasswordField	pf = new JPasswordField("sss");
		
		getContentPane().add(pf);
		
		final JFormattedTextField 	ftf = new JFormattedTextField();

		getContentPane().add(ftf);
		
		ftf.setValue(new Date(System.currentTimeMillis()));
		
		final JTextArea			area = new JTextArea("sdfjklsdjfkljslkdfjlk\nfyiueriuyeiuyiu\n");
	
		getContentPane().add(new JScrollPane(area));
		
//		area.setRows(20);
	
		final JEditorPane		pane = new JEditorPane("text/html","<h1><img href=\"file://./temp/zzz.png\">???</img><a href=\"sdsd\">hello</a> world</h1>");
		
		getContentPane().add(new JScrollPane(pane));
		pane.setEditable(false);
		
		pane.addHyperlinkListener(new HyperlinkListener() {

			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				System.err.println("E="+e);
			}
		});
		
		setSize(640,480);
		setLocationRelativeTo(null);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Set cross-platform Java L&F (also called "Metal")
		        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		    	e.printStackTrace();
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		    	e.printStackTrace();
		       // handle exception
		    }
		    catch (InstantiationException e) {
		    	e.printStackTrace();
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		    	e.printStackTrace();
		       // handle exception
		    }
		
		
		TextTEst tt = new TextTEst();
		
		tt.setVisible(true);
	}

}
