import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.example.Calculadora;

public class TestCalculadora {
    Calculadora calc = new Calculadora();

    // criar os teste
    @Test
    public void testeSoma(){
        double resultado = calc.soma(3, 8);
        assertEquals(11, resultado, 0);

    }

    @Test
    public void testeMultiplica(){
        double resultado = calc.multiplica(5, 3);
        assertEquals(15, resultado, 0);
    }
    @Test
    public void testeSubtrai(){
        double resultado = calc.subtrai(10, 2);
        assertEquals(8, resultado, 0);
    }

    @Test
    public void testeDivide(){
        double resultado = calc.divide(10, 2);
        assertEquals(5, resultado, 0);
    }

    @Test
    public void testDividePorZero(){
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }

}
  