package hr.java.production.main;
import hr.java.production.Services.CategoryService;
import hr.java.production.Services.FactoryService;
import hr.java.production.Services.ItemService;
import hr.java.production.Services.StoreService;
import hr.java.production.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category[] categories = CategoryService.inputCategories(scanner);
        Item[] items = ItemService.inputItems(scanner, categories);
        Factory[] factories = FactoryService.inputFactories(scanner, items);
        Store[] stores = StoreService.inputStores(scanner, items);

        // Store storeSellingCheapestItem = StoreService.findStoreSellingCheapestItem(stores);
        // System.out.println("Store selling the cheapest item: " + storeSellingCheapestItem.getName());

        // StoreService.listStoresInStreet(stores, "Main Street");

        // Factory biggestItemFactory = FactoryService.findFactoryWithHighestVolumeItem(factories);
        // System.out.println("Store selling the biggest item: " + biggestItemFactory.getName());

        for (Item item : items) {
            System.out.println("Item Name: " + item.getName());
            System.out.println("Item Height: " + item.getHeight());
            System.out.println("Item Calories: " + ItemService.calculateCalories(item));
            System.out.println("Item Price: " + ItemService.calculatePriceByWeight(item));
            System.out.println("Item Category: " + item.getCategory().getName());
            System.out.println(); // Add a line break for readability
        }
    }
}
