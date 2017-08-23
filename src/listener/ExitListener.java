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
 * @date 2017年8月22日 下午5:01:51
 * @version 1.0
 *
 */
public class ExitListener implements ActionListener{
    private JMenuItem item;
    private ConvertorFrame frame;
//    private ConvertController converController;
    
    public ExitListener(Object frame, JMenuItem item) {
        this.frame = (ConvertorFrame) frame;
        this.item = item;
//        this.converController = ConvertController.getInstence();
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);        
    }

}
