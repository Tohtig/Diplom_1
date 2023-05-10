package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final String typeName;

    public IngredientParametrizedTest(String typeName) {
        this.typeName = typeName;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] setType() {
        return new Object[][]{
                {IngredientType.SAUCE.toString()},
                {IngredientType.FILLING.toString()},
                {"что-то не съедобное"}
        };
    }

    @Test
    public void ingredientTypeOnly() {
        try {
            String name = "Ингредиент";
            float price = 2.25f;
            Ingredient ingredient = new Ingredient(IngredientType.valueOf(typeName), name, price);
            assertEquals(ingredient.getType().toString(), typeName);
            assertEquals(ingredient.getName(), name);
            assertEquals(ingredient.getPrice(), price, 0.05);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("No enum constant praktikum.IngredientType"));
        }
    }
}
