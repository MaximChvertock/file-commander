package by.chviartok;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

/**
 * mad
 * 5.12.16.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
//        System.out.println(Arrays.toString(installedLookAndFeels));

        UIManager.setLookAndFeel(installedLookAndFeels[3].getClassName());

//        new FileCommander();

    }
}
