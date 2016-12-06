package by.chviartok;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * mad
 * 6.12.16.
 */
@Component
public class FileCommander extends JFrame {

    @Autowired
    private DoubleFileTablePanel filePanel;

    public void run(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        getContentPane().add(filePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
