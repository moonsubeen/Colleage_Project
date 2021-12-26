package college_management.my.gui.component.student.info;

import java.awt.Graphics;

import javax.swing.JButton;

import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserFamily;
import college_management.my.db.model.UserSoldier;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.info.StudentInfoLayout;

public class InfoTab extends LecPanel{
	private LecView soldierInfo;
	private LecView disabilityInfo;
	private LecView familyInfo;
	
	private StudentInfoLayout layout;
	
	public InfoTab(MainGUI frame) {
		super(frame);
		layout = new StudentInfoLayout();
		add(layout);
		
		initLayout();
	}
	
	public void initLayout() {
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		
		soldierInfo = layout.getSoldierInfo();
		disabilityInfo = layout.getDisabilityInfo();
		familyInfo = layout.getFamilyInfo();	
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
			
			UserDisability dis = infoService.read(auth.getUser().getId());
			disabilityInfo.setData(dis);
			
			UserFamily family = userService.fread(auth.getUser().getId());
			familyInfo.setData(family);
		}
	}
}
