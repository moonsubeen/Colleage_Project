package college_management.my.gui.component.professor.user;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.professor.user.ProfessorUserLayout;

public class UserTab extends LecPanel{
	private LecView userInfo;
	private LecView professorInfo;
	private ImageIcon icon;
	private String src;
	
	public UserTab(MainGUI frame) {
		super(frame);
		
		src = "src/resource/new_user.png";
		
		// set layout
		ProfessorUserLayout layout = new ProfessorUserLayout();
		add(layout);
		loadpicture(src);
		
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton pictureBtn = layout.getPictureeBtn();
		JLabel picture = layout.getPicture();
		picture.setIcon(icon);
		
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		pictureBtn.addActionListener(pictureListener);
		
		// set info
		userInfo = layout.getUserInfo();
		professorInfo = layout.getProfessorInfo();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Professor professor = professorService.read(auth.getUser().getId());
			professorInfo.setData(professor);

			User user = userService.read(auth.getUser().getId());
			userInfo.setData(user);
		}
	}
	
	private void load() {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("파일 불러오기");
        fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "gif", "png")); // 파일필터
        fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
        int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
        if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
            try{
            	src = fileChooser.getSelectedFile().toString();
            	loadpicture(src);
            	System.out.println(fileChooser.getSelectedFile().toString());
            	showMessageBox("사진 업로드");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
        	showMessageBox("취소");
        }
	}
	
	private void loadpicture(String src) {
		Image img = (new ImageIcon(src)).getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
	}
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};	
	
	private ActionListener pictureListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			load();
		}
	};
	
	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) userInfo.getData();
//			Professor professor = (Propessor) professorInfo.getData();
			if (userService.update(user.getId(), user.getPwd(), user.getName(), user.getEmail(), user.getAddress(), user.getPhoneNumber())) {
				showMessageBox("업데이트 성공");
				refresh();
			}
		}
	};

}
