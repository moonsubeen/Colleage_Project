package college_management.my.gui.layout.professor.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class ProfessorUserLayout extends JPanel{
	private LayoutManager layout;
	private LecView userInfo;
	private LecView professorInfo;
//	private ImageIcon icon;
	private JButton pictureBtn;
	private JButton loadBtn;
	private JButton updateBtn;
	private JLabel picture = new JLabel();
	
	public ProfessorUserLayout(){
//		Image img = (new ImageIcon("src/resource/new_user.png")).getImage().getScaledInstance(50, 50,
//				Image.SCALE_SMOOTH);
//		icon = new ImageIcon(img);
		
		userInfo = new ProfessorUserInfoView();
		userInfo.setPreferredSize(new Dimension(400, 400));
		
		professorInfo = new ProfessorInfoView();
		professorInfo.setPreferredSize(new Dimension(400, 400));
		
		pictureBtn = (new JButton("사진 업로드"));
		pictureBtn.setPreferredSize(new Dimension(200, 30));
		
		loadBtn = (new JButton("사용자 정보 새로고침"));
		loadBtn.setPreferredSize(new Dimension(200, 30));

		updateBtn = (new JButton("사용자 정보 수정하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));
		
//		picture.setIcon(icon);
		picture.setPreferredSize(new Dimension(100, 100));
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(userInfo, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(picture, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(professorInfo, c);
		
		c.gridx = 1;
		c.gridy = 3;
		add(pictureBtn, c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public LecView getUserInfo() {
		return userInfo;
	}

	public LecView getProfessorInfo() {
		return professorInfo;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}
	
	public JButton getUpdateBtn() {
		return updateBtn;
	}
	
	public JButton getPictureeBtn() {
		return pictureBtn;
	}

	public JLabel getPicture() {
		return picture;
	}
}
