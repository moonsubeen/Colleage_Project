package college_management.my.gui.layout.student.schedule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureHistory;
import college_management.my.gui.layout.common.LecView;

public class StduentScheduleInfoView extends LecView{
	private JTextField codeTxtField = new JTextField();
	private JTextField titleTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField yearTxtField = new JTextField();
	private JTextField semesterTxtField = new JTextField();
	private JTextField dayTxtField = new JTextField();
	private JTextField timeTxtField = new JTextField();
	private JTextField pointTxtField = new JTextField();
	private JTextField planTxtField = new JTextField();
	
	private LectureHistory data;
	
	public StduentScheduleInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("강의코드", codeTxtField, row++, false);
		genInfoPair("강의제목", titleTxtField, row++, false);
		genInfoPair("교수이름", nameTxtField, row++, false);
		genInfoPair("년도", yearTxtField, row++, false);
		genInfoPair("학기", semesterTxtField, row++, false);
		genInfoPair("요일", dayTxtField, row++, false);
		genInfoPair("강의시간", timeTxtField, row++, false);
		genInfoPair("학점", pointTxtField, row++, false);
		genInfoPair("강의계획", planTxtField, row++, false);
	}

	private void genInfoPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		txtField.setPreferredSize(new Dimension(200, 30));
		txtField.setEditable(isEditable);
		txtField.setBackground(isEditable ? Color.WHITE : Color.LIGHT_GRAY);
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}

	@Override
	public void setData(Object history) {
		data = (LectureHistory) history;
		codeTxtField.setText(data.getLecture().getCode());
		nameTxtField.setText(data.getLecture().getName());
		titleTxtField.setText(data.getLecture().getProfessor().getUser().getName());
		yearTxtField.setText(Integer.toString(data.getLecture().getYear()));
		semesterTxtField.setText(Integer.toString(data.getLecture().getSemester()));
		dayTxtField.setText(data.getLecture().getDay());
		timeTxtField.setText(data.getLecture().getTime());
		pointTxtField.setText(Integer.toString(data.getLecture().getPoint()));
		planTxtField.setText(data.getLecture().getLecturePlan());
	}

	@Override
	public Object getData() {
//		data.setYear(Integer.parseInt(yearTxtField.getText()));
//		data.setSemester(Integer.parseInt(semesterTxtField.getText()));
//		data.setDay(dayTxtField.getText());
//		data.setTime(timeTxtField.getText());
//		data.setCode(codeTxtField.getText());
//		data.setName(nameTxtField.getText());
//		data.setPoint(Integer.parseInt(pointTxtField.getText()));
//		data.setLecturePlan(planTxtField.getText());
		return data;
	}

}
