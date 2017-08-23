/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package config;

import org.dom4j.Element;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 上午10:26:39
 * @version 1.0
 *
 */
public class ButtonConfig extends BaseUIConfig{
    private String text;
    private String listener;
    /**
     * @param element
     */
    public ButtonConfig(Element element) {
        super(element);
        this.text = element.attributeValue("text");
        this.listener = element.attributeValue("listener");
    }
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
    
    public String getListener() {
        return listener;
    }
    


}
