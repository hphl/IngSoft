


class Casilla {
    private int fila;
    private int columna;

    public Casilla() {
        fila=0;
        columna=0;
    }

    public Casilla(int fila, int columna) {
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
    
}
