package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testNullItemList() {
        RuntimeException exception = assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                SILab2.checkCart(null, 100);
            }
        });
        assertEquals("allItems list can't be null!", exception.getMessage());
    }

    @Test
    public void testValidItemsAndInsufficientPayment() {
        List<Item> items = Arrays.asList(
                new Item("milk", "012345", 100, 0),
                new Item("water", "067890", 200, 5)
        );
        assertFalse(SILab2.checkCart(items, 100),
        "Valid items and insufficient payment should return false");
    }

    @Test
    void testInvalidBarcodeCharacter() {
        List<Item> items = Arrays.asList(
                new Item("banana", "0123a5", 100, 0)
        );
        RuntimeException exception = assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                SILab2.checkCart(items, 100);
            }
        });
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }

    @Test
    void testNoBarcode() {
        List<Item> items = Arrays.asList(
                new Item("towel", null, 350, 0)
        );
        RuntimeException exception = assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                SILab2.checkCart(items, 350);
            }
        });
        assertEquals("No barcode!", exception.getMessage());
    }
    @Test
    public void testValidItemsAndSufficientPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("cd", "012345", 350, 10));
        items.add(new Item("speaker", "067890", 480, 5));
        assertTrue(SILab2.checkCart(items, 900),
                "Valid items and sufficient payment should return true");
    }

    @Test
    public void testEmptyItemsList() {
        List<Item> items = new ArrayList<>();
        assertTrue(SILab2.checkCart(items, 301),
                "Empty list should always return true (sufficient payment)");
    }
}

