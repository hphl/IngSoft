
import java.util.ArrayList;
import java.util.List;

public class Casilla {
    
    private Integer numeroCasilla;
    private boolean ocupado;
    private List<Integer> moverseACasillas=new ArrayList<Integer>();
    private List<Integer> comerCasillas=new ArrayList<Integer>();

    public Casilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
        ocupado=true;
    }

    boolean estaOcupada() {
        return ocupado;
    }

    boolean numeroCasillaEs(int numerocasilla) {
        if(this.numeroCasilla==numerocasilla)
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

    void agregarCasillaAListaMoverse(Integer casillaMover) {
        moverseACasillas.add(casillaMover);
    }

    Integer obtenerNumeroCasilla() {
        return numeroCasilla;
    }

    void ocupar() {
        ocupado=true;
    }

    void agregarCasillaAListaComer(Integer casillaComer) {
        comerCasillas.add(casillaComer);
    }

    int moverseA(int casillaDestino) {
        if(moverseACasillas.contains(casillaDestino))
            return comerCasillas.get(moverseACasillas.indexOf(casillaDestino));
        else
            return -1;
    }
    
}
