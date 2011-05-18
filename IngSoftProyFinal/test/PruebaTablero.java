
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
    
    @Test 
    public void mostrarTableroInicialDebeSerStringDistintoAVacio()
    {
        assertNotSame("",tablero.mostrarTablero());
        System.out.println(tablero.mostrarTablero());
    }
    
    @Test 
    public void jugadorMueveFichaValidaEnLineaRectaALaDerechaA()
    {
        
    }
    /*@Test public void mostrarTableroInicial()
    {
        assertEquals("1-Ocu   2-Ocu   3-Ocu   4-Ocu   5-Ocu   \n\n     6-Ocu   7-Ocu   8-Ocu   9-Ocu   \n\n        10-Ocu   11-Ocu   12-Ocu   \n\n            13-Ocu   14-Ocu   \n\n                 15-Ocu   ",tablero.mostrarTablero());
        System.out.println(tablero.mostrarTablero());
    }*/
    
}
