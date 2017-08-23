/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package ui;

import java.awt.Frame;

import javax.swing.UIManager;

import config.ConfigFactory;
import config.FrameConfig;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 下午2:29:17
 * @version 1.0
 *
 */
public class ConvertorBoot {
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);

        } catch (Exception e) {

        }
        FrameConfig frameConfig = ConfigFactory.getInstance().getFrameConfig();
        Frame frame = (Frame) Class.forName(frameConfig.getClassname()).newInstance();
//        frame.setBounds(frameConfig, y, width, height);s
    
    }

}
