package dateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Scanner;

public class TimeDifferenceInSameZone {
	public static void main(String []args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter your Date of birth in the format yyyy-mm-dd\n");
		String d1=scanner.nextLine();
		System.out.println("Enter your Parent's or Sibling Date of birth in the format yyyy-mm-dd\n");
		String d2=scanner.nextLine();
		
		LocalDate l1=LocalDate.parse(d1);
		LocalDate l2=LocalDate.parse(d2);
		
		LocalDateTime date1=l1.atStartOfDay();
		LocalDateTime date2=l2.atStartOfDay();
		
		long diffInNano = ChronoUnit.NANOS.between(date1, date2);
		
		System.out.println("Difference in nanoseconds is :" +Math.abs(diffInNano));

		ZoneId australia = ZoneId.of("Australia/Melbourne");
		
		ZonedDateTime myDate = date1.atZone(australia);
		ZonedDateTime elderDate = date2.atZone(australia);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(myDate, elderDate);
		System.out.println("Difference in days is :"+Math.abs(noOfDaysBetween));
		
		scanner.close();
        
	}
}
