package by.epam.course.basic.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Kiryl_Miatlitski
 * 
 * date 18 March 2017
 * 
 * Task: Проанализируйте библиотеку IO Streams. Напишите собственные примеры сериализации, десериализации.
 */
public class Task1 {

	public static void main(String[] args) {
		
		testReadWriteWithFile();
		testObjectSerialization();
	}
	
	public static void testObjectSerialization(){
		String fileName ="ObjectText.txt";
		File file = new File(fileName);
		FileInputStream fInput = null;
		FileOutputStream fOutput= null;
		ObjectOutputStream obOutput = null;
		ObjectInputStream obInput = null;
		System.out.println("Serializable");
		try {
			fOutput = new FileOutputStream(file);
			obOutput = new ObjectOutputStream(fOutput);
			Lamp lamp1 = new Lamp("Черная лампа", "Белый", new Lightbulb(600));
			Lamp lamp2 = new Lamp("Белая лампа", "Чёрный", new Lightbulb(800));
			Table table = new Table();
			table.setLamp1(lamp1);
			table.setLamp2(lamp2);
			obOutput.writeObject(table);
			
			lamp1.setNewLightbulb(new Lightbulb(300));
			obOutput.reset();
			obOutput.writeObject(lamp1);
			obOutput.writeObject(lamp2);
			obOutput.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obOutput.close();
			} catch (IOException e) {
			}
		}
		
		try {
			fInput = new FileInputStream(file);
			obInput = new ObjectInputStream(fInput);
			
			Object obj = null;
			while (fInput.available() > 0){
				obj =  obInput.readObject();
				System.out.println("Считанный объект из файла");
				
				if(obj instanceof Lamp){
					System.out.println("Лампа!");
					obj = (Lamp) obj;
				} else if  (obj instanceof Table){
					System.out.println("Стол!");
					obj = (Table) obj;
				} else {
					System.out.println("Какой-то объект!");
				}
				
				System.out.println(obj);
			}

			
			

			
			obInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				obInput.close();
			} catch (IOException e) {
			}
		}
		
	}
	
	public static void testReadWriteWithFile(){
		String fileName = "textExample.txt";
		File file = new File(fileName);
		FileWriter ioWriter = null;
		FileReader ioReader = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			ioWriter = new FileWriter(file);
			bw = new BufferedWriter(ioWriter);
			bw.write("Строка 1: Пробный текст\n");
			bw.write("Строка 2: Пробный текст2 ");	
			bw.write("Строка 2: Пробный текст2\n");
			
			bw.write("Строка 3: Пробный текст3\n");
			
			
		} catch (IOException e1) {
				e1.printStackTrace();
		} finally{
			try {
				bw.close();
			} catch (IOException e) {			
			}
		}
		
		
		try {
			ioReader = new FileReader(file);
			br = new BufferedReader(ioReader);
			String text = "";
			while (br.ready()){
				text = br.readLine();
				System.out.println(text);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ioReader.close();
			} catch (IOException e) {
			}
		}
	}
}
