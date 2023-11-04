package hr.java.production.Services;
import hr.java.production.model.Address;

import java.util.Scanner;
public class AddressService {
    public static Address inputAddress(Scanner scanner) {
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("House Number: ");
        String houseNumber = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();
        return new Address(street, houseNumber, city, postalCode);
    }
}