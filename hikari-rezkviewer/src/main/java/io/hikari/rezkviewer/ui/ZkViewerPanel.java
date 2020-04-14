package io.hikari.rezkviewer.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class ZkViewerPanel extends JPanel {

    private final Toolbar toolbar = new Toolbar();

    public ZkViewerPanel() {
        setLayout(new BorderLayout());
        this.add(toolbar, BorderLayout.NORTH);
    }

}
