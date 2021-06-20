package college_management.my.cli.controller;

import college_management.my.auth.UserAuth;
import college_management.my.db.model.User;
import college_management.my.service.UserService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "update")
public class CLIUpdate implements Runnable {
//	@Parameters(paramLabel = "Role", description = "The role")
//	private String role;
//
//	@Option(names = { "-i", "--id" }, description = "The student ID")
//	private String id;
	@Option(names = { "-u", "--update" }, description = "The student Password", required = false)
	private boolean update;
	
	@Option(names = { "-p", "--password" }, description = "The student Password", required = false)
	private String password;
	
	@Option(names = { "-n", "--name" }, description = "The student Email", required = false)
	private String name;
	
	@Option(names = { "-e", "--email" }, description = "The student Email", required = false)
	private String email;
	
	@Option(names = { "-a", "--address" }, description = "The student Address", required = false)
	private String address;
	
	@Option(names = { "-ph", "--phoneNumber" }, description = "The student phoneNumber", required = false)
	private String phoneNumber;
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();
		String id = auth.getUser().getId();
		
		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		if(update) {
			if(userService.update2(id, address, name))
				parent.out.println("update success");
			else
				parent.out.println("update fail");
		}
		else {
		// 사용자 정보 갱신
		boolean result = userService.update(id, password, name, email, address, phoneNumber);
		if (result) {
			parent.out.println("update success");
		} else {
			parent.out.println("update fail");
		}
		}
	}
}
