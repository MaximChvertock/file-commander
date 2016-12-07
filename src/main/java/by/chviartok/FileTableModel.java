package by.chviartok;

import org.springframework.stereotype.Component;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * mad
 * 5.12.16.
 */
@Component
public class FileTableModel implements TableModel {

    private String columnNames[] = {"Name", "Type", "Size", "Data"};

    private List<File> fileList = new ArrayList<File>();

    private File current;

    public FileTableModel(String path) {
        setCurrent(new File(path));
    }

    public FileTableModel() {/*NOP*/}

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
        fileList.clear();
        addParentToFileList();

        final File[] files = current.listFiles();

        if (files != null && files.length > 0) {
            final List<File> filesFromDirectory = Arrays.asList(this.current.listFiles());

            filesFromDirectory.sort((left, right) -> {
                if (left.isDirectory() && right.isDirectory()) {
                    return left.getName().compareToIgnoreCase(right.getName());
                } else if (left.isDirectory()) {
                    return -1;
                } else if (right.isDirectory()) {
                    return 1;
                }

                return left.getName().compareToIgnoreCase(right.getName());
            });

            this.fileList.addAll(filesFromDirectory);
        }
    }

    private void addParentToFileList() {
        if (hasParent(current)) {
            fileList.add(0, current.getParentFile());
        }
    }

    private static boolean hasParent(File file) {
        if (file == null) {
            return false;
        }

        return file.getParentFile() != null;
    }

    public File getFileAt(int rowIndex) {
        return fileList.get(rowIndex);
    }

    public int getRowCount() {
        return fileList.size();
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
        if (hasParent(current)) {
            if (rowIndex == 0) {
                if (columnIndex == 0) {
                    return "..";
                } else {
                    return "";
                }
            }
        }

        switch (columnIndex) {
            case 0:
                return fileList.get(rowIndex).getName();
            case 1:
                return (fileList.get(rowIndex).isDirectory() ? "DIR" : "file");
            case 2:
                return fileList.get(rowIndex).length();
            case 3:
                return fileList.get(rowIndex).lastModified();
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

