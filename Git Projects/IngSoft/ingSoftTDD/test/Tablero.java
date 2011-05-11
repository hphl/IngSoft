
class Tablero {

     Posicion tablero[][] = new Posicion [5][5];

    public Tablero() {
        int posiciones=0;
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                tablero[fila][columna].crearPosicion(true,posiciones);
            }
        }
    }

    void crearTablero(int posicionHueco) {
        
    }
    
}
