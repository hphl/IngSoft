
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
    public void jugadorRealizaJugadaValidaYLuegoUnaJugadaInvalidaDebeDeHaberDosCasillasVacias(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        tablero.realizarJugada(4, 2);
        assertEquals(tablero.cantidadCasillasVacias(),2);
    }
    
    @Test
    public void jugadorRealizaJugadaInvalidaPorqueNoHayFichaQueComerNoDebeRealizarLaJugada(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        assertFalse(tablero.realizarJugada(4, 2));
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
    public void jugadorTieneMasJugadasDisponiblesJuegoNoTermino(){
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
        assertFalse(tablero.terminoJuego());
    }
    
    @Test 
    public void jugadorTieneMasJugadasDisponiblesJugadorNodebeGanar(){
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
        assertFalse(tablero.ganarJuego());
    }
     
    @Test 
    public void computadoraJuegaNuevoJuegoSolaDebeHaberCatorceCasillasVaciasEnElTablero(){
        tablero.agregarHuecoDeInicio(0);
        Tablero copiaDeltableroOriginal=new Tablero();
        copiaDeltableroOriginal.clonar(tablero);
        System.out.println(tablero.mostrarTablero()+tablero.resolverJuego(copiaDeltableroOriginal));
        assertEquals(14,copiaDeltableroOriginal.cantidadCasillasVacias());
    }
    
    @Test 
    public void computadoraGanaJuegoDebeDevolverTrue(){
        tablero.agregarHuecoDeInicio(0);
        Tablero copiaDeltableroOriginal=new Tablero();
        copiaDeltableroOriginal.clonar(tablero);
        tablero.resolverJuego(copiaDeltableroOriginal);
        assertTrue(copiaDeltableroOriginal.ganarJuego());
    }
    
    @Test 
    public void jugadorRealizaUnaJugadaYComputadoraDebeDePoderContinuarJugando(){
        tablero.agregarHuecoDeInicio(1);
        tablero.realizarJugada(3, 1);
        Tablero copiaDeltableroOriginal=new Tablero();
        copiaDeltableroOriginal.clonar(tablero);
        tablero.resolverJuego(copiaDeltableroOriginal);
        assertTrue(copiaDeltableroOriginal.terminoJuego());
    }
    
    @Test 
    public void jugadorGanaJuegoDebeHaberCatorceCasillasVaciasEnElTablero(){
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
    
    @Test 
    public void jugadorGanaJuegoDebeGanar(){
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
        assertTrue(tablero.ganarJuego());
    }
    
    @Test 
    public void jugadorNoTieneMasJugadasDisponiblesJuegoTermino(){
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
        assertTrue(tablero.terminoJuego());
    }
    
    @Test 
    public void jugadorGanaElDebeJuegoTerminar(){
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
        assertTrue(tablero.terminoJuego());
    }
    
    @Test 
    public void tableroEsClonadoEnTableroCopiaAmbosDebenSerIguales(){
        tablero.agregarHuecoDeInicio(0);
        Tablero tableroCopia=new Tablero();
        tableroCopia.clonar(tablero);
        assertEquals(tablero.mostrarTablero(),tableroCopia.mostrarTablero());
    }
    
    @Test 
    public void tableroEsClonadoEnTableroCopiaYLuegoTableroRealizaMovimientoValidoAmbosNoDebenSerIguales(){
        tablero.agregarHuecoDeInicio(1);
        Tablero tableroCopia=new Tablero();
        tableroCopia.clonar(tablero);
        tablero.realizarJugada(3, 1);
        assertNotSame(tableroCopia.mostrarTablero(),tablero.mostrarTablero());
    }
    
    @Test 
    public void tableroSinFichasDebeMostrarTodasLasCasillasVacias(){
        tablero.vaciarTablero();
        assertEquals(tablero.mostrarTablero(),"   O     O     O     O     O    \n   1     2     3     4     5    \n\n     O     O     O     O    \n     6     7     8     9    \n\n       O     O     O    \n      10    11    12    \n\n         O     O    \n        13    14    \n\n           O    \n          15    \n\n");
    }
       
}
