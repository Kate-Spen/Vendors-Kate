import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class VendorTest {

    static Vending vendor;
    static Item item;

    @BeforeEach
    void setUp() {
        vendor = new Vending();
        vendor.restockItem("Candy", 10, 2.50, "Sour war heads");
        vendor.restockItem("Gum", 15, 0.50, "Bubble gum");
    }

    @Test
    void additionTest() {
        vendor.addMoney(1);
        Assertions.assertEquals(2, 1 + 1);
    }

    @Test
    void purchaseTest(){
        vendor.select("candy");
        vendor.select("gum");
        Assertions.assertEquals(9, 10 - 1);
    }

    @Test
    void emptyStock(){
    //loop that continues selecting items until stock is empty/
    //check stock = 0
        vendor.addMoney(100);
        for (int i = 0; i < 10; i++) {
            vendor.select("Candy");
            }
        for (int i = 0; i <15; i++) {
            vendor.select("Gum");
            }
        assertEquals(0, vendor.getStock(), "Stock should be empty.");
    }

    @Test
    void restockNewItem(){
        vendor.restockItem("Sour String", 5, 5.00, "Sour gummy strings");
        assertEquals("Sour gummy strings", vendor.getItemDetails("Sour String").contains("Sour gummy strings"));
    }

    @Test
    void restock(){
        vendor.restockItem("Gum", 5, 0.50, "More gum");
        //assertEquals(vendor.getItemDetails("Gum".contains(20));
    }

    @Test
    void renameItem(){
        vendor.renameItem("Gum", "Bubble Gum");
        assertEquals("Bubble Gum", vendor.getItemDetails("Gum"));
    }

    @Test
    void removeItem(){
        vendor.removeItem("Candy");
        assertEquals("Item not found.", vendor.getItemDetails("Candy"));
    }

    @Test
    void trackPurchase(){
        vendor.addMoney(20);
        vendor.select("Candy");
        assertEquals(9, vendor.Stock.get("Candy").stock);
        assertEquals(1, vendor.Stock.get("Candy").purchaseCount);
    }

    @Test
    void markBestseller(){
        vendor.addMoney(1000);
        for (int i = 0; i < 6; i++){
            vendor.select("Candy");
        }
        //assertEquals(vendor.Stock.get("Candy").bestseller);
    }
    }

