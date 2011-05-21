
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaTablero {
    
    Tablero tablero=new Tablero();
    
    public PruebaTablero() {
    }

    @Test
    public void tableroNuevoDebeEstarLlenoDeFichas(){
        assertEquals(0,tablero.cantidadCasillasVacias());
    }
    
    @Test
    public void jugadorInidicaHuecoValidoDeberiaDevolverTrue(){
        assertTrue(tablero.agregarHuecoDeInicio(1));
    }
    
    @Test
    public void jugadorIndicaHuecoInvalidoDeberiaDevolverFalse(){
        assertFalse(tablero.agregarHuecoDeInicio(15));
    }
    @Test
    public void jugadorIndicaHuecoValidoTableroDebeTenerUnaCasillaVacia(){
        tablero.agregarHuecoDeInicio(1);
        assertEquals(1,tablero.cantidadCasillasVacias());
    }
    
    @Test 
    public void jugadorIndicaHuecoInvalidoTableroDebeEstarLleno(){
        tablero.agregarHuecoDeInicio(15);
        assertEquals(0,tablero.cantidadCasillasVacias());
    }
    @Test
    public void jugadorIndicaHuecoEsaCasillaDebeEstarVacia(){
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.casillaOcupada(1));
    }
    
    @Test
    public void jugadorMueveFichaCorrectamenteTableroDebeTenerDosCasillasVacias(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3,1);
        assertEquals(2,tablero.cantidadCasillasVacias());
    }
    
    @Test
    public void jugadorMueveFichaCorrectamenteDebeDevolverTrue(){
        tablero.agregarHuecoDeInicio(1);
        assertTrue(tablero.realizarJugada(3, 1));
    }
    
    @Test
    public void jugadorMueveFichaOrigenValidaADestinoValidoPeroMovimientoInvalidoNoDebeDeMover(){
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.realizarJugada(3,2));
    }
    
    @Test 
    public void jugadorMueveFichaOrigenInvalidaADestinoValidoNoDebeDeMover(){
        
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.realizarJugada(-1, 1));
    }
    
    @Test 
    public void jugadorMueveFichaOrigenValidaADestinoInvalidoNoDebeDeMover(){
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.realizarJugada(3, -1));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnLineaRectaALaDerechaDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(3);
        assertTrue(tablero.realizarJugada(1,3));
    }
    
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnLineaRectaALaDerechaNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(3);
        assertFalse(tablero.realizarJugada(1,2));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnLineaRectaALaIzquierdaDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(1);
        assertTrue(tablero.realizarJugada(3,1));
    }
        
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnLineaRectaALaIzquierdaNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.realizarJugada(3,0));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnDiagonalDerechaHaciaAbajoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(10);
        assertTrue(tablero.realizarJugada(1,10));
    }
        
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnDiagonalDerechaHaciaAbajoNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(10);
        assertFalse(tablero.realizarJugada(1,13));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnDiagonalIzquierdaHaciaArribaDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(1);
        assertTrue(tablero.realizarJugada(10,1));
    }
        
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnDiagonalIzquierdaHaciaArribaNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(1);
        assertFalse(tablero.realizarJugada(10,6));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnDiagonalIzquierdaHaciaAbajoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(10);
        assertTrue(tablero.realizarJugada(3,10));
    }
        
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnDiagonalIzquierdaHaciaAbajoNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(10);
        assertFalse(tablero.realizarJugada(3,7));
    }
    
    @Test 
    public void jugadorRealizaMovimientoValidoEnDiagonalDerechaHaciaArribaDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(3);
        assertTrue(tablero.realizarJugada(10,3));
    }
            
    @Test 
    public void jugadorRealizaMovimientoInvalidoEnDiagonalDerechaHaciaArribaNoDebeRealizarElMovimiento(){
        tablero.agregarHuecoDeInicio(3);
        assertFalse(tablero.realizarJugada(7,3));
    }
     
    @Test 
    public void mostrarTableroInicialDebeSerStringDistintoAVacio(){
        assertNotSame("",tablero.mostrarTablero());
    }
    
    @Test 
    public void jugadorNoTieneMasJugadasDisponiblesDebeDevolverTrue(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        tablero.realizarJugada(9, 2);
        tablero.realizarJugada(1, 3);
        tablero.realizarJugada(0, 9);
        tablero.realizarJugada(12, 5);
        tablero.realizarJugada(4, 2);
        tablero.realizarJugada(11, 9);
        tablero.realizarJugada(8, 6);
        tablero.realizarJugada(5,12);
        tablero.realizarJugada(2,9);
        tablero.realizarJugada(12, 5);
        tablero.realizarJugada(14, 11);
        assertFalse(tablero.existenMasJugadas());
    }
    
    @Test 
    public void jugadorTieneMasJugadasDisponiblesDebeDevolverFalse(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        tablero.realizarJugada(9, 2);
        tablero.realizarJugada(1, 3);
        tablero.realizarJugada(0, 9);
        tablero.realizarJugada(12, 5);
        tablero.realizarJugada(4, 2);
        tablero.realizarJugada(11, 9);
        tablero.realizarJugada(8, 6);
        tablero.realizarJugada(5,12);
        tablero.realizarJugada(2,9);
        tablero.realizarJugada(12, 5);
        assertTrue(tablero.existenMasJugadas());
    }
    
    @Test 
    public void computadoraJuegaNuevoJuegoSolaDebeGanar(){
        tablero.agregarHuecoDeInicio(0);
        assertTrue(tablero.resolverJuego());
        System.out.println(tablero.mostrarTablero());
    }
    
    @Test 
    public void jugadorGanaJuegoDebeHaberCatorceCasillasVacias(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        tablero.realizarJugada(0, 2);
        tablero.realizarJugada(10, 1);
        tablero.realizarJugada(1, 3);
        tablero.realizarJugada(4, 2);
        tablero.realizarJugada(8, 6);
        tablero.realizarJugada(5, 7);
        tablero.realizarJugada(12, 5);
        tablero.realizarJugada(13, 8);
        tablero.realizarJugada(8, 6);
        tablero.realizarJugada(2, 9);
        tablero.realizarJugada(5, 12);
        tablero.realizarJugada(14, 9);
        assertEquals(14,tablero.cantidadCasillasVacias());
    }
    
    /*@Test 
    public void tableroSinFichasDebeMostrarVacio(){
        tablero.vaciarTablero();
        assertEquals(tablero.mostrarTablero(),"");
    }*/
    
    /*@Test 
    public void mostrarTableroInicial()
    {
        assertEquals("1-Ocu   2-Ocu   3-Ocu   4-Ocu   5-Ocu   \n\n     6-Ocu   7-Ocu   8-Ocu   9-Ocu   \n\n        10-Ocu   11-Ocu   12-Ocu   \n\n            13-Ocu   14-Ocu   \n\n                 15-Ocu   ",tablero.mostrarTablero());
        System.out.println(tablero.mostrarTablero());
    }*/
       
}
