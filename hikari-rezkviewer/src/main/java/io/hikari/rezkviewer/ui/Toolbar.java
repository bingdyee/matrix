package io.hikari.rezkviewer.ui;

import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class Toolbar extends JToolBar {

    private JButton connectBtn;
    private JButton gitBtn;
    private JButton reportBtn;
    private JButton settingsBtn;

    public Toolbar() {
        initComponents();
    }

    public void initComponents() {
        addSeparator(new Dimension(12, 0));
        connectBtn = ComponentFactory.createButtonWithIcon("New Connection ", "connect.png", "New connection");
        add(connectBtn);
        connectBtn.setFont(new Font("Courier", Font.PLAIN, 18));
        addSeparator(new Dimension(12, 0));

        gitBtn = ComponentFactory.createButtonWithIcon(null, "github.png", "Star on GitHub");
        ComponentFactory.addHrefEvent(gitBtn, "https://github.com/fetaxyu/hikari");
        add(gitBtn);
        addSeparator(new Dimension(12, 0));

        reportBtn = ComponentFactory.createButtonWithIcon(null, "report.png", "Report issue");
        ComponentFactory.addHrefEvent(reportBtn, "https://github.com/fetaxyu/hikari/issues");
        add(reportBtn);
        addSeparator(new Dimension(12, 0));

        settingsBtn = ComponentFactory.createButtonWithIcon(null, "settings.png", "Settings");
        add(settingsBtn);

        this.setFloatable(false);
    }

}
