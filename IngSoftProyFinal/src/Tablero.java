
import java.util.ArrayList;
import java.util.List;

class Tablero {
    private int limiteFilas;
    private int limiteColumnas;
    private Casilla matrizCasillas[][];
    private List <CoordenadaCasilla> casillas=new ArrayList<CoordenadaCasilla>();
    
    public Tablero() {
        limiteFilas=5;
        limiteColumnas=5;
        matrizCasillas=new Casilla[limiteFilas][limiteColumnas];
        crearCasillas(limiteColumnas);
    }

    public boolean ganarJuego() {
        return (cantidadCasillasVacias()==casillas.size()-1);
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
        if(casillaEstaDentroTablero(huecoInicial)){
            int fila=casillas.get(huecoInicial).obtenerFila();
            int columna=casillas.get(huecoInicial).obtenerColumna();
            matrizCasillas[fila][columna].desocupar();
            return true;
        }
        else
            return false;
    }
 
    private boolean casillaEstaDentroTablero(int casilla) {
        return (casilla<casillas.size() && casilla>=0);
    }

    public boolean casillaOcupada(int casilla) {
        int fila=casillas.get(casilla).obtenerFila();
        int columna=casillas.get(casilla).obtenerColumna();       
        return matrizCasillas[fila][columna].ocupado();
    }

   public boolean realizarJugada(int casillaOrigen, int casillaDestino) {
        if(verificarCasillaOrigenYDestino(casillaOrigen, casillaDestino) && verificarMovimiento(casillaOrigen, casillaDestino)){
            CoordenadaCasilla casillaAComer=casillas.get(casillaOrigen).comerFicha(casillas.get(casillaDestino));
            cambiarColor(casillas.get(casillaDestino),casillas.get(casillaOrigen));
            actualizarTablero(casillaAComer);
            actualizarTablero(casillas.get(casillaOrigen));
            actualizarTablero(casillas.get(casillaDestino));
            return true;
        }
        return false;
    }

    private String crearFilaColores(int numeroCasilla, String lineaColores) {
        int fila=casillas.get(numeroCasilla).obtenerFila();
        int columna=casillas.get(numeroCasilla).obtenerColumna();
        lineaColores+=matrizCasillas[fila][columna].obtenerColor();
        return lineaColores;
    }

    private String crearFilaNumeros(int numeroCasilla, String lineaNumeros) {
        if(numeroCasilla<9)
            lineaNumeros+=" ";
        lineaNumeros+=(numeroCasilla+1)+"    ";
        return lineaNumeros;
    }

