package lesson30;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TableTest extends JFrame {
	public TableTest() {
		int[][]	values = new int[][] {new int[] {1,2,3}, new int[] {4,5,6}};
		
		DefaultTableModel	tm = new DefaultTableModel() {

			@Override
			public int getRowCount() {
				return 2;
			}

			@Override
			public int getColumnCount() {
				return 4;
			}

			@Override
			public String getColumnName(int columnIndex) {
				switch (columnIndex) {
					case 0 : return "col 1";
					case 1 : return "col 2";
					case 2 : return "col 3";
					case 3 : return "col 4";
				}
				return null;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 0 : case 1 : case 2 : 
					return Integer.class;
				case 3 : 
					return Boolean.class;
				}
				return null;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnIndex < 3;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				if (columnIndex >= 3) {
					return rowIndex % 2 == 0;
				}
				else {
					return values[rowIndex][columnIndex];
				}
			}

			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				values[rowIndex][columnIndex] = (Integer)aValue;
			}
		};
		
		
		JTable	table = new JTable(
				tm
//				new Object[][] {
//					new Object[] {1,2,3},
//					new Object[] {4,5,6}
//				},
//				new Object[] {"col 1", "col 2", "col 3"}
//				
				);
		
		TableCellRenderer tcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
				JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
				label.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY);
				label.setHorizontalAlignment(JLabel.CENTER);
				
				
				return label;
			}
		};
		
		table.setDefaultRenderer(Integer.class, tcr);
		
		
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		
		setSize(640,480);
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableTest	tt = new TableTest();
		
		tt.setVisible(true);
		
	}

}
