package by.chviartok;

import javax.swing.JTable;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 * mad
 * 6.12.16.
 */
public class FileTable extends JTable {

    public FileTable(FileTableModel fileTableModel) {
        super(fileTableModel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if(e.getClickCount() > 1) {
                    final FileTableModel model = getModel();
                    final int selectedRow = getSelectedRow();

                    File file = model.getFileAt(selectedRow);

                    if(file != null) {
                        model.setCurrent(file);

                        updateUI();
                    }
//                }
            }
        });
    }

    public FileTableModel getModel() {
        return (FileTableModel) super.getModel();
    }
}
