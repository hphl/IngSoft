
public class IteradorTablero {
    private Casilla matriz[][];
    private int limiteFilas;
    private int limiteColumnas;

    public IteradorTablero() {
        limiteFilas=0;
        limiteColumnas=0;
        matriz=new Casilla[limiteFilas][limiteColumnas];
    }

    public IteradorTablero(Casilla[][] matriz, int limiteFilas, int limiteColumnas) {
        this.matriz = matriz;
        this.limiteFilas = limiteFilas;
        this.limiteColumnas = limiteColumnas;
    }
    public Casilla iterarTablero()
    {
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                return matriz[fila][columna];
            }
            limiteColumnas--;
        }
        return null;
    }
    
}
