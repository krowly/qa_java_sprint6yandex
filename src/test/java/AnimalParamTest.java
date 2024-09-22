import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(org.junit.runners.Parameterized.class)
public class AnimalParamTest {
    @org.junit.runners.Parameterized.Parameters
    public static Object[] getSumData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Exception", Exception.class}// передали тестовые данные
        };
    }
    public AnimalParamTest(String animalKind, Object expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    private final String animalKind;
    private final Object expectedResult;

    Animal animal = new Animal();

    @Test
    public void testGetFood_Herbivore() throws Exception {
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
        assertEquals(animal.getFamily(), "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        if(animalKind.equals("Exception")) {
            assertThrows(Exception.class, ()->animal.getFood(animalKind));
        }
        else
        {
            assertEquals(expectedResult, animal.getFood(animalKind));
        }
    }
}
