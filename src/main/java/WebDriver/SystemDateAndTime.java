package WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDateAndTime {

	public static void main(String[] args) {
		
		DateFormat dateForamt= new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
		 Date systemDate= new Date();
		String date= dateForamt.format(systemDate);
		System.out.println(date);
	}

}
