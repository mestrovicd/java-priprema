package hr.java.production.Services;
import hr.java.production.model.Address;
import hr.java.production.model.Item;
import hr.java.production.model.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StoreService {
    public static Store[] inputStores(Scanner scanner, Item[] items) {
        System.out.println("Enter number of stores: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Store[] stores = new Store[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter Store " + (i + 1) + " details:");
            System.out.print("Name: ");
            String storeName = scanner.nextLine();
            System.out.print("Web Address: ");
            String webAddress = scanner.nextLine();
            Address address = AddressService.inputAddress(scanner);

            List<Item> soldItems = selectSoldItems(scanner, items);

            stores[i] = new Store(storeName, webAddress, soldItems.toArray(new Item[0]), address);
        }
        return stores;
    }

    public static List<Item> selectSoldItems(Scanner scanner, Item[] items) {
        List<Item> soldItems = new ArrayList<>();
        System.out.println("Select items sold in this store (Enter item numbers, 0 to finish):");

        return ItemService.getItems(scanner, items, soldItems);
    }

    public static void listStoresInStreet(Store[] stores, String streetName) {
        for (Store store : stores) {
            if (store.getAddress().getStreet().compareTo(streetName) == 0) {
                System.out.println("Store " + store.getName() + " is in the " + streetName + " street!");
            }
        }
    }

    public static Store findStoreSellingCheapestItem(Store[] stores) {
        Store storeSellingCheapestItem = null;
        BigDecimal minPrice = BigDecimal.valueOf(Double.MAX_VALUE);

        for (Store store : stores) {
            for (Item item : store.getItems()) {
                if (item.getSellingPrice().compareTo(minPrice) < 0) {
                    minPrice = item.getSellingPrice();
                    storeSellingCheapestItem = store;
                }
            }
        }

        return storeSellingCheapestItem;
    }
}