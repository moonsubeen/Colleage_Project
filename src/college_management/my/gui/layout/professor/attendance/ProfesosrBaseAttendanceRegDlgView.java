package college_management.my.gui.layout.professor.attendance;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;

import college_management.my.gui.layout.common.LecView;

public class ProfesosrBaseAttendanceRegDlgView extends LecView{
	private ProfesosrBaseAttendanceRegDlgView attendance = new ProfesosrBaseAttendanceRegDlgView();
	private JComponent attendanceview = attendance;
	
	public ProfesosrBaseAttendanceRegDlgView() {
		super();
		
		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addView("attendance", attendanceview, row);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
