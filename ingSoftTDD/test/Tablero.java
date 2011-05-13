
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
        if(casillaDestino>0 && casillaOrigen>0 && casillaDestino<=15 && casillaOrigen<=15)
        {
            if(!casillaVacia(casillaOrigen) && casillaVacia(casillaDestino))
            {
                reestablecerLimiteColumna();
                for (int fila = 0; fila < limiteFilas; fila++) 
                {
                    for (int columna = 0; columna < limiteColumnas; columna++) {
                        if(matriz[fila][columna].numeroCasillaEs(casillaOrigen))
                        {
                            if(matriz[fila][columna].moverseA(casillaDestino)!=-1)
                            {
                                if(ocuparCasilla(casillaDestino,matriz[fila][columna].moverseA(casillaDestino)))
                                {
                                    matriz[fila][columna].desocupar();
                                }
                            }
                        }
                    }
                    limiteColumnas--;
                }
            }
        }
        
    }

    private boolean casillaVacia(int casillaAVerificar) {
        boolean casillaVacia=true;
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(casillaAVerificar))
                {
                    if(matriz[fila][columna].estaOcupada())
                    {
                        casillaVacia=false;
                        columna=limiteColumnas;
                        fila=limiteFilas;
                    }
                }
            }
            limiteColumnas--;
        }
        return casillaVacia;
    }

    private void crearListaCasillas() {
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(columna+2<limiteColumnas)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila][columna+2].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaComer(matriz[fila][columna+1].obtenerNumeroCasilla());
                }
                if(columna-2>=0)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila][columna-2].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaComer(matriz[fila][columna-1].obtenerNumeroCasilla());
                }
                if(fila+2<limiteFilas && columna+2<limiteColumnas)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila+2][columna].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila+1][columna].obtenerNumeroCasilla());
                }
                if(fila-2>=0)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila-2][columna].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila-1][columna].obtenerNumeroCasilla());
                }
                if(fila+2<limiteFilas && columna-2>=0)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila+2][columna-2].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila+1][columna-1].obtenerNumeroCasilla());
                }
                if(fila-2>=0 && columna+2<limiteColumnas)
                {
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila-2][columna+2].obtenerNumeroCasilla());
                    matriz[fila][columna].agregarCasillaAListaMoverse(matriz[fila-1][columna+1].obtenerNumeroCasilla());
                }
            }
            limiteColumnas--;
        }
    }

    private boolean ocuparCasilla(int casillaDestino,int comerCasilla) {
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) 
        {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(casillaDestino))
                {
                    if(matriz[fila][columna].estaOcupada())
                        return false;
                    else
                    {
                        if(desocuparCasilla(comerCasilla))
                        {
                            matriz[fila][columna].ocupar();
                            return true;
                        }
                        else 
                            return false;
                    }
                }
            }
            limiteColumnas--;
        }
        return false;
    }

    private boolean desocuparCasilla(int comerCasilla) {
        reestablecerLimiteColumna();
        for (int fila = 0; fila < limiteFilas; fila++) 
        {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(comerCasilla))
                {
                    if(matriz[fila][columna].estaOcupada())
                    {
                        matriz[fila][columna].desocupar();
                        return true;
                    }
                    else
                        return false;
                }
            }
            limiteColumnas--;
        }
        return false;
    }
}
