package lesson32;

import javax.swing.JFileChooser;

public class FIleChooserTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFileChooser	fc = new JFileChooser();
		
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.err.println("Selcted+ "+fc.getSelectedFile());
		}
	}

}
