
import java.util.ArrayList;
import java.util.List;

public class Casilla {
    
    private Integer numeroCasilla;
    private boolean ocupado;
    private List<Integer> casillasMoverse=new ArrayList<Integer>();

    public Casilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
        ocupado=true;
    }

    boolean estaOcupada() {
        return ocupado;
    }

    boolean numeroCasillaEs(int casillaHueco) {
        if(numeroCasilla==casillaHueco)
            return true;
        else
            return false;
    }

    void desocupar() {
        ocupado=false;
    }
    
    String mostrarCasilla()
    {
        if(ocupado)
            return numeroCasilla.toString()+" O";
        else
            return numeroCasilla.toString()+" V";
    }

    void agregarCasillaALista(Integer casillaMover) {
        casillasMoverse.add(casillaMover);
    }
    
}
