package hr.java.production.Services;
import hr.java.production.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ItemService {
    public static Item[] inputItems(Scanner scanner, Category[] categories) {
        System.out.println("Enter number of items: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Item[] items = new Item[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter Item " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.println("Select a category:");

            for (int j = 0; j < categories.length; j++) {
                System.out.println((j + 1) + ". " + categories[j].getName());
            }

            int categoryChoice = scanner.nextInt();
            Category category = categories[categoryChoice - 1];
            scanner.nextLine();

            System.out.print("Is this item edible (food)? (y/n): ");
            String edibleChoice = scanner.nextLine();

            if (edibleChoice.equalsIgnoreCase("y")) {
                items[i] = inputEdibleItem(scanner, name, category);
            } else {
                items[i] = inputRegularItem(scanner, name, category);
            }
        }
        return items;
    }

    private static Item inputEdibleItem(Scanner scanner, String name, Category category) {


        System.out.println("Choose the type of edible item:");
        System.out.println("1. Potato");
        System.out.println("2. Chestnut");
        int edibleTypeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter weight (kg): ");
        BigDecimal weight = scanner.nextBigDecimal();
        scanner.nextLine();

        if (edibleTypeChoice == 1) {
            return new Potato(name, category, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, weight);
        } else if (edibleTypeChoice == 2) {
            return new Chestnut(name, category, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, weight);
        } else {
            System.out.println("Invalid edible item choice.");
            return null;
        }
    }


    private static Item inputRegularItem(Scanner scanner, String name, Category category) {
        System.out.print("Production cost: ");
        BigDecimal productionCost = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Selling price: ");
        BigDecimal sellingPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Width: ");
        BigDecimal width = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Height: ");
        BigDecimal height = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Length: ");
        BigDecimal length = scanner.nextBigDecimal();
        scanner.nextLine();

        return new Item(name, category, width, height, length, productionCost, sellingPrice);
    }


    private static List<Item> selectProducedItems(Scanner scanner, Item[] items) {
        List<Item> producedItems = new ArrayList<>();
        System.out.println("Select items produced by this factory (Enter item numbers, 0 to finish):");

        return getItems(scanner, items, producedItems);
    }

    public static List<Item> getItems(Scanner scanner, Item[] items, List<Item> producedItems) {
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName());
        }

        int itemChoice;

        while ((itemChoice = scanner.nextInt()) != 0) {
            if (itemChoice > 0 && itemChoice <= items.length) {
                producedItems.add(items[itemChoice - 1]);
            } else {
                System.out.println("Invalid item choice. Please select a valid item or enter 0 to finish.");
            }
        }
        scanner.nextLine();
        return producedItems;
    }

    public static List<Item> selectSoldItems(Scanner scanner, Item[] items) {
        List<Item> soldItems = new ArrayList<>();
        System.out.println("Select items sold in this store (Enter item numbers, 0 to finish):");

        return getItems(scanner, items, soldItems);
    }
}
