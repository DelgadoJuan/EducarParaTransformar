package com.desktop.DesktopApp.Swing;

import javax.swing.table.DefaultTableModel;

public class BoletinTableModel extends DefaultTableModel {
    private String[] columnNames = {"Materia", "Calificaciones"};

    public BoletinTableModel() {
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
