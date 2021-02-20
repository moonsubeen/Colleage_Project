package college_management.my.cli;

import college_management.my.api.UserAPI;
import college_management.my.api.UserAuth;
import college_management.my.model.User;
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

	public void run() {
		UserAuth auth = UserAuth.getInstance();
		String id = auth.getUser().getId();
		
		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		// 사용자 정보 갱신
		boolean result = auth.getUserAPI().update(id, password, name, email, address, phoneNumber);
		if (result) {
			parent.out.println("update success");
		} else {
			parent.out.println("update fail");
		}
		
//		CLIAuth auth = CLIAuth.getInstance();
//		if(!auth.isLogin())
//		{
//			parent.out.println("It's need to login");
//			return;
//		}
//		
//		User user = CLIAuth.getInstance().getUser();
//		
//		switch (user.getRole()) {
//		case "student":
//			UserAPI api = new UserAPI();
//			boolean result = api.pwdUpdate(pwd, user.getId());
//			if (result) {
//				parent.out.println("update success");
//			} else {
//				parent.out.println("update fail");
//			}
//			break;
//		}
	}
}
