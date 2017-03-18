package by.epam.course.basic.main;

import java.io.Serializable;

public class Table implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	Lamp lamp1;
	Lamp lamp2;
	public Table() {
		lamp1= new Lamp("Default", "Default", new Lightbulb(100));
		lamp2= new Lamp("Default", "Default", new Lightbulb(100));		
	}
	
	public void setLamp1(Lamp lamp){
		lamp1 = lamp;
	}
	public void setLamp2(Lamp lamp){
		lamp2 = lamp;
	}
	
	@Override
	public String toString() {
		return "Стол с двумя лампами: \n"+lamp1+"\n"+lamp2+"\n=============="; 
	}
	
}
