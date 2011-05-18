
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaCasilla {
    
    Casilla casilla=new Casilla(1,3);
    
    public PruebaCasilla() {
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
    public void casillaNuevaSinPosicionNoDebeEstarSinColor(){
        assertNotSame("",casilla.obtenerColor());
    }
            
    
}
