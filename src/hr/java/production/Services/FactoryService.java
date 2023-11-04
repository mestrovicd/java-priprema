package hr.java.production.Services;
import hr.java.production.model.Address;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FactoryService {
    public static Factory[] inputFactories(Scanner scanner, Item[] items) {
        System.out.println("Enter number of factories: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Factory[] factories = new Factory[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter Factory " + (i + 1) + " details:");
            System.out.print("Name: ");
            String factoryName = scanner.nextLine();
            Address address = AddressService.inputAddress(scanner);

            List<Item> producedItems = selectProducedItems(scanner, items);

            factories[i] = new Factory(factoryName, address, producedItems.toArray(new Item[0]));
        }
        return factories;
    }

    public static List<Item> selectProducedItems(Scanner scanner, Item[] items) {
        List<Item> producedItems = new ArrayList<>();
        System.out.println("Select items produced by this factory (Enter item numbers, 0 to finish):");

        return ItemService.getItems(scanner, items, producedItems);
    }

    public static Factory findFactoryWithHighestVolumeItem(Factory[] factories) {
        Factory factoryWithHighestVolume = null;
        BigDecimal maxItemVolume = BigDecimal.ZERO;

        for (Factory factory : factories) {
            for (Item item : factory.getItems()) {
                BigDecimal itemVolume = item.getWidth().multiply(item.getHeight()).multiply(item.getLength());
                if (itemVolume.compareTo(maxItemVolume) > 0) {
                    maxItemVolume = itemVolume;
                    factoryWithHighestVolume = factory;
                }
            }
        }

        return factoryWithHighestVolume;
    }
}