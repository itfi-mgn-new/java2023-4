package lesson31;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;

public class JTreeTest extends JFrame {
	public JTreeTest() {
//		DefaultMutableTreeNode	child1 = new DefaultMutableTreeNode("C 1");
//		DefaultMutableTreeNode	child2 = new DefaultMutableTreeNode("C 2");
//		DefaultMutableTreeNode	child3 = new DefaultMutableTreeNode("C 3");
//		DefaultMutableTreeNode	root = new DefaultMutableTreeNode("ROOT");
//		
//		root.add(child1);
//		root.add(child2);
//		root.add(child3);
		
		TreeModel				model = new DefaultTreeModel(buildDirectoryContent(new File("c:/sqldeveloper")));
		JTree					tree = new JTree(model) {
									@Override
									public String getToolTipText(final MouseEvent e) {
										return super.getToolTipText(e)+", X="+e.getX()+", Y="+e.getY();
									}
								};
		tree.setToolTipText("");
		
		final TreeCellRenderer	tcr = new DefaultTreeCellRenderer() {
									@Override
									public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
										final JLabel	label = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
										
										label.setForeground(Color.RED);
										return label;
									}
								};
		tree.setCellRenderer(tcr);
		
		getContentPane().add(new JScrollPane(tree));
		
		tree.addTreeExpansionListener(new TreeExpansionListener() {
			@Override
			public void treeExpanded(TreeExpansionEvent event) {
				System.err.println("EXpand");
			}

			@Override
			public void treeCollapsed(TreeExpansionEvent event) {
				System.err.println("Collapse");
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Change: "+e);
			}
		});
		
		setSize(640,480);
		setLocationRelativeTo(null);		
	}

	
	
	private DefaultMutableTreeNode buildDirectoryContent(final File dir) {
		final DefaultMutableTreeNode	item = new DefaultMutableTreeNode(dir);
		
		final File[]  content = dir.listFiles();
		
		if (content != null) {
			for (File child : content) {
				item.add(buildDirectoryContent(child));
			}
		}
		return item;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTreeTest	tt = new JTreeTest();
		
		tt.setVisible(true);
	}

}
