import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    static Vending vendor;
    static Item item;

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
    }
}