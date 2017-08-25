package config;

import org.dom4j.Element;

public class BaseUIConfig extends BaseConfig{
    
    private int x;
    private int y;
    private int width;
    private int height;

    public BaseUIConfig(Element element) {
        this.setClassname(element.attribute("class").getText());
        this.x = Integer.parseInt(element.attribute("x").getText());
        this.y = Integer.parseInt(element.attribute("y").getText());
        this.width = Integer.parseInt(element.attribute("width").getText());
        this.height = Integer.parseInt(element.attribute("height").getText());
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

}
