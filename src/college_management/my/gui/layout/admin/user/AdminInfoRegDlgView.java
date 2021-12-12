package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import college_management.my.gui.layout.common.LecView;

public class AdminInfoRegDlgView extends LecView{
	String states[] = {"없음", "있음", "해당사항 아님"};
	private JComboBox<String> state = new JComboBox<String>(states);
	
	public AdminInfoRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
	}

	@Override
	public void setData(Object model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

}
