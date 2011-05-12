
import java.util.ArrayList;
import java.util.List;


class Tablero {

     //List <Casilla> casillas=new ArrayList<Casilla>();
    private int limiteFilas=5;
    private int limiteColumnas=5;
    private Casilla matriz[][];

    public Tablero() {
        matriz=new Casilla[limiteFilas][limiteColumnas];
        int casillaNueva=1;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                matriz[fila][columna]=new Casilla(casillaNueva);
                casillaNueva++;
            }
            limiteColumnas--;
        }
        crearListaCasillas();
    }
    
    private void reestablecerLimiteColumna()
    {
        limiteColumnas=5;
    }
    
    public boolean estaLlenoDeFichas()
    {
        boolean CasillaLlena=true;
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                CasillaLlena=matriz[fila][columna].estaOcupada();
                if(!CasillaLlena)
                {
                    fila=limiteFilas;
                    columna=limiteColumnas;
                }
            }
            limiteColumnas--;
        }
        return CasillaLlena;
    }

    void agregarHuecoDeInicio(int casillaHueco) {
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(casillaHueco))
                {
                    matriz[fila][columna].desocupar();
                    columna=limiteColumnas;
                    fila=limiteFilas;
                }
            }
            limiteColumnas--;
        }
    }
    
    void mostrarTablero()
    {
        reestablecerLimiteColumna();
        String espacioIncrementar="     ";
        String espacio="      ";
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                System.out.print(matriz[fila][columna].mostrarCasilla()+"       ");
            }
            limiteColumnas--;
            System.out.println("\n");
            System.out.print(espacioIncrementar);
            espacioIncrementar+=espacio;
        }
    }

    void moverFicha(int casillaOrigen, int casillaDestino) {
        reestablecerLimiteColumna();
        if(casillaVacia(casillaOrigen) && !casillaVacia(casillaDestino))
        {
            
        }
        
    }

    private boolean casillaVacia(int casillaAVerificar) {
        boolean casillaVacia=false;
        reestablecerLimiteColumna();
        if(casillaAVerificar>0 && casillaAVerificar<=limiteFilas)
        {
            for (int fila = 0; fila < limiteFilas; fila++) {
                for (int columna = 0; columna < limiteColumnas; columna++) {
                    if(matriz[fila][columna].numeroCasillaEs(casillaAVerificar))
                    {
                        if(matriz[fila][columna].estaOcupada())
                        {
                            casillaVacia=true;
                            columna=limiteColumnas;
                            fila=limiteFilas;
                        }
                    }
                }
                limiteColumnas--;
            }
        }
        return casillaVacia;
    }

    private void crearListaCasillas() {
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(columna+2<limiteColumnas)
                    matriz[fila][columna].agregarCasillaALista(columna+2);
                if(columna-2>=0)
                    matriz[fila][columna].agregarCasillaALista(columna-2);
            }
            limiteColumnas--;
        }
    }
}
