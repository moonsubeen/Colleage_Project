package college_management.my.cli.controller;

import college_management.my.auth.UserAuth;
import college_management.my.db.model.User;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "login")
public class CLILogin implements Runnable {
	@Parameters(paramLabel = "ID", description = "The ID", index = "0")
	private String id;

	@Parameters(paramLabel = "Password", description = "The Password", index = "1")
	private String password;

	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (auth.isLogin()) {
			parent.out.println("it's need to logout");
			return;
		}

		// 로그인
		if (!auth.login(id, password)) {
			parent.out.println("fail to login");
			return;
		}
		
//		UserAuth auth = UserAuth.getInstance();
//		if(auth.isLogin()) {
//			parent.out.println("it's need to logout");
//			return;
//		}
//		
//		UserAPI api = new UserAPI();
//		User user = api.login(id, password);
//		if (user != null) {
//			UserAuth.getInstance().login(user);
//			parent.out.println("login success");
//		} else {
//			parent.out.println("login fail");
//		}
		
//		UserAPI api = new UserAPI();
//		User user = api.login(id, password);
//		if (user != null) {
//			CLIAuth.getInstance().login(user);
//			parent.out.println("login success");
//		} else {
//			parent.out.println("login fail");
//		}
	}
}
