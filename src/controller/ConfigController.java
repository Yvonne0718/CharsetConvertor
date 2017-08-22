package controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import config.ContainerConfig;
import config.FrameConfig;

public class ConfigController {
	private static String path = "/config.xml";
	private static FrameConfig  FRAME_CONFIG;
	private static ContainerConfig CONTAINER_CONFIG;
	static{
		SAXReader saxReader = new SAXReader();
		try{
			Document doc = saxReader.read(ConfigController.class.getResourceAsStream(path));
			Element root = doc.getRootElement();
			Element frame = root.element("frame");
			Element container = root.element("Container");
			FRAME_CONFIG = new FrameConfig(frame);
			CONTAINER_CONFIG = new ContainerConfig(container);
		}catch(DocumentException e){
			e.printStackTrace();
		}
	}
	
	private ConfigController(){}

	public static FrameConfig getFRAME_CONFIG() {
		return FRAME_CONFIG;
	}

	public static ContainerConfig getCONTAINER_CONFIG() {
		return CONTAINER_CONFIG;
	}
	
	
}
