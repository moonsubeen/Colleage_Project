package college_management.my.cli;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.fusesource.jansi.AnsiConsole;
import org.jline.builtins.Widgets.TailTipWidgets;
import org.jline.builtins.Widgets.TailTipWidgets.TipType;
import org.jline.reader.*;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.cli.controller.CliCommands;
import college_management.my.cli.controller.DescriptionGenerator;
import college_management.my.service.UserService;
import picocli.CommandLine;
import picocli.shell.jline3.PicocliCommands;

/**
 * Example that demonstrates how to build an interactive shell with JLine3 and
 * picocli.
 * 
 * @since 4.1.2
 */
public class CLIApp {

	private static CommandLine cmd;
	private static CliCommands commands;
	private static DescriptionGenerator descriptionGenerator;
	private static UserAuth auth = UserAuth.getInstance();
	
	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		try {
			// 명령어 세팅
			commands = new CliCommands();
			cmd = new CommandLine(commands);
			Path workDir = Paths.get("");
			PicocliCommands picocliCommands = new PicocliCommands(workDir, cmd);
			Terminal terminal = TerminalBuilder.builder().build();
			LineReader reader = LineReaderBuilder.builder().terminal(terminal)
					.parser(new DefaultParser()).variable(LineReader.LIST_MAX, 50) // max tab completion candidates
					.build();
			commands.setReader(reader);
			
			descriptionGenerator = new DescriptionGenerator(picocliCommands);
			new TailTipWidgets(reader, descriptionGenerator::commandDescription, 5, TipType.COMPLETER);
			
			// 초기화 (Default 어드민 계정 추가)
			Init();
						
			// start the shell and process input until the user quits with Ctrl-D
			String prompt = "";
			String rightPrompt = null;
			String line;
			while (true) {
				try {
					if(auth.isLogin())
						prompt = auth.getLoginName() + "> ";
					else
						prompt = "prompt> ";
					
					// 명령어 읽기
					line = reader.readLine(prompt, rightPrompt, (MaskingCallback) null, null);
					if (line.matches("^\\s*#.*")) {
						continue;
					}
					
					// 명령어 파싱
					ParsedLine pl = reader.getParser().parse(line, 0);
					String[] arguments = pl.words().toArray(new String[0]);
					
					// 명령어 실행
					new CommandLine(commands).execute(arguments);
				} catch (UserInterruptException e) {
					// Ignore
				} catch (EndOfFileException e) {
					return;
				} catch (Exception e) {
					AttributedStringBuilder asb = new AttributedStringBuilder();
					asb.append(e.getMessage(), AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
					asb.toAttributedString().println(terminal);
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private static void Init() {
		UserService userService = UserService.getInstance();
		if(userService.read("admin") != null)
			return;
		
		boolean result = userService.register("admin", "admin", "aaaa@gmail.com", "한국", "010-0000-0000", "서울", "******-*******", "19**-**-**", "남", "admin");
		if (result) {
			System.out.println("init success");
		} else {
			System.out.println("init fail");
		}
	}
}
