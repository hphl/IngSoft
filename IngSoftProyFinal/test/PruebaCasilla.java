
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaCasilla {
    
    Casilla casilla=new Casilla();
    
    public PruebaCasilla() {
    }

     @Test
     public void nuevaCasillaEstaOcupada() {
         assertTrue(casilla.ocupado());
     }
     
     @Test 
     public void casillaDesocupadaDebeEstarComoDesocupada(){
         casilla.desocupar();
         assertFalse(casilla.ocupado());
     }
     
     @Test 
     public void siEstaDesocupadaPuedeOcuparseDeNuevo(){
         casilla.desocupar();
         casilla.ocupar();
         assertTrue(casilla.ocupado());
     }
     
     @Test public void casillaDebeTenerColorDistintoASinColor(){
         assertNotSame("", casilla.obtenerColor());
     }
     
     @Test public void casillaDesocupadaDebeEstarSinColor(){
         casilla.desocupar();
         assertEquals(" O    ",casilla.obtenerColor());
     }
     
     @Test public void puedeCambiarDeColorDeOtraCasilla(){
         Casilla casillaNueva=new Casilla();
         casilla.desocupar();
         casilla.cambiarColor(casillaNueva);
         assertEquals(casillaNueva.obtenerColor(),casilla.obtenerColor());
     }
}
