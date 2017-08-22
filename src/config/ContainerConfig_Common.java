package config;

import java.util.List;

import org.dom4j.Element;

import config.base.ComponentConfig;

public class ContainerConfig_Common {
	private List<ComponentConfig> componentConfigList;

	@SuppressWarnings("unchecked")
	public ContainerConfig_Common(Element common) {
		List<Element> components = common.selectNodes("./JComponent");
		for(Element component : components){
			ComponentConfig cc = new ComponentConfig(
					component.attributeValue("id"),
					component.attributeValue("class"),
					Integer.parseInt(component.attributeValue("x")),
					Integer.parseInt(component.attributeValue("y")),
					Integer.parseInt(component.attributeValue("width")),
					Integer.parseInt(component.attributeValue("height")),
					component.attributeValue("text"),
					Integer.parseInt(component.attributeValue("align"))
					);
			this.componentConfigList.add(cc);
		}
	}

	public List<ComponentConfig> getComponentConfigList() {
		return componentConfigList;
	}
	
	
	
	
}
