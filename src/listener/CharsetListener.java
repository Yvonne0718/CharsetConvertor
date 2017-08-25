/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import controller.ConvertController;
import ui.ConvertorFrame;

/**
 *
 *
 * @author Lee
 * @date 2017年8月22日 下午5:05:54
 * @version 1.0
 *
 */
public class CharsetListener implements ActionListener {

    private JComboBox combobox;
//    private ConvertorFrame frame;
    private ConvertController converController;
    /**
     * 
     */
    public CharsetListener(Object combobox) {
        this.combobox = (JComboBox) combobox;
//        this.frame = (ConvertorFrame) frame;
        this.converController = ConvertController.getInstence();
    }
    /* 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.converController.setTgEncoding((String)this.combobox.getSelectedItem());
    }

}
