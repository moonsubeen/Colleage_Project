package college_management.my.gui;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import college_management.my.gui.component.admin.AdminCard;
import college_management.my.gui.component.common.CardPanelInterface;
import college_management.my.gui.component.login.LoginCard;
import college_management.my.gui.component.professor.ProfessorCard;
import college_management.my.gui.component.professor.ProfessorTab;
import college_management.my.gui.component.student.StudentCard;

@SuppressWarnings("serial")
public class MainGUI extends JFrame implements CardPanelInterface {
	private static MainGUI instance = new MainGUI();
	private CardLayout layout = new CardLayout();

	// tab
	private final static String Login = "MAIN";
	private final static String Professor = "PROFESSOR";
	private final static String Student = "STUDENT";
	private final static String Admin = "ADMIN";

	private static LoginCard loginCard;
	private static StudentCard studentCard;
	private static AdminCard adminCard;
	private static ProfessorCard professorCard;
	
	public static void main(String[] args) {
		instance.start();
	}

	public MainGUI() {
		// set configuration
		setSize(1000, 700);
		setLocation(200, 400);

		// set layout
		loginCard = new LoginCard(this, this);
		professorCard = new ProfessorCard(this, this);
		studentCard = new StudentCard(this, this);
		adminCard = new AdminCard(this, this);
		
		Container pan = getContentPane();
		pan.setLayout(layout);
		pan.add(Login, loginCard);
		pan.add(Professor, professorCard);
		pan.add(Student, studentCard);
		pan.add(Admin, adminCard);
	}

	private void start() {
		this.setVisible(true);
	}

	public void changeLoginTab() {
		layout.show(this.getContentPane(), Login);
	}

	public void changeProfessorTab() {
		layout.show(this.getContentPane(), Professor);
	}

	public void changeStudentTab() {
		layout.show(this.getContentPane(), Student);
	}

	public void changeAdminTab() {
		layout.show(this.getContentPane(), Admin);
	}

	@Override
	public void initView() {
//		loginCard.init();
		professorCard.init();
		studentCard.init();
		adminCard.init();
	}
}
