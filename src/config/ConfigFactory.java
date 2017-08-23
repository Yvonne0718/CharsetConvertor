package config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ConfigFactory {
	private  String path = "/config.xml";
	private  SAXReader saxreader = new SAXReader();
	Document doc;
	private static ConfigFactory factory = new ConfigFactory();
	private ConfigFactory(){}
	
	public static  ConfigFactory getInstance(){
		return factory;
	}
	
	private Document getDocument(){
		
		try {
			InputStream in = ConfigFactory.class.getResourceAsStream(path);
			doc = this.saxreader.read(new InputStreamReader(in,"UTF-8"));
			 
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return doc;
	}

//	private SAXReader getSaxreader() {
//		return saxreader;
//	}
	
	public FrameConfig getFrameConfig(){
	    return  new FrameConfig(getDocument().getRootElement().element("Frame"));
	}
	
	
	
	
	
	

}
