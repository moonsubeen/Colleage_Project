package college_management.my.gui.layout.professor.history;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class ProfessorHistoryLayout extends JPanel {
	private LayoutManager layout;
	private JScrollPane scrollPane;
	private LecTableView list;
	private LecView historyInfo;
	
	private JButton loadBtn;
	private JButton updateBtn;
	private JButton searchBtn;
	
	private JTextField searchTxtField = new JTextField();
	private JLabel label = new JLabel("강의 코드 입력");

	public ProfessorHistoryLayout() {
		initLayout();
	}
	
	public void initLayout() {
		historyInfo = new ProfessorHistoryInfoView();
		historyInfo.setPreferredSize(new Dimension(400, 400));
		
		list = new LecTableView(historyInfo);
		list.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(list.getModel());
		list.setRowSorter(sorter);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		
		loadBtn = (new JButton("새로고침"));
		loadBtn.setPreferredSize(new Dimension(200, 30));

		updateBtn = (new JButton("점수 변경하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));
		
		searchBtn = (new JButton("검색"));
		searchBtn.setPreferredSize(new Dimension(60, 30));
		
		searchTxtField.setPreferredSize(new Dimension(200, 30));
		label.setPreferredSize(new Dimension(100, 30));
		
		removeAll();
		setLayout();
	}
	
	private void setLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);

		c.gridx = 1;
		c.gridy = 0;
		add(historyInfo, c);
				
		c.gridx = 0;
		c.gridy = 3;
		add(searchBtn, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(label, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(searchBtn, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(searchTxtField, c);
		
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);

	}

	public LayoutManager getLayout() {
		return layout;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public LecTableView getList() {
		return list;
	}

	public LecView getHistoryInfo() {
		return historyInfo;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public JTextField getSearchTxtField() {
		return searchTxtField;
	}
	
	public JLabel getLabel() {
		return label;
	}
}
