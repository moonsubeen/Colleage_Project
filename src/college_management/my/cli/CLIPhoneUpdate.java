package college_management.my.cli;

import college_management.my.api.UserAPI;
import college_management.my.model.User;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "phoneupdate")
public class CLIPhoneUpdate implements Runnable {
	@Option(names = { "-p", "--phone" }, description = "The student phonenumber", required = false)
	private String phonenumber;
	
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
			boolean result = api.emailUpdate(user.getId(), phonenumber);
			if (result) {
				parent.out.println("update success");
			} else {
				parent.out.println("update fail");
			}
			break;
		}
	}
}
