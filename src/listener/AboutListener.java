/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017��8��22�� ����4:48:15
 * @version 1.0
 *
 */
public class AboutListener implements ActionListener {
    
    private JMenuItem item;
    private ConvertorFrame frame;
    private ConvertController converController;

    public AboutListener(Object frame, Object item) {
            this.frame = (ConvertorFrame) frame;
            this.item = (JMenuItem) item;
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}

