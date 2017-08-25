package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import ui.ConvertorBoot;

public class FrameConfig extends BaseUIConfig {
    private String title;
    private String frameIcon;
//    private Map<String, PanelConfig> panelsConfig;
    private List<String> panelsID = new ArrayList<String>();

    @SuppressWarnings("unchecked")
    public FrameConfig(Element frame) {
        super(frame);
        this.title = frame.attributeValue("title");
        this.frameIcon = frame.attributeValue("frameIcon");
        List<Element> panelelements = frame.elements("panel");
        for (Element panel : panelelements) {
            String id = panel.attributeValue("id");
            PanelConfig single = new PanelConfig(panel);
//            this.panelsConfig.put(id, single);
            this.panelsID.add(id);
            ConvertorBoot.configContainer.put(id, single);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getFrameIcon() {
        return frameIcon;
    }

    public List<String> getPanelsID() {
        return panelsID;
    }
}
