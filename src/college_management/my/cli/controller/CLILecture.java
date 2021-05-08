package college_management.my.cli.controller;

import college_management.my.auth.UserAuth;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Student;
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
	
	@Option(names = { "-i", "--id" }, description = "The identification")
	private String id = "";
	
	@Option(names = { "-ev", "--eval" }, description = "The identification")
	private String evaluation = "";
	
	@Option(names = { "-c", "--code" }, description = "The identification")
	private String code = "";
	
	@Option(names = { "-pr", "--pro" }, description = "The identification")
	private String problem = "";
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private LectureService lectureService = LectureService.getInstance();

	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		if(eval) {
			if(auth.hasStudentPermission()) {
				if(lectureService.evaluation(code, id, evaluation))
				parent.out.println("register success");
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(pro) {
			if(auth.hasStudentPermission()) {
				if(lectureService.problem(code, id, problem))
				parent.out.println("register success");
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
	}
}
