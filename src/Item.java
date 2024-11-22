class Item {
    double price;
    int stock;
    String name;
    String description;
    int purchaseCount;
    boolean bestseller;
    double discount;

    Item(String name, double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
        this.name = name;
        this.purchaseCount = 0;
        this.bestseller = false;
        this.discount = 0;
    }

    void restock(int amount) {
        this.stock = this.stock + amount;
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
        this.purchaseCount += amount;
        if (this.purchaseCount > 5){
            this.bestseller = true;
        }
    }
    void setDescription(String description){
        this.description = description;
    }
    String getDescription(){
        return this.description;
    }
    void applyDiscount(double discountRate){
        this.discount = discountRate;
    }
    double getDiscountPrice(){
        return price * (1 - discount);
    }
    void rename(String newName){
        this.name = newName;
    }
}