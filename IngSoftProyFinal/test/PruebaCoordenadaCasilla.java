
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaCoordenadaCasilla {
    
    CoordenadaCasilla casilla=new CoordenadaCasilla(1,3);
    
    public PruebaCoordenadaCasilla() {
    }
    
    @Test 
    public void casillaConValoresDistintosACeroDebeSerDistintoDeFilaCeroColumnaCero(){
        assertFalse(casilla.esIgual(0, 0));
    }
    
    @Test 
    public void casillaDebeSerIgualFilaUnoYColumnaTresSiSeCreoConFilaUnoYColumnaTres(){
        assertTrue(casilla.esIgual(1, 3));
    }
    
    @Test 
    public void casillaConFilaUnoDebeDevolverFilaIgualAUno(){
        assertEquals(1,casilla.obtenerFila());
    }
    
    @Test 
    public void casillaConColumnaTresDebeDevolverColumnaIgualATres(){
        assertEquals(3,casilla.obtenerColumna());
    }
    
    @Test 
    public void casillaOrigenPuedeMoverseACasillaDestino(){
        CoordenadaCasilla coordenadaCasillaDestino=new CoordenadaCasilla(3,3);
        assertTrue(casilla.moverseA(coordenadaCasillaDestino));
    }
    
    @Test 
    public void casillaOrigenNoPuedeMoverseACasillaDestino(){
        CoordenadaCasilla coordenadaCasillaDestino=new CoordenadaCasilla(3,2);
        assertFalse(casilla.moverseA(coordenadaCasillaDestino));
    }
    
    @Test 
    public void casillaComeCasillaCorrecta(){
        CoordenadaCasilla coordenadaCasillaDestino=new CoordenadaCasilla(3,3);
        assertTrue(casilla.comerFicha(coordenadaCasillaDestino).esIgual(2, 3));
    }
    
    @Test 
    public void casillaNoComeCasillaIncorrecta(){
        CoordenadaCasilla coordenadaCasillaDestino=new CoordenadaCasilla(3,3);
        assertFalse(casilla.comerFicha(coordenadaCasillaDestino).esIgual(3, 5));
    }
    
}
