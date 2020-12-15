package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class RandomDate {

	public static void main(String[] args) {
		String line = "";  
		String splitBy = ",";  
		String[] employee = null ;
		try   
			{  
				//parsing a CSV file into BufferedReader class constructor  
				BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+ "/TestData/TestData.csv"));  
				
				while ((line = br.readLine()) != null)   //returns a Boolean value  
					{  
					   employee= line.split(splitBy);    // use comma as separator  
						System.out.println(employee[0]);  
					}   
				
			}   
				catch (IOException e)   
				{  
				e.printStackTrace();  
			}
		
	}
}