    private boolean verificarCasillaOrigenYDestino(int casillaOrigen, int casillaDestino) {
        if(casillaEstaDentroTablero(casillaOrigen) && casillaEstaDentroTablero(casillaDestino))
            return (!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen));
        return false;
    }

    private boolean verificarMovimiento(int casillaOrigen,int casillaDestino){
        if(casillas.get(casillaOrigen).moverseA(casillas.get(casillaDestino)))
            return sePuedeComerFichaIntermedia(casillaOrigen, casillaDestino);
        return false;
    }
    public String mostrarTablero() {
        String lineaNumeros="";
        String lineaColores="";
        String tablero="";
        String espacio="  ";
        String espacioBase="";
        int copiaLimiteColumnas=this.limiteColumnas-1;
        int contadorColumnaLimite=0;
        
        for (int numeroCasilla = 0; numeroCasilla < casillas.size(); numeroCasilla++) {
            lineaColores = crearFilaColores(numeroCasilla, lineaColores);
            lineaNumeros = crearFilaNumeros(numeroCasilla, lineaNumeros);         
            if(!(numeroCasilla<copiaLimiteColumnas)){
                tablero+=espacio+espacioBase+lineaColores+"\n"+espacio +espacioBase+lineaNumeros+"\n\n";
                espacioBase+=espacio;
                contadorColumnaLimite++;
                copiaLimiteColumnas+=this.limiteColumnas-contadorColumnaLimite;
                lineaNumeros="";
                lineaColores="";
            }
        }
        return tablero;
    }

    public boolean existenMasJugadas() {
        boolean masJugadas=false;
        for (int casillaOrigen = 0; casillaOrigen < casillas.size(); casillaOrigen++) {
            for (int casillaDestino = 0; casillaDestino < casillas.size(); casillaDestino++) {
                if(verificarCasillaOrigenYDestino(casillaOrigen, casillaDestino) && verificarMovimiento(casillaOrigen, casillaDestino))
                {
                    masJugadas=true;
                    casillaOrigen=casillas.size();
                    casillaDestino=casillas.size();
                }
            }
        }
        return masJugadas;
    }

    private void actualizarTablero(CoordenadaCasilla casilla) {
        int fila=casilla.obtenerFila();
        int columna=casilla.obtenerColumna();
        matrizCasillas[fila][columna].cambiarEstado();
    }

    private void cambiarColor(CoordenadaCasilla coordenadaCasillaDestino, CoordenadaCasilla coordenadaCasillaOrigen) {
        int filaDestino=coordenadaCasillaDestino.obtenerFila();
        int columnaDestino=coordenadaCasillaDestino.obtenerColumna();
        int filaOrigen=coordenadaCasillaOrigen.obtenerFila();
        int columnaOrigen=coordenadaCasillaOrigen.obtenerColumna();
        matrizCasillas[filaDestino][columnaDestino].cambiarColor(matrizCasillas[filaOrigen][columnaOrigen]);
    }

    private boolean sePuedeComerFichaIntermedia(int casillaOrigen, int casillaDestino) {
        CoordenadaCasilla coordenadaCasillaAComer=casillas.get(casillaOrigen).comerFicha(casillas.get(casillaDestino));
        int fila=coordenadaCasillaAComer.obtenerFila();
        int columna=coordenadaCasillaAComer.obtenerColumna();
        return matrizCasillas[fila][columna].ocupado();
    }

    String resolverJuego(Tablero tableroConJugada) {
        String mostrarJugadasParaResolverElJuego="";
        Tablero tableroCopiaDelOriginal=new Tablero();
        tableroCopiaDelOriginal.clonar(this);
        
        for (int casillaOrigen = 0; casillaOrigen < casillas.size(); casillaOrigen++) {
            for (int casillaDestino = 0; casillaDestino < casillas.size(); casillaDestino++) {
                if(tableroCopiaDelOriginal.ganarJuego())
                    return "Juego Terminado";
                else if(tableroCopiaDelOriginal.existenMasJugadas()){
                    if(tableroCopiaDelOriginal.realizarJugada(casillaOrigen, casillaDestino)){
                        tableroConJugada.clonar(tableroCopiaDelOriginal);
                        mostrarJugadasParaResolverElJuego=tableroCopiaDelOriginal.resolverJuego(tableroConJugada);
                        if(tableroConJugada.ganarJuego()){
                            mostrarJugadasParaResolverElJuego="mover de "+(casillaOrigen+1)+" a "+(casillaDestino+1)+"\n\n"+tableroCopiaDelOriginal.mostrarTablero()+mostrarJugadasParaResolverElJuego;
                            return mostrarJugadasParaResolverElJuego;
                            
                        }
                        else{
                            mostrarJugadasParaResolverElJuego="mover de "+(casillaOrigen+1)+" a "+(casillaDestino+1)+"\n\n"+tableroCopiaDelOriginal.mostrarTablero()+mostrarJugadasParaResolverElJuego;
                            tableroCopiaDelOriginal.clonar(this);
                        }
                    }
                }
            }
        }
        if(tableroConJugada.cantidadCasillasVacias()==this.cantidadCasillasVacias())
            return "No se  existen mas jugadas...";
        else 
            return mostrarJugadasParaResolverElJuego;
    }
       
    public void clonar(Tablero tableroOriginal) {
        int copiaLimiteColumnas=this.limiteColumnas;
        for (int fila = limiteFilas-1; fila >= 0; fila--) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                matrizCasillas[fila][columna].clonar(tableroOriginal.matrizCasillas[fila][columna]); 
            } 
            copiaLimiteColumnas--;
        }
    }

    public boolean terminoJuego(){
        if(!ganarJuego())
            return (!existenMasJugadas());
        else
            return true;
    }
    public void vaciarTablero() {
        for (int casilla = 0; casilla < casillas.size(); casilla++) {
            int fila=casillas.get(casilla).obtenerFila();
            int columna=casillas.get(casilla).obtenerColumna();
            matrizCasillas[fila][columna].desocupar();
        }
    }
 
}
