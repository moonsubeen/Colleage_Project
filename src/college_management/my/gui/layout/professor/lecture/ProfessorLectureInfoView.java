package college_management.my.gui.layout.professor.lecture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class ProfessorLectureInfoView extends LecView{
	private JTextField yearTxtField = new JTextField();
	private JTextField semesterTxtField = new JTextField();
	private JTextField dayTxtField = new JTextField();
	private JTextField timeTxtField = new JTextField();
	private JTextField codeTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField pointTxtField = new JTextField();
	private JTextField planTxtField = new JTextField();
	private JTextField maxTxtField = new JTextField();
	
	private Lecture data;

	public ProfessorLectureInfoView() {
		super();

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("년도", yearTxtField, row++, true);
		genInfoPair("학기", semesterTxtField, row++, true);
		genInfoPair("요일", dayTxtField, row++, true);
		genInfoPair("강의시간", timeTxtField, row++, true);
		genInfoPair("강의코드", codeTxtField, row++, false);
		genInfoPair("강의제목", nameTxtField, row++, true);
		genInfoPair("학점", pointTxtField, row++, true);
		genInfoPair("강의계획", planTxtField, row++, true);
		genInfoPair("강의 최대 인원수", maxTxtField, row++, true);
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
	public void setData(Object lecture) {
		data = (Lecture) lecture;
		yearTxtField.setText(Integer.toString(data.getYear()));
		semesterTxtField.setText(Integer.toString(data.getSemester()));
		dayTxtField.setText(data.getDay());
		timeTxtField.setText(data.getTime());
		codeTxtField.setText(data.getCode());
		nameTxtField.setText(data.getName());
		pointTxtField.setText(Integer.toString(data.getPoint()));
		planTxtField.setText(data.getLecturePlan());
		maxTxtField.setText(Integer.toString(data.getMax_count()));
	}

	@Override
	public Object getData() {
		data.setYear(Integer.parseInt(yearTxtField.getText()));
		data.setSemester(Integer.parseInt(semesterTxtField.getText()));
		data.setDay(dayTxtField.getText());
		data.setTime(timeTxtField.getText());
		data.setCode(codeTxtField.getText());
		data.setName(nameTxtField.getText());
		data.setPoint(Integer.parseInt(pointTxtField.getText()));
		data.setMax_count(Integer.parseInt(maxTxtField.getText()));
		data.setLecturePlan(planTxtField.getText());
		return data;
	}
}
