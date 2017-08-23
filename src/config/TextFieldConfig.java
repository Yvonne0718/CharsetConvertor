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
 * @date 2017��8��23�� ����10:26:56
 * @version 1.0
 *
 */
public class TextFieldConfig extends BaseUIConfig{

    private String listener;
    /**
     * @param element
     */
    public TextFieldConfig(Element element) {
        super(element);
        this.listener = element.attributeValue("listener");
    }
    
    public String getListener(){
        return listener;
    }

}
