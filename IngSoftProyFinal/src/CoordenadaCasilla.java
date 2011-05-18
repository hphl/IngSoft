
import java.util.ArrayList;
import java.util.List;




class CoordenadaCasilla {
    private int fila;
    private int columna;
    
    public CoordenadaCasilla() {
        fila=0;
        columna=0;
    }

    public CoordenadaCasilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    int obtenerFila() {
        return fila;
    }

    int obtenerColumna() {
        return columna;
    }

    boolean esIgual(int fila, int columna) {
        if(this.fila==fila && this.columna==columna)
            return true;
        else
            return false;
    }

    boolean moverseA(CoordenadaCasilla coordenadaCasillaDestino) {
        if(this.comerFicha(coordenadaCasillaDestino)!= null)
            return true;
        else
            return false;
            
    }

    CoordenadaCasilla comerFicha(CoordenadaCasilla coordenadaCasillaDestino) {
        if(coordenadaCasillaDestino.esIgual(fila+2, columna))
            return new CoordenadaCasilla(fila+1,columna);
                
        else if(coordenadaCasillaDestino.esIgual(fila-2, columna))
            return new CoordenadaCasilla(fila-1,columna);
                
        else if(coordenadaCasillaDestino.esIgual(fila,columna+2))
            return new CoordenadaCasilla(fila,columna+1);
                
        else if(coordenadaCasillaDestino.esIgual(fila, columna-2))
            return new CoordenadaCasilla(fila,columna-1);
                
        else if(coordenadaCasillaDestino.esIgual(fila+2, columna+2))
            return new CoordenadaCasilla(fila+1,columna+1);
                
        else if(coordenadaCasillaDestino.esIgual(fila-2, columna-2))
            return new CoordenadaCasilla(fila-1,columna-1);
                
        else
            return null;
    }
    
}
