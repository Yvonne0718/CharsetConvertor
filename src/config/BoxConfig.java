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
 * @date 2017年8月23日 上午10:27:24
 * @version 1.0
 *
 */
public class BoxConfig extends BaseUIConfig{

    private String listener;
    /**
     * @param element
     */
    public BoxConfig(Element element) {
        super(element);
        this.listener = element.attributeValue("listener");
    }
    
    public String getListener(){
        return listener;
    }
}
