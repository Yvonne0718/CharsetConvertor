/*
 * Copyright(C) 2013 Agree Corporation. All rights reserved.
 * 
 * Contributors:
 *     Agree Corporation - initial API and implementation
 */
package ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.UIManager;

import config.BaseConfig;
import config.ConfigFactory;
import config.FrameConfig;
import config.ListenerConfig;

/**
 *
 *
 * @author Lee
 * @date 2017年8月23日 下午2:29:17
 * @version 1.0
 *
 */
public class ConvertorBoot {
    public static Map<String,BaseConfig> configContainer = new HashMap<String, BaseConfig>();
    public static Map<String,Object> instanceContainer = new HashMap<String, Object>();
    public static List<ListenerConfig> listenersConfig = new ArrayList<ListenerConfig>();
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException{
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);

        } catch (Exception e) {

        }
        ConfigFactory factory = ConfigFactory.getInstance();
        String  frameid = factory.initUIConfig();
        factory.initListenerConfig();
         FrameConfig frameConfig = (FrameConfig) configContainer.remove(frameid);
        initInstance();
        setDependence();
        
        
//        frame.setBounds(frameConfig, y, width, height);s
    }
    
    private static void setDependence() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        List<String> listenerID = new ArrayList<String>();
        for(ListenerConfig config : listenersConfig){
            List<String> refs = config.getRefs();
            if(refs != null){
                Class<?> host = instanceContainer.get(config.getId()).getClass();
                Field[] fields = host.getDeclaredFields();
                for(String id : refs){
                    Object ref = instanceContainer.get(id);
                    for(Field f : fields){
                        if(f.getType().equals(ref.getClass())){
                            String name = f.getName();
                            String setMethodName = getSetMethodName(name);
                            Method set = host.getMethod(setMethodName, ref.getClass());
                            set.invoke(host, ref);
                            System.out.println("work");
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param name
     * @return
     */
    private static String getSetMethodName(String name) {
        String firstLetter = name.substring(0, 1);
        return firstLetter.toUpperCase()+name.substring(1, name.length());
    }

    private static void initInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
       Set<String> keyset = configContainer.keySet();
       Iterator<String> keys = keyset.iterator();
       while(keys.hasNext()){
           String key = keys.next();
           keys.remove();
           instanceContainer.put(key, Class.forName(configContainer.get(key).getClassname()).newInstance());
       }
   }

}
