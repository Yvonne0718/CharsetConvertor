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
 * @date 2017年8月23日 上午10:13:49
 * @version 1.0
 *
 */
public class LabelConfig extends BaseUIConfig {

    private String text;
    private String align;
    /**
     * @param element
     */
    public LabelConfig(Element element) {
        super(element);
        this.text = element.attributeValue("text");
        this.align = element.attributeValue("align");
    }
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
    /**
     * @return the align
     */
    public String getAlign() {
        return align;
    }

    
}
