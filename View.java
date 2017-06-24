package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andre on 21.06.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;

    //initialization windows/tabs/panels
    private JTabbedPane tabbedPane = new JTabbedPane();     //tabs
    private JTextPane htmlTextPane = new JTextPane();       //textWindow
    private JEditorPane plainTextPane = new JEditorPane();  //editorPanel

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void init(){}
    public void exit(){
        controller.exit();
    }
}
