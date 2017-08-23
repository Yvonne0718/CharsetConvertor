package config.base;


public class BaseComponentConfig {
	private String id;
	private String classname;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public BaseComponentConfig(String id,String classname,int x,int y,int width,int height){
//		this.id = element.attributeValue("id");
//		this.classname = element.attributeValue("class");
//		this.x = Integer.parseInt(element.attributeValue("x"));
//		this.y = Integer.parseInt(element.attributeValue("y"));
//		this.width = Integer.parseInt(element.attributeValue("width"));
//		this.height = Integer.parseInt(element.attributeValue("height"));
		this.id = id;
		this.classname = classname;
		this.x = x;
		this.y = y;
		this.width = width	;
		this.height = height;
	}
	public String getClassname() {
		return classname;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getId() {
		return id;
	}
	
	
	
	
}
