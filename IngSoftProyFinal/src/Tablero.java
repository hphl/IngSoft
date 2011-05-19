
import java.util.ArrayList;
import java.util.List;

class Tablero {
    private int limiteFilas;
    private int limiteColumnas;
    private Casilla matrizCasillas[][];
    List <CoordenadaCasilla> casillas=new ArrayList<CoordenadaCasilla>();

    public Tablero() {
        limiteFilas=5;
        limiteColumnas=5;
        matrizCasillas=new Casilla[limiteFilas][limiteColumnas];
        crearCasillas(limiteColumnas);
    }

    private void crearCasillas(int limiteColumnas) {
        for (int fila = limiteFilas-1; fila >= 0; fila--) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                matrizCasillas[fila][columna]=new Casilla();
                casillas.add(new CoordenadaCasilla(fila,columna));  
            } 
            limiteColumnas--;
        }
    }
   
    public int cantidadCasillasVacias(){
        int cantidadCasillasVacias=0;
        for (int casilla = 0; casilla < casillas.size(); casilla++) {
            int filaCasilla=casillas.get(casilla).obtenerFila();
            int columnaCasilla=casillas.get(casilla).obtenerColumna();
            if (!(matrizCasillas[filaCasilla][columnaCasilla].ocupado())) {
                cantidadCasillasVacias++;
            }
        }
        return cantidadCasillasVacias;
    }

    public boolean agregarHuecoDeInicio(int huecoInicial) {
        if(casillaEstaDentroTablero(huecoInicial))
        {
            int fila=casillas.get(huecoInicial).obtenerFila();
            int columna=casillas.get(huecoInicial).obtenerColumna();
            matrizCasillas[fila][columna].desocupar();
            return true;
        }
        else
            return false;
    }
 
    private boolean casillaEstaDentroTablero(int casilla) {
        if(casilla<casillas.size() && casilla>=0)
            return true;
        else
            return false;
    }

    public boolean casillaOcupada(int casilla) {
        int fila=casillas.get(casilla).obtenerFila();
        int columna=casillas.get(casilla).obtenerColumna();
        
        return matrizCasillas[fila][columna].ocupado();
    }

   public boolean moverFicha(int casillaOrigen, int casillaDestino) {
        if(casillaEstaDentroTablero(casillaOrigen) && casillaEstaDentroTablero(casillaDestino))
        {
            if(!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen))
            {
                if(casillas.get(casillaOrigen).moverseA(casillas.get(casillaDestino)))
                {
                    CoordenadaCasilla casillaAComer=casillas.get(casillaOrigen).comerFicha(casillas.get(casillaDestino));
                    cambiarColor(casillas.get(casillaDestino),casillas.get(casillaOrigen));
                    actualizarTablero(casillaAComer);
                    actualizarTablero(casillas.get(casillaOrigen));
                    actualizarTablero(casillas.get(casillaDestino));
                    return true;
                }
            }
        }
        return false;
    }

    String mostrarTablero() {
        String lineaNumeros="";
        String lineaColores="";
        String tablero="";
        String espacio="";
        String espacioBase="";
        int copiaLimiteColumnas=this.limiteColumnas-1;
        int contadorColumnaLimite=0;
        
        for (int numeroCasilla = 0; numeroCasilla < casillas.size(); numeroCasilla++) {
            int fila=casillas.get(numeroCasilla).obtenerFila();
            int columna=casillas.get(numeroCasilla).obtenerColumna();
            if(numeroCasilla<9)
                lineaNumeros+=" ";
            lineaNumeros+=numeroCasilla+1+"    ";
            lineaColores+=matrizCasillas[fila][columna].obtenerColor();
            if(!(numeroCasilla<copiaLimiteColumnas))
            {
                tablero+=espacio+espacioBase+lineaColores+"\n"+espacio +espacioBase+lineaNumeros+"\n\n";
                espacio="  ";
                espacioBase+=espacio;
                contadorColumnaLimite++;
                copiaLimiteColumnas+=this.limiteColumnas-contadorColumnaLimite;
                lineaNumeros="";
                lineaColores="";
            }
        }
        return tablero;
    }

    boolean perdio() {
        boolean perdio=true;
        for (int casillaOrigen = 0; casillaOrigen < casillas.size(); casillaOrigen++) {
            for (int casillaDestino = 0; casillaDestino < casillas.size(); casillaDestino++) {
                    if(!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen))
                    {
                        if(this.tratarDeMover(casillaOrigen, casillaDestino))
                        {
                            perdio=false;
                            casillaOrigen=casillas.size();
                            casillaDestino=casillas.size();
                        }
                    }
            }
        }
        return perdio;
    }

    private void actualizarTablero(CoordenadaCasilla casilla) {
        int fila=casilla.obtenerFila();
        int columna=casilla.obtenerColumna();
        if(matrizCasillas[fila][columna].ocupado())
            matrizCasillas[fila][columna].desocupar();
        else
            matrizCasillas[fila][columna].ocupar();
    }

    private void cambiarColor(CoordenadaCasilla coordenadaCasillaDestino, CoordenadaCasilla coordenadaCasillaOrigen) {
        int filaDestino=coordenadaCasillaDestino.obtenerFila();
        int columnaDestino=coordenadaCasillaDestino.obtenerColumna();
        int filaOrigen=coordenadaCasillaOrigen.obtenerFila();
        int columnaOrigen=coordenadaCasillaOrigen.obtenerColumna();
        matrizCasillas[filaDestino][columnaDestino].cambiarColor(matrizCasillas[filaOrigen][columnaOrigen]);
    }

    private boolean tratarDeMover(int casillaOrigen, int casillaDestino) {
        if(casillaEstaDentroTablero(casillaOrigen) && casillaEstaDentroTablero(casillaDestino))
        {
            if(!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen))
            {
                if(casillas.get(casillaOrigen).moverseA(casillas.get(casillaDestino)))
                {
                    CoordenadaCasilla coordenadaCasillaAComer=casillas.get(casillaOrigen).comerFicha(casillas.get(casillaDestino));
                    int fila=coordenadaCasillaAComer.obtenerFila();
                    int columna=coordenadaCasillaAComer.obtenerColumna();
                    if(matrizCasillas[fila][columna].ocupado())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void resolverJuego() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
