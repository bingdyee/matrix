package io.hikari.rezkviewer.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class ComponentFactory {

    public static final String ICONS_PATH = "icons/";

    public static JButton createButtonWithIcon(String text, String path, String tip) {
        URL url = ComponentFactory.class.getClassLoader().getResource(ICONS_PATH + path);
        JButton button = new JButton(text, new ImageIcon(url));
        button.setToolTipText(tip);
        button.setFocusPainted(false);
        return button;
    }

    public static void addHrefEvent(JButton btn, String href) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("explorer " + href);
                } catch (Exception ignored) {}
            }
        });
    }

}
