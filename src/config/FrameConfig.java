package config;

import java.util.List;

import org.dom4j.Element;

import config.base.BaseComponentConfig;
import config.base.PanelConfig;

public class FrameConfig extends BaseComponentConfig {
	private String title;
	private String frameIcon;
	private List<PanelConfig> panelsConfig;
	
	@SuppressWarnings("unchecked")
	public FrameConfig(Element frame) {
		
		super(
				frame.attributeValue("id"),
				frame.attributeValue("classname"),
				Integer.parseInt(frame.attributeValue("x")),
				Integer.parseInt(frame.attributeValue("y")),
				Integer.parseInt(frame.attributeValue("width")),
				Integer.parseInt(frame.attributeValue("height"))
			  );
		
		this.title = frame.attributeValue("title");
		this.frameIcon = frame.attributeValue("frameIcon");
		
		List<Element> panelelements = frame.selectNodes("./panel");
		for(Element panel : panelelements){
			PanelConfig single = new PanelConfig(
					panel.attributeValue("id"),
					panel.attributeValue("classname"),
					Integer.parseInt(panel.attributeValue("x")),
					Integer.parseInt(panel.attributeValue("y")),
					Integer.parseInt(panel.attributeValue("width")),
					Integer.parseInt(panel.attributeValue("height")),
					panel.attributeValue("align")
					);
			this.panelsConfig.add(single);
		}
	}

	public String getTitle() {
		return title;
	}

	public String getFrameIcon() {
		return frameIcon;
	}

	public List<PanelConfig> getPanelsConfig() {
		return panelsConfig;
	}
	
	

}
