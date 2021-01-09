package college_management.my.cli;

import college_management.my.api.UserAPI;
import college_management.my.model.User;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "pwdupdate")
public class CLIPwdUpdate implements Runnable {
//	@Parameters(paramLabel = "Role", description = "The role")
//	private String role;

	@Option(names = { "-i", "--id" }, description = "The student ID")
	private String id;

	@Option(names = { "-p", "--password" }, description = "The student Password")
	private String pwd;
	
	@ParentCommand
	CliCommands parent;

	public void run() {
		CLIAuth auth = CLIAuth.getInstance();
		if(!auth.isLogin())
		{
			parent.out.println("It's need to login");
			return;
		}
		
		User user = CLIAuth.getInstance().getUser();
		
		switch (user.getRole()) {
		case "student":
			UserAPI api = new UserAPI();
			boolean result = api.pwdUpdate(pwd, user.getId());
			if (result) {
				parent.out.println("update success");
			} else {
				parent.out.println("update fail");
			}
			break;
		}
	}
}
