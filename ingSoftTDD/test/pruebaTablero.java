
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaTablero {
    
    Tablero tablero=new Tablero();
    public pruebaTablero() {
    }
    
    @Test 
    public void tableroNuevoDebeEstarLlenoDeFichas()
    {
        assertTrue(tablero.estaLlenoDeFichas());
    }
    @Test
    public void tableroNodebeEstarLlenoSiHayHueco()
    {
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.estaLlenoDeFichas());
    }
    @Test
    public void jugadorComeUnaFicha()//jugador mueve una ficha a una posicion vacia en el tablero comiendo asi una ficha
    {
        tablero.agregarHuecoDeInicio(1);
        tablero.moverFicha(3,1);
    }
}
