import java.util.HashMap;
/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    public static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        //Stock.put("Candy", new Item(1.25, numCandy));
        //Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    public Vending() {

    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {
        this.balance = this.balance + amt;
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            } else
                System.out.println("Gimme more money");
        } else System.out.println("Sorry, don't know that item");
    }

    public int getStock() {
        return Stock.size();
    }

    public void clearStock() {
        Stock.clear();
    }

    void restockItem(String name, int quantity, double price, String description) {
        if (Stock.containsKey(name)) {
            Stock.get(name).restock(quantity);
        } else {
            Item newItem = new Item(name, price, quantity);
            newItem.setDescription(description);
            Stock.put(name, newItem);
        }
    }

    void renameItem(String oldName, String newName) {
        if (Stock.containsKey(oldName)) {
            Item item = Stock.remove(oldName);
            item.rename(newName);
            Stock.put(newName, item);
        }
    }

    void removeItem(String name) {
        Stock.remove(name);
    }
    //String printInventory()

    String getItemDetails(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            return String.format("Item: %s, Price: %.2f, Stock: %d, Description: %s",
                    name, item.getDiscountPrice(), item.stock, item.getDescription());
        }
        return "Item not found";
    }
}


