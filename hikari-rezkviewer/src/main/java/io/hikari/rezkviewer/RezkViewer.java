package io.hikari.rezkviewer;

import io.hikari.rezkviewer.ui.ZkViewerPanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.FontUIResource;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Enumeration;

/**
 * Redis & Zookeeper Viewer
 *
 *
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class RezkViewer {

    public static void main(String[] args) {
        try {
            Font font = new Font("Courier", Font.PLAIN,16);
            FontUIResource fontRes = new FontUIResource(font);
            Enumeration<Object> keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if(value instanceof FontUIResource) {
                    UIManager.put(key, fontRes);
                }
            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Redis & Zookeeper Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            final ZkViewerPanel viewer = new ZkViewerPanel();
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                }
            });
            frame.setContentPane(viewer);
            frame.setSize(1024, 768);
            frame.setLocationRelativeTo(null);
            URL url = RezkViewer.class.getClassLoader().getResource("icons/icon.png");
            frame.setIconImage(new ImageIcon(url).getImage());
            frame.setVisible(true);
        });
    }

}
