package college_management.my.GUI.component;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import college_management.my.GUI.component.login.LoginCard;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	private static MainGUI instance = new MainGUI();
	private CardLayout layout = new CardLayout();

	// tab
	private final static String Login = "MAIN";
	private final static String Professor = "PROFESSOR";
	private final static String Student = "STUDENT";
	private final static String Admin = "ADMIN";

	public static void main(String[] args) {
		instance.start();
	}

	public MainGUI() {
		// set configuration
		setSize(1000, 700);
		setLocation(200, 400);

		// set layout
		Container pan = getContentPane();
		pan.setLayout(layout);
		pan.add(Login, new LoginCard(this));
//		pan.add(Professor, new ProfessorTab(this));
//		pan.add(Student, new StudentCard(this));
//		an.add(Admin, new AdminCard(this));
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
}
