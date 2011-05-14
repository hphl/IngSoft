
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaTablero {
    
    Tablero tablero=new Tablero();
    public pruebaTablero() {
    }
    
    @Test 
    public void tableroNuevoDebeEstarLlenoDeFichas()
    {
        assertEquals(0,tablero.cantidadCasillasVacias());
    }
    @Test
    public void tableroNodebeEstarLlenoSiHayHueco()
    {
        tablero.agregarHuecoDeInicio(1);
        assertEquals(1,tablero.cantidadCasillasVacias());
    }
    @Test
    public void jugadorMueveUnaFichaTableroDebeTenerDosCasillasVacias()
    {
        tablero.agregarHuecoDeInicio(1);
        tablero.moverFicha(3,1);
        assertEquals(2,tablero.cantidadCasillasVacias());
    }
    @Test
    public void jugadorMueveFichaALugarInvalidoTableroDebeTenerUnaCasillaVacia()
    {
        tablero.agregarHuecoDeInicio(1);
        tablero.moverFicha(3,2);
        assertEquals(1,tablero.cantidadCasillasVacias());
        System.out.println(tablero.convertirTableroEnString());
    }
}
