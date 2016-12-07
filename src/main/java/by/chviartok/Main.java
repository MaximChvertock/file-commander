package by.chviartok;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;

/**
 * mad
 * 5.12.16.
 */
public class Main {

    private static final String CONFIG_PATH = "classpath*:application-config.xml";

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel(installedLookAndFeels[3].getClassName());

        final ApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_PATH);
        final FileCommander fileCommander =
                context.getBean(FileCommander.class);

        fileCommander.run();
    }
}
