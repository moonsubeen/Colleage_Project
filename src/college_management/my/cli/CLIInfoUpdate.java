package college_management.my.cli;

import college_management.my.api.UserAPI;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "infoupdate")
public class CLIInfoUpdate implements Runnable {
	@Parameters(paramLabel = "Role", description = "The role")
	private String role;

	@Option(names = { "-i", "--id" }, description = "The student ID")
	private String id;

	@Option(names = { "-e", "--email" }, description = "The student email", required = false)
	private String email;
	
	@Option(names = { "-a", "--address" }, description = "The student email", required = false)
	private String address;
	
	@Option(names = { "-p", "--phone" }, description = "The student email", required = false)
	private String phoneNumber;
	
	@ParentCommand
	CliCommands parent;

	public void run() {
		switch (role) {
		case "student":
			if (id == "")
				break;
			UserAPI api = new UserAPI();
			boolean result = api.infoUpdate(id, email, address, phoneNumber);
			if (result) {
				parent.out.println("update success");
			} else {
				parent.out.println("update fail");
			}
			break;
		default:
			parent.out.printf("'%s' is not support\n", role);
			break;
		}
	}
}
