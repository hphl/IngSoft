

class CoordenadaCasilla{
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

    public boolean esIgual(int fila, int columna) {
        return (this.fila==fila && this.columna==columna);
    }

    public boolean moverseA(CoordenadaCasilla coordenadaCasillaDestino) {
        return (this.comerFicha(coordenadaCasillaDestino)!= null);          
    }

    public CoordenadaCasilla comerFicha(CoordenadaCasilla coordenadaCasillaDestino) {//refactorizar
        if(moverHaciaArribaEnDiagonalIzquierda( coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila+1,columna);
                
        else if(moverHaciaAbajoEnDiagonalDerecha( coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila-1,columna);
                
        else if(moverHaciaDerechaRecto(coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila,columna+1);
                
        else if(moverIzquierdaRecto(coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila,columna-1);
                
        else if(moverHaciaArribaEnDiagonalDerecha(coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila+1,columna+1);
                
        else if(moverHaciaAbajoEnDiagonalIzquierda(coordenadaCasillaDestino))
            return new CoordenadaCasilla(fila-1,columna-1);               
        else
            return null;
    }

    private boolean moverHaciaAbajoEnDiagonalIzquierda(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila-2, columna-2);
    }

    private boolean moverHaciaArribaEnDiagonalDerecha(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila+2, columna+2);
    }

    private boolean moverIzquierdaRecto(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila, columna-2);
    }

    private boolean moverHaciaDerechaRecto(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila,columna+2);
    }

    private boolean moverHaciaAbajoEnDiagonalDerecha(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila-2, columna);
    }

    private boolean moverHaciaArribaEnDiagonalIzquierda(CoordenadaCasilla coordenadaCasillaDestino) {
        return coordenadaCasillaDestino.esIgual(fila+2, columna);
    }
    
}
