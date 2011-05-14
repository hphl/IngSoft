
import java.util.ArrayList;
import java.util.List;


class Tablero {

     //List <Casilla> casillas=new ArrayList<Casilla>();
    private int limiteFilas;
    private int limiteColumnas;
    private Casilla matriz[][];

    public Tablero() {
        limiteFilas=5;
        limiteColumnas=5;
        matriz=new Casilla[limiteFilas][limiteColumnas];
        int casillaNueva=1;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                matriz[fila][columna]=new Casilla(casillaNueva);
                casillaNueva++;
            }
            limiteColumnas--;
        }
        limiteColumnas=5;
        crearListaCasillas();
    }
    
    public int cantidadCasillasVacias()
    {
        int copiaLimiteColumnas=limiteColumnas;
        Integer cantidadCasillasVacias=0;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                if(!matriz[fila][columna].estaOcupada())
                    cantidadCasillasVacias++;
            }
            copiaLimiteColumnas--;
        }
        return cantidadCasillasVacias;
    }

    void agregarHuecoDeInicio(int casillaHueco) {
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(casillaHueco))
                {
                    matriz[fila][columna].desocupar();
                    columna=copiaLimiteColumnas;
                    fila=limiteFilas;
                }
            }
            copiaLimiteColumnas--;
        }
    }
    
    String convertirTableroEnString()
    {
        int copiaLimiteColumnas=limiteColumnas;
        String tableroAMostrar="";
        String espacioIncrementar="     ";
        String espacio="      ";
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                tableroAMostrar+=matriz[fila][columna].mostrarCasilla()+espacio;
            }
            copiaLimiteColumnas--;
            tableroAMostrar+="\n"+espacioIncrementar;
            espacioIncrementar+=espacio;
        }
        return tableroAMostrar;
    }

    void moverFicha(int casillaOrigen, int casillaDestino) {
        int copiaLimiteColumnas=limiteColumnas;
        if(casillaDestino>0 && casillaOrigen>0 && casillaDestino<=15 && casillaOrigen<=15)
        {
            if(!casillaVacia(casillaOrigen) && casillaVacia(casillaDestino))
            {
                for (int fila = 0; fila < limiteFilas; fila++) 
                {
                    for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
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
                    copiaLimiteColumnas--;
                }
            }
        }
        
    }

    private boolean casillaVacia(int casillaAVerificar) {
        boolean casillaVacia=true;
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                if(matriz[fila][columna].numeroCasillaEs(casillaAVerificar))
                {
                    if(matriz[fila][columna].estaOcupada())
                    {
                        casillaVacia=false;
                        columna=copiaLimiteColumnas;
                        fila=limiteFilas;
                    }
                }
            }
            copiaLimiteColumnas--;
        }
        return casillaVacia;
    }

    private void crearListaCasillas() {
        
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                if(posicionDentroTablero(columna+2,copiaLimiteColumnas-1))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila][columna+2].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila][columna+1].obtenerNumeroCasilla());
                }
                if(posicionDentroTablero(0,columna-2))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila][columna-2].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila][columna-1].obtenerNumeroCasilla());
                }
                if(posicionDentroTablero(fila+2, limiteFilas-1) && posicionDentroTablero(columna+2, copiaLimiteColumnas-1))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila+2][columna].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila+1][columna].obtenerNumeroCasilla());
                }
                if(posicionDentroTablero(0, fila-2))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila-2][columna].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila-1][columna].obtenerNumeroCasilla());
                }
                if(posicionDentroTablero(fila+2,limiteFilas-1) && posicionDentroTablero(0, columna-2))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila+2][columna-2].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila+1][columna-1].obtenerNumeroCasilla());
                }
                if(posicionDentroTablero(0, fila-2) && posicionDentroTablero(columna+2, copiaLimiteColumnas-1))
                {
                    agregarCasillaMoverse(matriz[fila][columna],matriz[fila-2][columna+2].obtenerNumeroCasilla());
                    agregarCasillaComer(matriz[fila][columna],matriz[fila-1][columna+1].obtenerNumeroCasilla());
                }
            }
            copiaLimiteColumnas--;
        }
    }

    private boolean ocuparCasilla(int casillaDestino,int comerCasilla) {
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) 
        {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
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
            copiaLimiteColumnas--;
        }
        return false;
    }

    private boolean desocuparCasilla(int comerCasilla) {
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) 
        {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
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
            copiaLimiteColumnas--;
        }
        return false;
    }

    private void agregarCasillaMoverse(Casilla casilla, Integer numeroCasillaDestino) {
        casilla.agregarCasillaAListaMoverse(numeroCasillaDestino);
    }

    private void agregarCasillaComer(Casilla casilla, Integer casillaAComer) {
        casilla.agregarCasillaAListaComer(casillaAComer);
    }

    private boolean posicionDentroTablero(int posicionEnTablero, int posicionLimite) {
        if(posicionEnTablero<=posicionLimite)
            return true;
        else
            return false;
    }
    
}
