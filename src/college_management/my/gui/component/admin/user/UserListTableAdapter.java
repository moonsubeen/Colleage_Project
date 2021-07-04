package college_management.my.gui.component.admin.user;

import java.util.List;

import college_management.my.db.model.User;
import college_management.my.gui.layout.common.TableAdapter;

@SuppressWarnings("serial")
public class UserListTableAdapter extends TableAdapter{
	// 제목
		private final String[] header = { "아이디", "이름", "역활" };

		// 내용
		private List<User> data;

		public UserListTableAdapter(List<User> data) {
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
				return data.get(rowIndex).getId();
			case 1:
				return data.get(rowIndex).getName();
			case 2:
				return data.get(rowIndex).getRole();
			default:
				return "default";
			}
		}

		@Override
		public Object getRow(int rowIndex) {
			return data.get(rowIndex);
		}
}
