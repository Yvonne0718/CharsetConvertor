/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017��8��22�� ����5:07:28
 * @version 1.0
 *
 */
public class QueryListener implements ActionListener{
//    private ConvertorFrame frame;
    private ConvertController converController;
//    private JButton button;
    
    /**
     * 
     */
    public QueryListener() {
//        this.frame = (ConvertorFrame) frame;
//        this.button = (JButton) button;
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
//        this.frame.checkAdtype();
//        this.frame.checkTgdir();
//        this.frame.checkTgtype();
        this.converController.query(true);        
    }

}
