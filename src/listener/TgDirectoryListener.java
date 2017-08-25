/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 上午9:39:36
 * @version 1.0
 *
 */
public class TgDirectoryListener implements FocusListener,ActionListener{
    private JTextField field;
//    private ConvertorFrame frame;
    private ConvertController converController;
    public TgDirectoryListener(Object field){
//        this.frame = (ConvertorFrame) frame;
        this.field = (JTextField) field;
        this.converController = ConvertController.getInstence();
    }
    
    /* 
     * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
     */
    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub

    }

    /* 
     * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
     */
    @Override
    public void focusLost(FocusEvent e) {
        this.checkTgdir();
    }
    
    public void checkTgdir() {
        if (!this.field.getText().equals(this.converController.tgdir_temp)) {
            this.converController.tgdir_temp = this.field.getText();
            this.converController.setTempFile(this.field.getText());
        }
    }

    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
    }

}
