/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package config;

import java.util.List;

/**
 *
 *
 * @author Lee
 * @date 2017年8月24日 下午5:17:00
 * @version 1.0
 *
 */
public class BaseConfig {
    private String id;
    private List<String> refs;
    private String classname;
    
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname the classname to set
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * @return the refs
     */
    public List<String> getRefs() {
        return refs;
    }

    /**
     * @param refs the refs to set
     */
    public void setRefs(List<String> refs) {
        this.refs = refs;
    }
    
    
}
