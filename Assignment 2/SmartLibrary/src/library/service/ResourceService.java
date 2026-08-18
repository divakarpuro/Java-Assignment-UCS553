package library.service;

import library.model.LibraryResource;
import library.model.Printable;

public class ResourceService {

    public static void displayResources(Printable[] resources) {

        for (Printable resource : resources) {
            resource.printDetails();
            System.out.println();
        }
    }

    public static double calculateTotalFine(
            LibraryResource[] resources,
            int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {
            totalFine += resources[i].calculateFine(overdueDays[i]);
        }

        return totalFine;
    }
}