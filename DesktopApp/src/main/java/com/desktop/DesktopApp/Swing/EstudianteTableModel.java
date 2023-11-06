package com.desktop.DesktopApp.Swing;

import com.desktop.DesktopApp.Entity.EstudianteEntity;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EstudianteTableModel extends DefaultTableModel {
    private String[] columnNames = {"DNI", "Nombre", "Email", "Fecha de nacimiento"};

    public EstudianteTableModel() {
        this.setColumnIdentifiers(columnNames);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
