package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.db.model.User;
import college_management.my.service.LectureService;
import college_management.my.service.ProfessorService;
import college_management.my.service.StudentService;
import college_management.my.service.UserService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

/**
 * A command with some options to demonstrate completion.
 */
@Command(name = "register", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRegister implements Runnable  {
	@Parameters(paramLabel = "Info", description = "The Info")
    private String info;
	
//	@Parameters(paramLabel = "Role", description = "The Role")
//    private String role;
	
	@Option(names = { "-r", "--role" }, description = "The user role", required = false)
	private String role = "";
	
	@Option(names = { "-n", "--name" }, description = "The student name", required = false)
	private String name = "";
	
	@Option(names = { "-i", "--id" }, description = "The student ID", required = false)
	private String id = "";
	
	@Option(names = { "-e", "--email" }, description = "The email", required = false)
	private String email = "";
	
	@Option(names = { "-na", "--nationality" }, description = "The nationality", required = false)
	private String nationality = "";
	
	@Option(names = { "-p", "--phoneNumber" }, description = "The phone number", required = false)
	private String phoneNumber = "";
	
	@Option(names = { "-a", "--address" }, description = "The address", required = false)
	private String address = "";
	
	@Option(names = { "-re", "--residentNumber" }, description = "The residentNumber", required = false)
	private String residentNumber= "";
	
	@Option(names = { "-b", "--birthdate" }, description = "The birthdate", required = false)
	private String birthdate= "";
	
	@Option(names = { "-s", "--sex" }, description = "The sex", required = false)
	private String sex= "";
	
//	@Option(names = { "-info"}, description = "The info", required = false)
//	private String info= ""; // register student -info {"major", "computer", "campus", "center"}
	
	@Option(names = { "-m", "--major" }, description = "The student Major", required = false)
	private String major = "";
	
	@Option(names = { "-c", "--campus" }, description = "The student Campus", required = false)
	private String campus = "";
	
	@Option(names = { "-f", "--faculty" }, description = "The student faculty", required = false)
	private String faculty = "";
	
	@Option(names = { "-d", "--department" }, description = "The student department", required = false)
	private String department = "";
	
	@Option(names = { "-c", "--code" }, description = "The code", required = false)
	private String code = "";
	
	@Option(names = { "-po", "--point" }, description = "The point", required = false)
	private int point;
	
	@Option(names = { "-pl", "--plan" }, description = "The plan", required = false)
	private String plan = "";
	
	@Option(names = { "-rl", "--relation" }, description = "The relation", required = false)
	private String relation = "";
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private StudentService studentService = StudentService.getInstance();
	private ProfessorService professorService = ProfessorService.getInstance();
	private LectureService lectureService = LectureService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		// 사용자 추가
		switch(info) {
			case "user":
				auth();
				if(userService.register(id, name, email, nationality, phoneNumber, address, residentNumber, birthdate, sex, role)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "student":
				auth();
				if(studentService.sregister(id, major, campus)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "professor":
				auth();
				if(professorService.pregister(id, faculty, department)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "family":
				if(userService.fregister(id, name, relation, phoneNumber)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "lecture":
				pauth();
				if(lectureService.lregister(id, code, name, point, plan)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			default:
				break;
		}
		
	}
	
	public void auth() {
		UserAuth auth = UserAuth.getInstance();
		// 권한 확인
		if (!auth.hasAdminPermission()) {
			parent.out.println("your account have not register permission");
			return;
		}
	}
	
	public void pauth() {
		UserAuth auth = UserAuth.getInstance();
		// 권한 확인
		if (!auth.hasProfessorPermission()) {
			parent.out.println("your account have not register permission");
			return;
		}
	}
}
