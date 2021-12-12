package college_management.my.gui.layout.student.info;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentInfoLayout extends JPanel{
	private LayoutManager layout;

	private LecView soldierInfo;
	private LecView disabilityInfo;
	private LecView familyInfo;
	
	private JButton loadBtn;
	private JButton updateBtn;
	
	public StudentInfoLayout(){
		soldierInfo = new StudentSoldierInfoView();
		soldierInfo.setPreferredSize(new Dimension(400, 400));
		
		disabilityInfo = new StudentDisabilityInfoView();
		disabilityInfo.setPreferredSize(new Dimension(400, 400));
		
		familyInfo = new StudentFamilyInfoView();
		familyInfo.setPreferredSize(new Dimension(400, 100));
		
		loadBtn = (new JButton("사용자 정보 새로고침"));
		loadBtn.setPreferredSize(new Dimension(200, 30));

		updateBtn = (new JButton("사용자 정보 수정하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(soldierInfo, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(disabilityInfo, c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);

		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);
		
		c.gridheight = 3;
		c.gridx = 0;
		c.gridy = 1;
		add(familyInfo, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public LecView getSoldierInfo() {
		return soldierInfo;
	}
	
	public LecView getDisabilityInfo() {
		return disabilityInfo;
	}
	
	public LecView getFamilyInfo() {
		return familyInfo;
	}
	
	public JButton getLoadBtn() {
		return loadBtn;
	}
	
	public JButton getUpdateBtn() {
		return updateBtn;
	}
}
