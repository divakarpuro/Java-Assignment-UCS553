package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.model.Printable;
import library.service.ResourceService;
import library.util.InputValidator;

public class LibraryMain {

    public static void main(String[] args) {

        Book b1 = new Book(
                101,
                "Java Programming",
                "Herbert Schildt"
        );

        Book b2 = new Book(
                102,
                "Data Structures",
                "Mark Allen Weiss"
        );

        Book b3 = new Book(
                103,
                "Operating Systems",
                "Galvin"
        );

        DigitalResource d1 = new DigitalResource(
                201,
                "Machine Learning",
                "Tom Mitchell"
        );

        DigitalResource d2 = new DigitalResource(
                202,
                "Artificial Intelligence",
                "Stuart Russell"
        );

        LibraryResource[] resources = {
                b1, b2, b3, d1, d2
        };

        Printable[] printableResources = {
                b1, b2, b3, d1, d2
        };

        int[] overdueDays = {
                3, 5, 0, 4, 2
        };

        System.out.println("===== SMART LIBRARY =====");
        System.out.println();

        System.out.println(
                "Library: " + LibraryResource.getLibraryName()
        );

        System.out.println();

        System.out.println("===== RESOURCE DETAILS =====");

        ResourceService.displayResources(printableResources);

        System.out.println("===== VALIDATION =====");

        for (int i = 0; i < resources.length; i++) {

            boolean validId =
                    InputValidator.isValidResourceId(
                            resources[i].getResourceId()
                    );

            boolean validDays =
                    InputValidator.isValidFineDays(
                            overdueDays[i]
                    );

            System.out.println(
                    "Resource ID "
                    + resources[i].getResourceId()
                    + " valid: " + validId
            );

            System.out.println(
                    "Fine days "
                    + overdueDays[i]
                    + " valid: " + validDays
            );
        }

        System.out.println();

        double totalFine =
                ResourceService.calculateTotalFine(
                        resources,
                        overdueDays
                );

        System.out.println(
                "Total Fine: Rs. " + totalFine
        );

        System.out.println();

        LibraryResource.displayTotalResources();
    }
}