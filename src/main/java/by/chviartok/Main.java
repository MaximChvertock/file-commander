package by.chviartok;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

/**
 * mad
 * 5.12.16.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();

        UIManager.setLookAndFeel(installedLookAndFeels[3].getClassName());
//        System.out.println(Arrays.toString(installedLookAndFeels));

        new FileCommander();
    }
}
