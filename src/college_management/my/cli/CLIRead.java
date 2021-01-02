package college_management.my.cli;

import college_management.my.api.UserAPI;
import college_management.my.model.User;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

/**
 * A command with some options to demonstrate completion.
 */
@Command(name = "read", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRead implements Runnable  {
	@Parameters(paramLabel = "Role", description = "The role")
	private String role;

	@Option(names = { "-i", "--id" }, description = "The student ID", required = true)
	private String id = "";
	
	@ParentCommand
	CliCommands parent;

	public void run() {
		switch(role) {
		case "student":
			UserAPI api = new UserAPI();
			User user = new User();
			user = api.info(id);
			if(user != null)
				parent.out.println(user.toString());
			else
				parent.out.printf("'%s' in not exist\n", id);
			break;
		case "professor":
			break;
		case "employee":
			break;
		default:
			parent.out.printf("'%s' is not supprt\n", role);
			break;
		}
	}
}
