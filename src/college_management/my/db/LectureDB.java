package college_management.my.db;

public class LectureDB extends BaseDB{
	private static LectureDB instance;
	
	public static LectureDB getInstance() {
		if (instance == null) {
			instance = new LectureDB();
		}
		return instance;
	}
	
	public boolean Lregister() {
		return true;
	}
}
