package config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import ui.ConvertorBoot;

public class ConfigFactory {
	private  String path = "/config.xml";
	private  SAXReader saxreader = new SAXReader();
	private static ConfigFactory factory = new ConfigFactory();
	private ConfigFactory(){}
	
	public static  ConfigFactory getInstance(){
		return factory;
	}
	
	private Element getRootElement(){
		Element root = null ;
		try {
			InputStream in = ConfigFactory.class.getResourceAsStream(path);
			Document doc = this.saxreader.read(new InputStreamReader(in,"UTF-8"));
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return root;
	}

//	private SAXReader getSaxreader() {
//		return saxreader;
//	}
	
	public String initUIConfig(){
	    Element frameElement = getRootElement().element("frame");
	    FrameConfig frameConfig = new FrameConfig(frameElement);
        String id = frameElement.attributeValue("id");
        ConvertorBoot.configContainer.put(id, frameConfig);
        return id;
	}
	
	@SuppressWarnings("unchecked")
    public void initListenerConfig(){
	    List<Element> listenersConfig = getRootElement().element("listeners").elements("listener");
	    for(Element single : listenersConfig){
	        ListenerConfig li = new ListenerConfig(single);
	        ConvertorBoot.configContainer.put(single.attributeValue("id"), li);
	        ConvertorBoot.listenersConfig.add(li);
	    }
	}
	
	
	
	
	
	

}
