package college_management.my.GUI.component.common;

public class Activity {
	private String name;
	private ActivityPanel panel;

	public Activity(String name, ActivityPanel panel) {
		this.name = name;
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public ActivityPanel getPanel() {
		return panel;
	}

}
