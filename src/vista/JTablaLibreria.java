package vista;

import javax.swing.JTable;

public class JTablaLibreria extends JTable{

	/**
	 * Creo esta tabla especial que no podrá ser editada, pero que contendrá todas las características de JTable
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}


}
