import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;
    @Test
        public void LionTest1() throws Exception {
            Lion Male = new Lion("Самец",feline);
            Lion Female = new Lion("Самка",feline);
            assertTrue(Male.doesHaveMane());
            assertFalse(Female.doesHaveMane());
            assertEquals(0,Female.getKittens());
            Feline felineSpy = Mockito.spy(Feline.class);
            Female = new Lion("Самка",felineSpy);
            assertEquals(List.of("Животные", "Птицы", "Рыба"), Female.getFood());
            assertThrows(Exception.class, ()->new Lion("Nan",feline));
    }
}
