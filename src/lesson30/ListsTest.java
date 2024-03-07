package lesson30;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListsTest extends JFrame {
	public ListsTest() throws IOException {
		getContentPane().setLayout(new GridLayout(3,1));
		
//		String[] values = new String[] {"vassya", "petya", "anna", "vassya", "petya", "anna", "vassya", "petya", "anna", "vassya", "petya", "anna"};
		Person[] values = new Person[] {
					new Person("ivanov","ivan","ivanovich",21),
					new Person("petrov","petr","petrovich",25)
				};
		
//		final DefaultListModel dlm = new DefaultListModel();
		
//		final ListModel<String>	lm = new ListModel() {
//			@Override
//			public int getSize() {
//				return values.length;
//			}
//
//			@Override
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//
//			@Override public void addListDataListener(ListDataListener l) {}
//			@Override public void removeListDataListener(ListDataListener l) {}
//		};
		
		JList<Person>	list = new JList<>(values);
//		
//		Timer t = new Timer(true);
//		TimerTask tt = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				dlm.addElement("add "+System.currentTimeMillis());
//			}};
//		
//		t.schedule(tt, 2000, 1000);
		
		getContentPane().add(new JScrollPane(list));
		list.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int[] x = list.getSelectedIndices();
				System.err.println("Sel: "+Arrays.toString(x));
				for(int index : x) {
					System.err.println("Sel["+index+"]="+values[index]);
				}
			}
		});
		
		Icon	icon = new ImageIcon(ImageIO.read(new File("c:/temp/zzz.png")));
		
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer() {
			@Override 
			public Component getListCellRendererComponent(
				       JList<?> list,           // the list
				       Object value,            // value to display
				       int index,               // cell index
				       boolean isSelected,      // is the cell selected
				       boolean cellHasFocus)    // does the cell have focus
			{final JLabel	label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
				label.setText(((Person)value).family+' '+((Person)value).name);
			
				label.setIcon(icon);
				label.setForeground(Color.RED);
				return label;
		    }
		};
		
		list.setCellRenderer(dlcr);
		
		
//		JComboBox<String>	cbox = new JComboBox<>(values);
//		
//		getContentPane().add(cbox);
		
		setSize(640,480);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final ListsTest	lt = new ListsTest();
		
		lt.setVisible(true);
	}

}
