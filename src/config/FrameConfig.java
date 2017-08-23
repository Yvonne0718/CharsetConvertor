package config;

import java.util.List;

import org.dom4j.Element;

public class FrameConfig extends BaseUIConfig {
	private String title;
	private String frameIcon;
	private List<PanelConfig> panelsConfig;
	
	@SuppressWarnings("unchecked")
	public FrameConfig(Element frame) {
		super(frame);
		this.title = frame.attributeValue("title");
		this.frameIcon = frame.attributeValue("frameIcon");
		
		List<Element> panelelements = frame.elements("panel");
		for(Element panel : panelelements){
			PanelConfig single = new PanelConfig(panel);
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
