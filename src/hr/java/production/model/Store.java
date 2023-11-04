package hr.java.production.model;
public class Store extends NamedEntity {
    private String webAddress;
    private Item[] items;
    private Address address;
    public Store(String name, String webAddress, Item[] items, Address address) {
        super(name);
        this.webAddress = webAddress;
        this.items = items;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getWebAddress() {
        return webAddress;
    }
    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
    public Item[] getItems() {
        return items;
    }
    public void setItems(Item[] items) {
        this.items = items;
    }
}
