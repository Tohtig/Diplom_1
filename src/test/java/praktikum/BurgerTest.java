package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;

    @Test
    public void getPriceShowsSixteenPointSixteen() {
        Mockito.when(bun.getPrice()).thenReturn(4.04f);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "same_filling", 4.04f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "same_sauce", 4.04f));
        assertEquals(16.16, burger.getPrice(), 0.05);
    }

    @Test
    public void getReceiptShowRedBunGreenSauce() {
        Bun redBun = new Bun("red bun", 1);
        Ingredient greenSauce = new Ingredient(IngredientType.SAUCE, "green sauce", 2);
        burger = new Burger();
        burger.setBuns(redBun);
        burger.addIngredient(greenSauce);
        String actual = burger.getReceipt();
        MatcherAssert.assertThat(actual, allOf(startsWith(String.format("(==== %s ====)", redBun.getName())), containsString(String.format("(==== %s ====)%n", redBun.getName()))));
    }
}
