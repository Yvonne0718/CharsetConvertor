/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017年8月22日 下午5:06:12
 * @version 1.0
 *
 */
public class HiveListener implements ActionListener{
//    private ConvertorFrame frame;
    private ConvertController converController;
    private JCheckBox box;
    
    public HiveListener(Object box){
//        this.frame = (ConvertorFrame) frame;
        this.box = (JCheckBox) box;
        this.converController = ConvertController.getInstence();
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.converController.setHive(this.box.isSelected());
    }
}
