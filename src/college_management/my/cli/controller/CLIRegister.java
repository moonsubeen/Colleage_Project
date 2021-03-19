package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
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
@Command(name = "register", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRegister implements Runnable  {
	@Parameters(paramLabel = "Role", description = "The role")
    private String role;

	@Option(names = { "-n", "--name" }, description = "The student name", required = true)
	private String name = "";
	
	@Option(names = { "-i", "--id" }, description = "The student ID", required = true)
	private String id = "";
	
	@Option(names = { "-e", "--email" }, description = "The email", required = false)
	private String email = "";
	
	@Option(names = { "-na", "--nationality" }, description = "The nationality", required = false)
	private String nationality = "";
	
	@Option(names = { "-p", "--phoneNumber" }, description = "The phone number", required = false)
	private String phoneNumber = "";
	
	@Option(names = { "-a", "--address" }, description = "The address", required = false)
	private String address = "";
	
	@Option(names = { "-r", "--residentNumber" }, description = "The residentNumber", required = false)
	private String residentNumber= "";
	
	@Option(names = { "-b", "--birthdate" }, description = "The birthdate", required = false)
	private String birthdate= "";
	
	@Option(names = { "-s", "--sex" }, description = "The sex", required = false)
	private String sex= "";
	
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

		// 권한 확인
		if (!auth.hasAdminPermission()) {
			parent.out.println("your account have not register permission");
			return;
		}

//		// 입력 내용 확인
//		Permission p = Permission.valueOfType(role);
//		if (p == null) {
//			parent.out.println("role is wrong");
//			return;
//		}

		// 사용자 추가
		if(userService.register(id, name, email, nationality, phoneNumber, address, residentNumber, birthdate, sex, role)) {
			parent.out.println("register success");
		} else {
			parent.out.println("register fail");
		}
		
//		switch(role) {
//		case "student":
//			EmployeeAPI api = new EmployeeAPI();
//			UserAPI api = new UserAPI();
//			boolean result = api.RegistInfo(role, id, name, email, nationality, phoneNumber, address, residentNumber, birthdate, sex);
//			if(result) 
//				parent.out.println("register success");
//			else
//				parent.out.println("register fail");
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
