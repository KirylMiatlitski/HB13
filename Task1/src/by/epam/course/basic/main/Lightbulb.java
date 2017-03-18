package by.epam.course.basic.main;

import java.io.Serializable;

public class Lightbulb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public int power;
	
	public Lightbulb(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return power+"W";
	}
}
