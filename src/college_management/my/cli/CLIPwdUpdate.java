package college_management.my.cli;

import college_management.my.api.UserAPI;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "pwdupdate")
public class CLIPwdUpdate implements Runnable {
	@Parameters(paramLabel = "Role", description = "The role")
	private String role;

	@Option(names = { "-i", "--id" }, description = "The student ID")
	private String id;

	@Option(names = { "-p", "--password" }, description = "The student Password")
	private String pwd;
	
	@ParentCommand
	CliCommands parent;

	public void run() {
		switch (role) {
		case "student":
			if (id == "")
				break;
			UserAPI api = new UserAPI();
			boolean result = api.pwdUpdate(pwd, id);
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
