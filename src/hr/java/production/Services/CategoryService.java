package hr.java.production.Services;
import hr.java.production.model.Category;
import java.util.Scanner;
public class CategoryService {
    public static Category[] inputCategories(Scanner scanner) {
        System.out.println("Enter number of categories: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Category[] categories = new Category[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter Category " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            categories[i] = new Category(name, description);
        }
        return categories;
    }
}
