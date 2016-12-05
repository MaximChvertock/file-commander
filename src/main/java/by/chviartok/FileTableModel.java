package by.chviartok;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * mad
 * 5.12.16.
 */
public class FileTableModel implements TableModel {
    private String columnNames[] = {"Name", "Type", "Size", "Data"};

    private List<File> files = new ArrayList<File>();

    private File current;

    public FileTableModel(File current) {
        setCurrent(current);
    }

    public File getCurrent() {
        return current;
    }

    public void setCurrent(File current) {
        if (!current.isDirectory()) {
            return;
        }

        this.current = current;
        files.clear();
        files.add(0, this.current.getParentFile());

        final List<File> filesFromDirectory = Arrays.asList(this.current.listFiles());

        filesFromDirectory.sort((left, right) -> {
            if(left.isDirectory() && right.isDirectory()){
                return left.getName().compareToIgnoreCase(right.getName());
            } else if(left.isDirectory()){
                return -1;
            } else if(right.isDirectory()){
                return 1;
            }

            return left.getName().compareToIgnoreCase(right.getName());
        });

        files.addAll(filesFromDirectory);
    }

    public File getFileAt(int rowIndex) {
        return files.get(rowIndex);
    }

    public int getRowCount() {
        return files.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex == 0){
            if(columnIndex == 0){
                return "..";
            } else {
                return "";
            }
        }

        switch (columnIndex) {
            case 0:
                return files.get(rowIndex).getName();
            case 1:
                return (files.get(rowIndex).isDirectory() ? "DIR" : "file");
            case 2:
                return files.get(rowIndex).length();
            case 3:
                return files.get(rowIndex).lastModified();
        }

        return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException();
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {

    }
}

