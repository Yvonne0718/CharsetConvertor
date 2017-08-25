package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import ui.ConvertorBoot;

public class PanelConfig extends BaseUIConfig{
    private String align;
//    private List<LabelConfig> labelsConfig;
//    private List<BoxConfig> boxsConfig;
//	private List<ButtonConfig> buttonsConfig;
//	private List<TextFieldConfig> textFieldsConfig;
//    private Map<String,ComponentConfig> componentConfig;
    private List<String> componentsID = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
    public PanelConfig(Element panel) {
	    super(panel);
	    this.align = panel.attributeValue("align");
	    List<Element> components = panel.elements("JComponent");
	    for(Element i : components){
	        String id = i.attributeValue("id");
	        ComponentConfig config = new ComponentConfig(i);
//	        componentConfig.put(id, config);
	        this.componentsID.add(id);
	        ConvertorBoot.configContainer.put(id, config);
	    }
//	    List<Element> labels = panel.elements("JLabel");
//	    List<Element> buttons = panel.elements("JButton");
//	    List<Element> testFields = panel.elements("JTextField");
//	    List<Element> boxs = panel.elements("JBox");
//	    for(Element i:labels){
//	        labelsConfig.add(new LabelConfig(i));
//	    }
//	    for(Element i:buttons){
//	        buttonsConfig.add(new ButtonConfig(i));
//	    }
//	    for(Element i:testFields){
//	        textFieldsConfig.add(new TextFieldConfig(i));
//	    }
//	    for(Element i:boxs){
//	        boxsConfig.add(new BoxConfig(i));
//	    }
	}

	public String getAlign() {
		return align;
	}

    /**
     * @return the componentsID
     */
    public List<String> getComponentsID() {
        return componentsID;
    }



	
	
//
//    /**
//     * @return the labelsConfig
//     */
//    public List<LabelConfig> getLabelsConfig() {
//        return labelsConfig;
//    }
//
//    /**
//     * @return the boxsConfig
//     */
//    public List<BoxConfig> getBoxsConfig() {
//        return boxsConfig;
//    }
//
//    /**
//     * @return the buttonsConfig
//     */
//    public List<ButtonConfig> getButtonsConfig() {
//        return buttonsConfig;
//    }
//
//    /**
//     * @return the textFieldsConfig
//     */
//    public List<TextFieldConfig> getTextFieldsConfig() {
//        return textFieldsConfig;
//    }
//	
	
	
	
}
