package college_management.my.gui.component.student.history;

import java.util.List;

import college_management.my.db.model.LectureHistory;
import college_management.my.gui.layout.common.TableAdapter;

@SuppressWarnings("serial")
public class HistotyListTableAdpater extends TableAdapter{
	private final String[] header = { "강의코드","강의제목", "학생학번", "학생이름"};

	// 내용
	private List<LectureHistory> data;

	public HistotyListTableAdpater(List<LectureHistory> data) {
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
			return data.get(rowIndex).getLecture().getCode();
		case 1:
			return data.get(rowIndex).getLecture().getName();
		case 2:
			return data.get(rowIndex).getStudent().getUser().getId();
		case 3:
			return data.get(rowIndex).getStudent().getUser().getName();
		default:
			return "default";
		}
	}

	@Override
	public LectureHistory getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}	
