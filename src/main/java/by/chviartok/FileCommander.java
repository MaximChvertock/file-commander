package by.chviartok;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * mad
 * 6.12.16.
 */
public class FileCommander {

    private JFrame frame;

    public FileCommander() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));

        // init UI
        DoubleFileTablePanel filePanel = new DoubleFileTablePanel();

        frame.getContentPane().add(filePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
