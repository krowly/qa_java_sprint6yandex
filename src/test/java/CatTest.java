import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    private Cat cat = new Cat(new Feline());
    @Test
    public void CatTest1() throws Exception {
        cat.getSound();
        cat.getFood();
        Mockito.verify(cat).getSound();
        Mockito.verify(cat).getFood();
    }
}
