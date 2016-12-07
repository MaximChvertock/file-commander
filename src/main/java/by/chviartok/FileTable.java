package by.chviartok;

import by.chviartok.controllers.ChangeDirectoryController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * mad
 * 6.12.16.
 */
public class FileTable extends JTable {

    public FileTable(FileTableModel fileTableModel) {
        super(fileTableModel);
    }

    public FileTableModel getModel() {
        return (FileTableModel) super.getModel();
    }

    @Autowired
    public void setChangeDirectoryController(ChangeDirectoryController controller) {
        addMouseListener(controller);
    }
}
