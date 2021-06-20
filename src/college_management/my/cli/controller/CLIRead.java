package college_management.my.cli.controller;

import java.util.List;

import college_management.my.api.config.Permission;
import college_management.my.auth.UserAuth;
import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Professor;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserSoldier;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;
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
@Command(name = "read", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRead implements Runnable  {
//	@Parameters(paramLabel = "Info", description = "The Info")
//    private String info;
    
	@Option(names = { "-i", "--id" }, description = "The identification")
	private String id = "";
	
	@Option(names = { "-a", "--all" }, description = "The All Users")
	private boolean isAll;
	
	@Option(names = { "-s", "--student" }, description = "The Student Users")
	private boolean student;
	
	@Option(names = { "-f", "--family" }, description = "The Users Family")
	private boolean family;
	
	@Option(names = { "-sd", "--sodier" }, description = "The Student sodier")
	private boolean sodier;
	
	@Option(names = { "-d", "--disabilty" }, description = "The Student sodier")
	private boolean disabilty;
	
	@Option(names = { "-p", "--professor" }, description = "The Student sodier")
	private boolean professor;
	
	@Option(names = { "-l", "--lecture" }, description = "The Student sodier")
	private boolean lecture;
	
	@Option(names = { "-lh", "--lecturehistory" }, description = "The Student sodier")
	private boolean lecturehistory;
	
	@Option(names = { "-lha", "--lecturehistoryAll" }, description = "The Student sodier")
	private boolean lecturehistoryAll;
	
	@Option(names = { "-la", "--lecture all" }, description = "The Student sodier")
	private boolean lectureAll;
	
	@Option(names = { "-le", "--lectureAttendance" }, description = "The Student sodier")
	private boolean lectureAttendance;
	
	@Option(names = { "-les", "--lectureAttendanceSelect" }, description = "The Student sodier")
	private boolean lectureAttendanceSelect;
	
	@Option(names = { "-lea", "--lectureAttendanceAll" }, description = "The Student sodier")
	private boolean lectureAttendanceAll;
	
	@Option(names = { "-c", "--code" }, description = "The Student sodier")
	private String code = "";
	
	@ParentCommand
	CliCommands parent;
	
	private UserService userService = UserService.getInstance();
	private StudentService studentService = StudentService.getInstance();
	private InfoService infoService = InfoService.getInstance();
	private ProfessorService professorService = ProfessorService.getInstance();
	private LectureService lectureService = LectureService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		if (isAll) {
			if (auth.hasAdminPermission()) {
				// 모든 사용자 정보 출력
				for (User user : userService.readAll()) {
					parent.out.println(user.toString());
				}
			} else {
				parent.out.println("it's denided");
			}
			return;
		}
		
		// 사용자 정보 출력
		User user = auth.getUser();
		User users = userService.read(user.getId());
		
		if(student) {
			if(auth.hasStudentPermission()) {
				Student student = studentService.read(user.getId());
				parent.out.println(student.toString());
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(family) {
			for(UserFamily family : userService.readAll(user.getId())) {
				parent.out.println(family.toString());
			};
			return;
		}
		
		if(disabilty) {
			UserDisability disability = infoService.read(user.getId());
			parent.out.println(disability.toString());
			return;
		}
		
		if(sodier) {
			UserSoldier sodier = infoService.sread(user.getId());
			parent.out.println(sodier.toString());
			return;
		}
		
		if(professor) {
			if(auth.hasProfessorPermission()) {
				Professor professor = professorService.read(user.getId());
				parent.out.println(professor.toString());
				return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(lecture) {
			Lecture lecture = lectureService.read(code);
				parent.out.println(lecture.toString());
			return;
		}
		
		if(lecturehistory) {
			if(auth.hasStudentPermission()) {
				for(LectureHistory lecturehistory : lectureService.hread(user.getId())) {
					parent.out.println(lecturehistory.toString2());
				}
			return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(lecturehistoryAll) {
			if(auth.hasProfessorPermission()) {
				for(LectureHistory lecturehistory : lectureService.readAll3()) {
					parent.out.println(lecturehistory.toString());
				}
			return;
			}
			else {
				parent.out.println("it's denied");
				return;
			}
		}
		
		if(lectureAttendance) {
			if(auth.hasStudentPermission()) {
				for(LectureAttendance lecture : lectureService.readAll2(user.getId())) {
					parent.out.println(lecture.toString());
				}
			return;
			} else {
				parent.out.println("It's denied");
				return;
			}
		}
		
		if(lectureAttendanceSelect) {
			if(auth.hasStudentPermission()) {
				for(LectureAttendance lecture : lectureService.check(user.getId(), code)) {
					parent.out.println(lecture.toString());
				}
			return;
			} else {
				parent.out.println("It's denied");
				return;
			}
		}
		
		if(lectureAttendanceAll) {
			if(auth.hasProfessorPermission()) {
				for(LectureAttendance lecture : lectureService.readAll4()) {
					parent.out.println(lecture.toString());
				}
			return;
			} else {
				parent.out.println("It's denied");
				return;
			}
		}
		
		if(lectureAll) {
			if(auth.hasProfessorPermission()) {
				for(Lecture lecture : lectureService.readAll(user.getId())) {
					parent.out.println(lecture.toString());
				}
			return;
			}
			else {
				parent.out.println("It's denied");
				return;
			}
		}
		
		parent.out.println(users.toString());
	}
}
