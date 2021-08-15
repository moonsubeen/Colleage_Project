package college_management.my.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Lecture;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

public class AdminLectureRegDlgView extends LecView{
	private JTextField codeTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
//	private JTextField professorTxtField = new JTextField();
	private JTextField yearTxtField = new JTextField();
	private JTextField semesterTxtField = new JTextField();
	private JTextField dayTxtField = new JTextField();
	private JTextField timeTxtField = new JTextField();
	private JTextField pointTxtField = new JTextField();
	private JTextField planTxtField = new JTextField();
	private JTextField maxTxtField = new JTextField();
	private JTextField idTxtField = new JTextField();
	private Lecture data;
	
	public AdminLectureRegDlgView() {
		super();
		
		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addTextFieldPair("년도", yearTxtField, row++, true);
		addTextFieldPair("학기", semesterTxtField, row++, true);
		addTextFieldPair("학점", pointTxtField, row++, true);
		addTextFieldPair("요일", dayTxtField, row++, true);
		addTextFieldPair("강의시간", timeTxtField, row++, true);
		addTextFieldPair("강의코드", codeTxtField, row++, true);
		addTextFieldPair("교수아이디", idTxtField, row++, true);
		addTextFieldPair("강의제목", nameTxtField, row++, true);
		addTextFieldPair("강의계획", planTxtField, row++, true);
		addTextFieldPair("강의최대인원수", maxTxtField, row++, true);
	}

	private void addTextFieldPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);
		
		txtField.setEditable(isEditable);
		txtField.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}
	
	public JTextField getCodeTxtField() {
		return codeTxtField;
	}

	public JTextField getNameTxtField() {
		return nameTxtField;
	}

//	public JTextField getProfessorTxtField() {
//		return professorTxtField;
//	}

	public JTextField getYearTxtField() {
		return yearTxtField;
	}

	public JTextField getSemesterTxtField() {
		return semesterTxtField;
	}

	public JTextField getDayTxtField() {
		return dayTxtField;
	}

	public JTextField getTimeTxtField() {
		return timeTxtField;
	}

	public JTextField getPointTxtField() {
		return pointTxtField;
	}

	public JTextField getPlanTxtField() {
		return planTxtField;
	}

	public JTextField getMaxTxtField() {
		return maxTxtField;
	}

	public JTextField getIdTxtField() {
		return idTxtField;
	}

	@Override
	public void setData(Object lecture) {
		data = (Lecture) lecture;
		codeTxtField.setText(data.getCode());
		semesterTxtField.setText(Integer.toString(data.getSemester()));
		yearTxtField.setText(Integer.toString(data.getYear()));
		dayTxtField.setText(data.getDay());
		pointTxtField.setText(Integer.toString(data.getPoint()));
		timeTxtField.setText(data.getTime());
		maxTxtField.setText(Integer.toString(data.getMax_count()));
		planTxtField.setText(data.getLecturePlan());
//		professorTxtField.setText(data.getProfessor().getUser().getName());
		nameTxtField.setText(data.getName());
		idTxtField.setText(data.getProfessor().getUser().getId());
	}

	@Override
	public Object getData() {
//		Professor professor = new Professor();
		Lecture lecture = new Lecture();
//		professor.getUser();
		lecture.setYear(Integer.parseInt(yearTxtField.getText()));
		lecture.setSemester(Integer.parseInt(semesterTxtField.getText()));
		lecture.setPoint(Integer.parseInt(pointTxtField.getText()));
		lecture.setDay(dayTxtField.getText());
		lecture.setTime(timeTxtField.getText());
		lecture.setCode(codeTxtField.getText());
		lecture.setName(nameTxtField.getText());
		lecture.setLecturePlan(planTxtField.getText());
		lecture.setMax_count(Integer.parseInt(maxTxtField.getText()));
//		lecture.setProfessor(professor);
		return lecture;
	}
}
