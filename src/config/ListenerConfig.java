/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

/**
 *
 *
 * @author Lee
 * @date 2017年8月24日 下午5:16:15
 * @version 1.0
 *
 */
public class ListenerConfig extends BaseConfig{
    
    public ListenerConfig(Element element){
        this.setClassname(element.attributeValue("class"));
        this.setId(element.attributeValue("id"));
        Element params = element.element("params");
        if(params != null){
            List<Element> list = params.elements("param");
            if(list.size() != 0){
                List<String> refs = new ArrayList<String>();
                for(Element l: list){
                    refs.add(l.attributeValue("ref"));
                }
                this.setRefs(refs);
            }
        }
    }

}
