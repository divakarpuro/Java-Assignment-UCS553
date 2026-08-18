package library.model;

public abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    private static String libraryName = "TIET Smart Library";
    private static int resourceCount = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;

        resourceCount++;
    }

    public abstract double calculateFine(int overdueDays);

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    protected void displayBasicDetails() {
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public static void displayTotalResources() {
        System.out.println("Total resources created: " + resourceCount);
    }
}