package college_management.my.gui.layout.admin.lecture;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;

import college_management.my.gui.MainGUI;
import college_management.my.gui.layout.common.LecView;

public class AdminBaseLectureDlgView extends LecView{
	private AdminLectureRegDlgView lecture = new AdminLectureRegDlgView();
	private JComponent lectureview = lecture;
	
	public AdminBaseLectureDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addView("lecture", lectureview, row);
	}

	private void addView(String id, JComponent view, int row) {
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = row;
		add(view, c);
	}

	@Override
	public void setData(Object model) {
	}

	@Override
	public Object getData() {
		return null;
	}
	
	public AdminBaseLectureDlgView getLecture() {
		return (AdminBaseLectureDlgView) lectureview;
	}
}
