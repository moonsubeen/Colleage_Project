package college_management.my.gui.layout.student.schedule;

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
public class StudentScheduleLayout extends JPanel{
	private LayoutManager layout;

	private JScrollPane scrollPane;
	private LecTableView list;
	private LecView lectureInfo;
	private JButton loadBtn;
	private JButton searchBtn;
	private JTextField searchTxtField = new JTextField();
	private JLabel label = new JLabel("강의 코드 입력");
	
	public StudentScheduleLayout() {
		initLayout();
	}
	
	public void initLayout() {
		lectureInfo = new StduentScheduleInfoView();
		lectureInfo.setPreferredSize(new Dimension(400, 400));
		
		// 사용자 리스트
		list = new LecTableView(lectureInfo);
		list.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(list.getModel());
		list.setRowSorter(sorter);
						
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		loadBtn = (new JButton("새로고침"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
						
		label.setPreferredSize(new Dimension(100, 30));
						
		searchBtn = (new JButton("검색"));
		searchBtn.setPreferredSize(new Dimension(60, 30));
						
		searchTxtField.setPreferredSize(new Dimension(200, 30));
				
		removeAll();
		setlayout();
						
	}
	
	public void setlayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);

		c.gridx = 1;
		c.gridy = 0;
		add(lectureInfo, c);
		
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
		c.gridy = 1;
		add(loadBtn, c);
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

	public LecView getLectureInfo() {
		return lectureInfo;
	}

	public JButton getLoadBtn() {
		return loadBtn;
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
