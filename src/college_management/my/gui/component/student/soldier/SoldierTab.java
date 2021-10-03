package college_management.my.gui.component.student.soldier;

import java.awt.Graphics;

import javax.swing.JButton;

import college_management.my.db.model.UserSoldier;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.info.StudentSoldierLayout;

public class SoldierTab extends LecPanel{
	private LecView soldierInfo;
	
	public SoldierTab(MainGUI frame) {
		super(frame);
		
		StudentSoldierLayout layout = new StudentSoldierLayout();
		add(layout);
		
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		
		soldierInfo = layout.getSoldierInfo();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}
	
	private void refresh() {
		if (auth.isLogin()) {
			UserSoldier soldier = infoService.sread(auth.getUser().getId());
			soldierInfo.setData(soldier);
		}
	}
}
