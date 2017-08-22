package config.base;

public class PanelConfig extends BaseComponentConfig{

	private String align;
	
	public PanelConfig(String id, String classname, int x, int y, int width, int height,String align) {
		super(id, classname, x, y, width, height);
		this.align = align;
	}

	public String getAlign() {
		return align;
	}
	
	
}
