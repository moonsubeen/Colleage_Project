package college_management.my.gui.layout.student.history;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.LectureHistory;
import college_management.my.gui.layout.common.LecView;

public class StudentHistoryInfoView extends LecView{
	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField codeTxtField = new JTextField();
	private JTextField titleTxtField = new JTextField();
	private JTextField gradeTxtField = new JTextField();
	private JTextField rankTxtField = new JTextField();
	private JTextField problemTxtField = new JTextField();
	private JTextField evaluationTxtField = new JTextField();
	
	private LectureHistory data;
	
	public StudentHistoryInfoView() {
		super();
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("학생 아이디", idTxtField, row++, false);
		genInfoPair("학생 이름", nameTxtField, row++, false);
		genInfoPair("강의 코드", codeTxtField, row++, false);
		genInfoPair("강의 제목", titleTxtField, row++, false);
		genInfoPair("점수", gradeTxtField, row++, false);
		genInfoPair("등급", rankTxtField, row++, false);
		genInfoPair("문제제기", problemTxtField, row++, true);
		genInfoPair("강의평가", evaluationTxtField, row++, true);
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
		idTxtField.setText(data.getStudent().getUser().getId());
		nameTxtField.setText(data.getStudent().getUser().getName());
		codeTxtField.setText(data.getLecture().getCode());
		titleTxtField.setText(data.getLecture().getName());
		gradeTxtField.setText(Integer.toString(data.getGrade()));
		rankTxtField.setText(data.getRank());
		problemTxtField.setText(data.getProblem());
		evaluationTxtField.setText(data.getEvaluation());
	}

	@Override
	public Object getData() {
		data.setGrade(Integer.parseInt(gradeTxtField.getText()));
		data.setRank(rankTxtField.getText());
		data.setProblem(problemTxtField.getText());
		data.setEvaluation(evaluationTxtField.getText());
		return data;
	}
}
