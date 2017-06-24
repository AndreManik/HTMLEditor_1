package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
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


    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void init(){
        initGui();//инициализация графического интерфейса. Реализация ниже
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void exit(){
        controller.exit();
    }

    public void initMenuBar() { //инициализация меню

        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);


    }
    public void initEditor() {  //инициализация окна редактирования
        htmlTextPane.setContentType("text/html"); //установка типа контента для окна

        //вкладка HTML
        JScrollPane textScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", textScrollPane);

        //вкладка Text
        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", plainScrollPane);

        //установка начального размера
        tabbedPane.setPreferredSize(new Dimension(300, 100));

        //создание слушателя переключения между вкладками представления и установка
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);

        //установка вкладок в центр окна можно и так: getContentPane().add(tabbedPane, BorderLayout.CENTER)
        Container container = getContentPane();
        container.add(tabbedPane, BorderLayout.CENTER);
    }
    public void initGui(){      //инициализация графического интерфейса
        initMenuBar();
        initEditor();
        pack(); //реализация унаследована от JFrame

    }

    public void selectedTabChanged(){}
}
