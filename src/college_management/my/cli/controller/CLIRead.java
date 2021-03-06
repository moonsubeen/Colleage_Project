package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
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
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	
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
		parent.out.println(user.toString());
		
//		CLIAuth auth = CLIAuth.getInstance();
//		if(!auth.isLogin())
//		{
//			parent.out.println("It's need to login");
//			return;
//		}
//		
//		User user = CLIAuth.getInstance().getUser();
//		
//		switch(user.getRole()) {
//		case "student":
//			parent.out.println(user.toString());
//			break;
//		case "professor":
//			break;
//		case "employee":
//			break;
//		}
		
//		switch(Role) {
//		case "student":
//			UserAPI api = new UserAPI();
//			User user = new User();
//			user = api.info(id);
//			if(user != null)
//				parent.out.println(user.toString());
//			else
//				parent.out.printf("'%s' in not exist\n", id);
//			break;
//		case "professor":
//			break;
//		case "employee":
//			break;
//		default:
//			parent.out.printf("'%s' is not supprt\n", role);
//			break;
//		}
	}
}
