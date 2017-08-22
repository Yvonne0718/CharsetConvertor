package config.base;


public class ComponentConfig {
	private String id;
	private String classname;
	private int x;
	private int y;
	private int width;
	private int height;
	private String text;
	private int align;
	
	
	public ComponentConfig(String id,String classname,int x,int y,int width,int height,String text,int align){
		this.id = id;
		this.classname = classname;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.align = align;
	}

	public String getId() {
		return id;
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

	public String getText() {
		return text;
	}

	public int getAlign() {
		return align;
	}
	
	
	
}
