package college_management.my.cli;

import college_management.my.api.UserAPI;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "logout")
public class CLILogout implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAPI api = new UserAPI();
		boolean isLogout = api.logout();
		if (isLogout) {
			CLIAuth.getInstance().logout();
			parent.out.println("login success");
		} else {
			parent.out.println("login fail");
		}
	}
}