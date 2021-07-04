package college_management.my.gui.layout.common;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class TableAdapter extends AbstractTableModel {
	abstract public Object getRow(int rowIndex);
}
