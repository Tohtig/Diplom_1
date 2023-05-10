package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String bunName = "Bun Name";
    private final float price = 2.25f;
    private final Bun bun = new Bun(bunName, price);

    @Test
    public void getNameShouldBunName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceShouldTwoAndTwentyFive() {
        assertEquals(price, bun.getPrice(), 0.05);
    }
}
