package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.service.StudentService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "sregister", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLISRegister implements Runnable{
//	@Parameters(paramLabel = "Role", description = "The role")
//    private String role;
	
	@Option(names = { "-m", "--major" }, description = "The student Major", required = true)
	private String major = "";
	
	@Option(names = { "-c", "--campus" }, description = "The student Campus", required = true)
	private String campus = "";
	
	@ParentCommand
	CliCommands parent;

	private StudentService subjectService = StudentService.getInstance();
	
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

		//id 확인
		String id = auth.getUser().getId();
		
		// 정보 추가
		boolean result = subjectService.sregister(major, campus);
		if (result) {
			parent.out.println("register success");
		} else {
			parent.out.println("register fail");
		}
	}
}
