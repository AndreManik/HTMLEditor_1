package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by Andre on 24.06.2017.
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction(){
        super(StyleConstants.Subscript.toString());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
