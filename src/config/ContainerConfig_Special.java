package config;

import java.util.Map;

import org.dom4j.Element;

import config.base.Component_Special;

public class ContainerConfig_Special {
	
	Map<String,Component_Special> specialComponentMap;
	
	public ContainerConfig_Special(Element container) {
	}

	public Map<String, Component_Special> getSpecialComponentMap() {
		return specialComponentMap;
	}
	
	
	
	
}
