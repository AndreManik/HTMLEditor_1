package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Andre on 24.06.2017.
 */
public class TabbedPaneChangeListener implements ChangeListener {

    private View view;

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }

    public TabbedPaneChangeListener(View view){
        this.view = view;
    }
}
