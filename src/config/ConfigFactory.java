package config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class UIConfigFactory {
	private String path = "/config.xml";
	private SAXReader saxreader = new SAXReader();
	Document doc;
	private static UIConfigFactory factory = new UIConfigFactory();
	private UIConfigFactory(){}
	
	public static  UIConfigFactory getUIConfigFactory(){
		return factory;
	}
	
	private Document getDocument(){
		
		try {
			InputStream in = this.getClass().getResourceAsStream(path);
			doc = this.saxreader.read(new InputStreamReader(in,"UTF-8"));
			 
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return doc;
	}

	private SAXReader getSaxreader() {
		return saxreader;
	}
	
	
	
	
	
	

}
