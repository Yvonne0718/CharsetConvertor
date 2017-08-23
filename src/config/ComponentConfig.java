/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package config;

import java.util.List;

import org.dom4j.Element;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 下午4:34:46
 * @version 1.0
 *
 */
public class ComponentConfig extends BaseUIConfig{
    private String text;
    private String align;
    private String listener;
    private List<ComponentConfig> groups;
    /**
     * @param element
     */
    @SuppressWarnings("unchecked")
    public ComponentConfig(Element element) {
        super(element);
        this.align = element.attributeValue("align");
        this.listener = element.attributeValue("listener");
        this.text = element.attributeValue("text");
        Element group;
        if((group = element.element("JComponent")) != null){
            List<Element> groupElement  = group.elements("JComponent");
            for(Element g : groupElement){
                groups.add(new ComponentConfig(g));
            }
            
        }
        
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
    /**
     * @return the listener
     */
    public String getListener() {
        return listener;
    }
    /**
     * @return the groups
     */
    public List<ComponentConfig> getGroups() {
        return groups;
    }
    
    
    
    

}
