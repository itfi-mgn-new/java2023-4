package lesson33;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Example extends JFrame {
	private final JProgressBar bar = new JProgressBar();
	private final JButton startButton = new JButton("Start");
	private File sourceDir = new File("./");
	private File sourceFile = null;
	private File targetDir = null;
	
	public Example() {
		final JButton fromButton = new JButton("From");
		final JButton toButton = new JButton("To");
		
		fromButton.addActionListener((e)->{
			final JFileChooser fc = new JFileChooser(sourceDir);
			
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setMultiSelectionEnabled(false);
			if (fc.showOpenDialog(Example.this) == JFileChooser.APPROVE_OPTION) {
				sourceFile = fc.getSelectedFile();
				sourceDir = sourceFile.getParentFile();
			}
			else {
				sourceFile = null;
			}
			refreshState();
		});
		toButton.addActionListener((e)->{
			final JFileChooser fc = new JFileChooser(targetDir == null ? sourceDir : targetDir);
			
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.setMultiSelectionEnabled(false);
			if (fc.showOpenDialog(Example.this) == JFileChooser.APPROVE_OPTION) {
				targetDir = fc.getSelectedFile();
			}
			else {
				targetDir = null;
			}
			refreshState();
		});
		startButton.addActionListener((e)->{
			startCopy(sourceFile, targetDir, bar);
			sourceFile = null;
			refreshState();
		});
		
		getContentPane().setLayout(new GridLayout(1,4));
		getContentPane().add(fromButton);
		getContentPane().add(bar);
		getContentPane().add(toButton);
		getContentPane().add(startButton);
	
		setSize(400, 100);
		setLocationRelativeTo(null);
		refreshState();
	}

	private static void startCopy(final File sourceFile, final File targetDir, final JProgressBar bar) {
		// TODO Auto-generated method stub
		bar.setStringPainted(true);

		try(final InputStream is = new FileInputStream(sourceFile);
			final OutputStream os = new FileOutputStream(new File(targetDir, sourceFile.getName()))) {
			final byte[] buffer = new byte[Math.max(1, (int)(sourceFile.length()/100))];
			int copied = 0;
			int len;
			
			bar.setMinimum(0);
			bar.setMaximum((int) sourceFile.length());
		
			bar.setString("Copying...");
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
				copied += len;
				bar.setValue(copied);
			}
			os.flush();
			bar.setString("Completed");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	

	private void refreshState() {
		if (sourceFile != null && targetDir != null) {
			startButton.setEnabled(true);
			startButton.setToolTipText("Copy "+sourceFile.getAbsolutePath()+" to "+targetDir.getAbsolutePath());
		}
		else {
			startButton.setEnabled(false);
			startButton.setToolTipText("To start copy, select source file ('From' button) and target directory ('To' button)");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example ex = new Example();
		
		ex.setVisible(true);
	}

}
