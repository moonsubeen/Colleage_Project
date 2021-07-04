package college_management.my.gui.component.common;

public class Tab {
	private String name;
	private TabPanel panel;

	public Tab(String name, TabPanel panel) {
		this.name = name;
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public TabPanel getPanel() {
		return panel;
	}

}
