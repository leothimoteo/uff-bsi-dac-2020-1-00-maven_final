package hello;

import java.time.LocalDateTime;

public class Teste {

	public static void main(String[] args) {
		
        // create a LocalDateTime Object
        //LocalDateTime local = LocalDateTime.now();
		LocalDateTime local
        = LocalDateTime.parse("2019-01-28T23:29:10");
		
        // get HourOfDay
        int hourOfDay = local.getHour();
        
        if (hourOfDay >= 12 && hourOfDay < 18) {
        	System.out.println("Boa tarde");
        } else if (hourOfDay >= 18 && hourOfDay < 24) {
        	System.out.println("Boa noite");
        } else {
        	System.out.println("Bom dia");
        }
  
        // print result
        System.out.println("HourOfDay: "
                           + hourOfDay);

	}

}
