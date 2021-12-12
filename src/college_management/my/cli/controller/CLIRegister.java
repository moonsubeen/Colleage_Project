package college_management.my.cli.controller;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.db.model.User;
import college_management.my.service.InfoService;
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
	
	@Option(names = { "-m", "--major" }, description = "The student Major", required = false)
	private String major = "";
	
	@Option(names = { "-ca", "--campus" }, description = "The student Campus", required = false)
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
	
	@Option(names = {"-st", "--state" }, description = "The relation", required = false)
	private String state;
	
	@Option(names = {"-di", "--disability" }, description = "The relation", required = false)
	private String disability = "";
	
	@Option(names = {"-do", "--document" }, description = "The relation", required = false)
	private String document = "";
	
	@Option(names = {"-mn", "--militaryNumber" }, description = "The relation", required = false)
	private String militaryNumber = "";
	
	@Option(names = {"-t", "--type" }, description = "The relation", required = false)
	private String type = "";
	
	@Option(names = {"-cl", "--classification" }, description = "The relation", required = false)
	private String classification = "";
	
	@Option(names = {"-br", "--branch" }, description = "The relation", required = false)
	private String branch = "";
	
	@Option(names = {"-ra", "--rank" }, description = "The relation", required = false)
	private String rank = "";
	
	@Option(names = {"-jd", "--joinDate" }, description = "The relation", required = false)
	private String joinDate = "";
	
	@Option(names = {"-dd", "--dischageDate" }, description = "The relation", required = false)
	private String dischageDate = "";
	
	@Option(names = {"-y", "--year" }, description = "The relation", required = false)
	private int year;
	
	@Option(names = {"-se", "--semester" }, description = "The relation", required = false)
	private int semester;
	
	@Option(names = {"-da", "--day" }, description = "The relation", required = false)
	private String day = "";
	
	@Option(names = {"-ti", "--time" }, description = "The relation", required = false)
	private String time;
	
	@Option(names = {"-co", "--count" }, description = "The relation", required = false)
	private int count;
	
	@Option(names = {"-g", "--grade" }, description = "The relation", required = false)
	private String grade;
	
	@Option(names = {"-mo", "--month" }, description = "The relation", required = false)
	private String month;
	
	@Option(names = {"-at", "--attendance" }, description = "The relation", required = false)
	private String attendance;
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private StudentService studentService = StudentService.getInstance();
	private ProfessorService professorService = ProfessorService.getInstance();
	private LectureService lectureService = LectureService.getInstance();
	private InfoService infoService = InfoService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();
		User user = auth.getUser();
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
				if(studentService.register(id, major, campus)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "professor":
				auth();
				if(professorService.register(id, faculty, department)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "family":
				if(userService.register(id, name, relation, phoneNumber)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "lecture":
				pauth();
				if(lectureService.register(user.getId(), code, name, year, semester, day, time, count, point, plan)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "lecture2":
//				pauth();
				if(lectureService.register(code, user.getId())) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "lecture3":
				pauth();
				if(lectureService.register3(id, code, month, day, attendance)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "disabilityinfo":
				auth();
				if(infoService.register(id, state, disability, document)) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
				}
				break;
			case "soldierinfo":
				auth();
				if(infoService.register(id, state, militaryNumber, type, classification, branch, rank, joinDate, dischageDate)) {
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
