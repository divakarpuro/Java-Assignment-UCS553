
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = sc.nextLine();

        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:MM): ");
        LocalTime start = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (leave blank if unavailable): ");
        String venueName = sc.nextLine();

        Optional<String> venue = venueName.trim().isEmpty()
                ? Optional.empty()
                : Optional.of(venueName);

        LocalDate today = LocalDate.now();
        LocalTime end = start.plusHours(2);

        System.out.println("\nEvent Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + start);
        System.out.println("End Time: " + end);
        System.out.println("Venue: " +
                venue.orElse("Venue not specified"));

        if (date.isAfter(today)) {
            System.out.println("Event is in the future.");
        } else if (date.isEqual(today)) {
            System.out.println("Event is today.");
        } else {
            System.out.println("Event is in the past.");
        }

        long days = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days remaining: " + days);

        sc.close();
    }
}
