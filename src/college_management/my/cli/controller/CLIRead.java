package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserSoldier;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;
import college_management.my.service.InfoService;
import college_management.my.service.StudentService;
import college_management.my.service.UserService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

/**
 * A command with some options to demonstrate completion.
 */
@Command(name = "read", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRead implements Runnable  {
//	@Parameters(paramLabel = "Role", description = "The role")
//	private String role;
//
//	@Option(names = { "-i", "--id" }, description = "The student ID", required = true)
//	private String id = "";
	
	@Option(names = { "-a", "--all" }, description = "The All Users")
	private boolean isAll;
	
	@Option(names = { "-s", "--student" }, description = "The Student Users")
	private boolean st;
	
	@Option(names = { "-f", "--family" }, description = "The Users Family")
	private boolean f;
	
	@Option(names = { "-sd", "--sodier" }, description = "The Student sodier")
	private boolean sd;
	
	@Option(names = { "-da", "--disabilty" }, description = "The Student sodier")
	private boolean da;
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private StudentService studentService = StudentService.getInstance();
	private InfoService infoService = InfoService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		if (isAll) {
			if (auth.hasAdminPermission()) {
				// 모든 사용자 정보 출력
				for (User user : userService.readAll()) {
					parent.out.println(user.toString());
				}
			} else {
				parent.out.println("it's denided");
			}
			return;
		}
		
		// 사용자 정보 출력
		User user = auth.getUser();
		
		if(st) {
			if(auth.hasStudentPermission()) {
				Student student = studentService.read(user.getId());
				parent.out.println(student.toString());
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(f) {
			for(UserFamily family : userService.readAll(user.getId())) {
				parent.out.println(family.toString());
			};
			return;
		}
		
		if(da) {
			UserDisability disability = infoService.read(user.getId());
			parent.out.println(disability.toString());
			return;
		}
		
		if(sd) {
			UserSoldier sodier = infoService.sread(user.getId());
			parent.out.println(sodier.toString());
			return;
		}
		
		parent.out.println(user.toString());
	}
}
