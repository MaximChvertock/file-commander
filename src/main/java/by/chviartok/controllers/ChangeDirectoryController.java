package by.chviartok.controllers;

import by.chviartok.DoubleFileTablePanel;
import by.chviartok.FileTable;
import by.chviartok.FileTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by mchviartok on 7.12.16.
 */
@Component
public class ChangeDirectoryController extends MouseInputAdapter {

    @Override public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2) {
            final FileTable fileTable = (FileTable) e.getComponent();

            final int selectedRow = fileTable.getSelectedRow();
            final FileTableModel model = fileTable.getModel();
            final File file = model.getFileAt(selectedRow);

            if (file.isDirectory()) {
                model.setCurrent(file);

                fileTable.updateUI();
            }
        }
    }
}
