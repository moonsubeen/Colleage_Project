package college_management.my.cli.controller;

import college_management.my.auth.UserAuth;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.service.LectureService;
import college_management.my.service.UserService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "lecture", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLILecture implements Runnable {
	
	@Option(names = { "-e", "--evaluation" }, description = "The Student Users")
	private boolean eval;
	
	@Option(names = { "-p", "--problem" }, description = "The Student Users")
	private boolean pro;
	
	@Option(names = { "-a", "--attendacne" }, description = "The Student Users")
	private boolean attendacne;
	
	@Option(names = { "-ga", "--gra" }, description = "The Student Users")
	private boolean gra;
	
	@Option(names = { "-ev", "--eval" }, description = "The identification")
	private String evaluation = "";
	
	@Option(names = { "-c", "--code" }, description = "The identification")
	private String code = "";
	
	@Option(names = { "-pr", "--pro" }, description = "The identification")
	private String problem = "";
	
	@Option(names = { "-m", "--month" }, description = "The identification")
	private int month;
	
	@Option(names = { "-d", "--day" }, description = "The identification")
	private String day = "";
	
	@Option(names = { "-g", "--grade" }, description = "The Student Users")
	private int grade;
	
	@Option(names = { "-i", "--id" }, description = "The Student Users")
	private String id = "";
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private LectureService lectureService = LectureService.getInstance();

	public void run() {
		UserAuth auth = UserAuth.getInstance();
//		String id = auth.getUser().getId();
		User user = auth.getUser();
		
		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		if(eval) {
			if(auth.hasStudentPermission()) {
				if(lectureService.evaluation(code, user.getId(), evaluation))
				parent.out.println("update success");
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(pro) {
			if(auth.hasStudentPermission()) {
				if(lectureService.problem(code, user.getId(), problem))
				parent.out.println("update success");
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(gra) {
			if(auth.hasProfessorPermission()) {
				if(lectureService.grade(code, id, grade))
					parent.out.println("update success");
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
	}
}
