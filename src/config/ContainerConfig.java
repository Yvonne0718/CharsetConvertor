package config;

import org.dom4j.Element;

public class ContainerConfig {
	private ContainerConfig_Common CommonContainerConfig; 
	
	private ContainerConfig_Special SpecialContainerConfig;
	
	
	public ContainerConfig(Element container) {
		Element commonContainer = container.element("CommonContainer");
		Element specialContainer = container.element("SpecialContainer");
		this.CommonContainerConfig = new ContainerConfig_Common(commonContainer);
		this.SpecialContainerConfig = new ContainerConfig_Special(specialContainer);
		
	}


	public ContainerConfig_Common getCommonContainerConfig() {
		return CommonContainerConfig;
	}


	public ContainerConfig_Special getSpecialContainerConfig() {
		return SpecialContainerConfig;
	}


	
	
	
	
	
	
	
	
}
