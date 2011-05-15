
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaTablero {
    
    Tablero tablero=new Tablero();
    
    public PruebaTablero() {
    }

    @Test
    public void tableroNuevoDebeEstarLlenDeFichas(){
        assertEquals(0,tablero.cantidadCasillasVacias());
    }
    
    @Test
    public void jugadorInidicaHuecoValido()
    {
        assertTrue(tablero.agregarHuecoDeInicio(1));
    }
    
    @Test
    public void jugadorIndicaHuecoInvalido()
    {
        assertFalse(tablero.agregarHuecoDeInicio(15));
    }
    @Test
    public void jugadorIndicaHuecoValidoTableroNoDebeEstarLleno(){
        tablero.agregarHuecoDeInicio(1);
        assertEquals(1,tablero.cantidadCasillasVacias());
    }
    
    @Test 
    public void jugadorIndicaHuecoInvalidoTableroDebeEstarLleno()
    {
        tablero.agregarHuecoDeInicio(15);
        assertEquals(0,tablero.cantidadCasillasVacias());
    }
    @Test
    public void jugadorIndicaHuecoEsaCasillaDebeEstarVacia()
    {
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.casillaOcupada(1));
    }
    
    @Test
    public void jugadorMueveFichaCorrectamenteTableroDebeTenerDosCasillasVacias()
    {
        tablero.agregarHuecoDeInicio(1);
        tablero.moverFicha(3,1);
        assertEquals(2,tablero.cantidadCasillasVacias());
    }
    
    @Test
    public void jugadorMueveFichaCorrectamente()
    {
        tablero.agregarHuecoDeInicio(1);
        assertTrue(tablero.moverFicha(3, 1));
    }
    
    @Test
    public void jugadorMueveFichaOrigenValidaADestinoValidoPeroMovimientoInvalido()
    {
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.moverFicha(3,2));
    }
    
    @Test 
    public void jugadorMueveFichaOrigenInvalidaADestinoValido()
    {
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.moverFicha(-1, 1));
    }
    
    @Test 
    public void jugadorMueveFichaOrigenValidaADestinoInvalido()
    {
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.moverFicha(3, -1));
    }
}
