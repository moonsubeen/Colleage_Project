package college_management.my.GUI.layout.common;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class View extends JPanel{
	abstract public void setData(Object model);
	abstract public Object getData();
}
