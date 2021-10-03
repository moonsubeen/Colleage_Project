package college_management.my.gui.component.professor.attendance;

import java.util.List;

import college_management.my.db.model.LectureAttendance;
import college_management.my.gui.layout.common.TableAdapter;

@SuppressWarnings("serial")
public class AttendanceListTableAdpater extends TableAdapter{
	private final String[] header = { "강의제목", "학생학번", "학생이름", "월", "요일"};

	// 내용
	private List<LectureAttendance> data;

	public AttendanceListTableAdpater(List<LectureAttendance> data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public String getColumnName(int col) {
		return header[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return data.get(rowIndex).getLecture().getName();
		case 1:
			return data.get(rowIndex).getStudent().getUser().getId();
		case 2:
			return data.get(rowIndex).getStudent().getUser().getName();
		case 3:
			return data.get(rowIndex).getMonth();
		case 4:
			return data.get(rowIndex).getDay();
		default:
			return "default";
		}
	}

	@Override
	public LectureAttendance getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
