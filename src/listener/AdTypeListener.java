/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 上午9:40:44
 * @version 1.0
 *
 */
public class AdTypeListener implements FocusListener {
    private JTextField field;
    private ConvertorFrame frame;
    private ConvertController converController;

    public AdTypeListener(Object frame,Object field){
        this.frame = (ConvertorFrame) frame;
        this.field = (JTextField) field;
        this.converController = ConvertController.getInstence();
    }
    /* 
     * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
     */
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    /* 
     * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
     */
    @Override
    public void focusLost(FocusEvent e) {
        this.checkAdtype();        
    }
    
    public void checkAdtype() {
        if (!this.field.getText().equals(this.converController.adtype_temp)) {
            this.converController.adtype_temp = this.field.getText();
            this.converController.setAdType(this.field.getText());
        }
    }

}
