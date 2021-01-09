package college_management.my.cli;

import college_management.my.api.UserAPI;
import college_management.my.model.User;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "infoupdate")
public class CLIInfoUpdate implements Runnable {
//	@Parameters(paramLabel = "Role", description = "The role")
//	private String role;
//
//	@Option(names = { "-i", "--id" }, description = "The student ID")
//	private String id;

	@Option(names = { "-e", "--email" }, description = "The student email", required = false)
	private String email;
	
	@Option(names = { "-a", "--address" }, description = "The student email", required = false)
	private String address;
	
	@Option(names = { "-p", "--phone" }, description = "The student email", required = false)
	private String phoneNumber;
	
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
			boolean result = api.infoUpdate(user.getId(), email, address, phoneNumber);
			if (result) {
				parent.out.println("update success");
			} else {
				parent.out.println("update fail");
			}
			break;
		}
	}
}
