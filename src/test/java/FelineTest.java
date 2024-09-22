import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest
{
    @Spy
    private Feline feline = new Feline();
    @Test
    public void FelineTest1() throws Exception {
        feline.eatMeat();
        feline.getKittens();
        feline.getFamily();
        Mockito.verify(feline).eatMeat();
        Mockito.verify(feline).getKittens();
        Mockito.verify(feline).getFamily();
    }
}