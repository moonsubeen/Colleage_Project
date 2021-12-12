package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import college_management.my.api.config.Permission;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminBaseFamilyRegDlgView extends LecView{
	private AdminFamilyRegDlgView family = new AdminFamilyRegDlgView();
	private String[] relation = {"부", "모", "형", "제", "자", "매"};
	private JComboBox<String> comboBox = new JComboBox<String>(relation);
	
	public AdminBaseFamilyRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
		
		changetoFamily();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addComboBoxPair(comboBox, "가족관계", row++);
		addView(family, row++);
	}

	private void addView(JComponent view, int row) {
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = row;
		add(view, c);
	}
	
	private void addComboBoxPair(JComboBox<String> comboBox, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		c.gridx = 1;
		c.gridy = row;
		add(comboBox, c);
	}
	
	@Override
	public void setData(Object model) {
		
	}

	@Override
	public Object getData() {
		return null;
	}

	public AdminFamilyRegDlgView getFamily() {
		return family;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
	public void changetoFamily() {
		family.setVisible(true);
	}
}
