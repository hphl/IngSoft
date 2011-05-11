
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaTablero {
    
    Tablero tablero=new Tablero();
    
    public pruebaTablero() {
    }
    
    @Test 
    public void llenarTableroConUnHueco()
    {
        tablero.crearTablero(5);
    }
}
