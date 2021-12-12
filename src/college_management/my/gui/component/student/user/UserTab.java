package college_management.my.gui.component.student.user;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;
import college_management.my.gui.layout.common.LecView;
import college_management.my.gui.layout.student.user.StudentUserLayout;

@SuppressWarnings("serial")
public class UserTab extends LecPanel{
	private LecView userInfo;
	private LecView studentInfo;
	private String src2;
	private JLabel picture = new JLabel();
	
	public UserTab(MainGUI frame) {
		super(frame);

		// set layout
		StudentUserLayout layout = new StudentUserLayout();
		add(layout);

		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton pictureBtn = layout.getPictureeBtn();
		JButton saveBtn = layout.getSaveBtn();
		picture = layout.getPicture();
		
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		pictureBtn.addActionListener(pictureListener);
		saveBtn.addActionListener(saveListener);
		
		// set info
		userInfo = layout.getUserInfo();
		studentInfo = layout.getStudentInfo();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Student student = studentService.read(auth.getUser().getId());
			studentInfo.setData(student);

			User user = userService.read(auth.getUser().getId());
			userInfo.setData(user);
			
			try {
				Image Image = ImageIO.read(new File("C:\\Users\\zx040\\eclipse-workspace\\College_Project\\src\\resource\\" + user.getId() + ".png"));
				Image im = Image.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
				ImageIcon ic = new ImageIcon(im);
				picture.setIcon(ic);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void load() {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("파일 불러오기");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "png", "jpg", "gif");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
        int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
        if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
            try{
            	String src = fileChooser.getSelectedFile().toString();        	
            	loadimage(src);
            	showpicture(src);
            	showMessageBox("사진 업로드");
            	System.out.println(src);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
        	showMessageBox("취소");
        }
	}
	
	private void save() {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("파일 저장하기");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "png", "jpg", "gif");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
        fileChooser.setCurrentDirectory(new File("C:\\Users\\zx040\\eclipse-workspace\\College_Project\\src\\resource"));
        int returnVal = fileChooser.showSaveDialog(this); // show openDialog
        if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
            try{
            	String src = fileChooser.getSelectedFile().toString();
            	System.out.println(src);
            	bufferedsave(src);
            	showMessageBox("사진 저장");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
        	showMessageBox("취소");
        }
	}
	
	private void showpicture(String src) throws Exception {
		try {
			Image Image = ImageIO.read(new File(src));
			Image im = Image.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(im);
			picture.setIcon(ic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void bufferedsave(String src) throws IOException {
		try{
			Image Image = ImageIO.read(new File(src2));
			Image reImage = Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIO.write(convertToBufferedImage(reImage), "png", new File(src));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }

	
	private void loadimage(String path) throws Exception {
		File infile = new File(path);
		src2 = infile.getPath();
	}
	
	private ActionListener pictureListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			load();
		}
	};
	
	private ActionListener saveListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			save();
		}
	};
	
	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showMessageBox("목록 새로고침 완료");
			refresh();
		}
	};
	
	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) userInfo.getData();
			if (userService.update(user.getId(), user.getPwd(), user.getName(), user.getEmail(), user.getAddress(), user.getPhoneNumber())) {
				showMessageBox("업데이트 성공");
				refresh();
			}
		}
	};
}
