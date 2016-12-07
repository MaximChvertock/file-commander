package by.chviartok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.io.File;

/**
 * mad
 * 6.12.16.
 */
@Component
public class DoubleFileTablePanel extends JPanel {

    @Autowired
    @Qualifier("leftFileTable")
    private FileTable leftFileTable;

    @Autowired
    @Qualifier("rightFileTable")
    private FileTable rightFileTable;

    private final static int GAP_BETWEEN_PANELS = 5;

    @PostConstruct
    private void init(){
        final GridLayout gridLayout = new GridLayout(0,2);
        gridLayout.setHgap(GAP_BETWEEN_PANELS);
        setLayout(gridLayout);

        leftFileTable = new FileTable(new FileTableModel(new File("/bin")));
        final JScrollPane leftFileTableScrollPane = new JScrollPane(leftFileTable);

        rightFileTable = new FileTable(new FileTableModel(new File("/etc")));
        final JScrollPane rightFileTableScrollPane = new JScrollPane(rightFileTable);

        add(leftFileTableScrollPane);
        add(rightFileTableScrollPane);
    }

    public FileTable getLeftFileTable() {
        return leftFileTable;
    }

    public FileTable getRightFileTable() {
        return rightFileTable;
    }
}
