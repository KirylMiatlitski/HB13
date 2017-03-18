package by.epam.course.basic.main;

import java.io.Serializable;

public class Lamp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String color;
	Lightbulb lightbulb;
	
	public Lamp(String name, String color, Lightbulb lightbulb) {
		this.name = name;
		this.color = color;
		this.lightbulb = lightbulb;
	}
	
	public void setNewLightbulb(Lightbulb light){
		lightbulb = light;
	}
	
	@Override
	public String toString() {
		return "Lamp:\nName: " + name +"\nColor: "+ color + "\nLightbulb: "+ lightbulb;
	}
}
