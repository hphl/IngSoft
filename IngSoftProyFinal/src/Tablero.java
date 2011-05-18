
import java.util.ArrayList;
import java.util.List;

class Tablero {
    private int limiteFilas;
    private int limiteColumnas;
    private boolean matrizCasillas[][];
    List <Casilla> casillas=new ArrayList<Casilla>();

    public Tablero() {
        limiteFilas=5;
        limiteColumnas=5;
        matrizCasillas=new boolean[limiteFilas][limiteColumnas];
        crearDatos(limiteColumnas);
    }

    private boolean casillaEstaDentroTablero(int casilla) {
        if(casilla<casillas.size()-1 && casilla>=0)
            return true;
        else
            return false;
    }

    private void crearDatos(int limiteColumnas) {
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < limiteColumnas; columna++) {
                matrizCasillas[fila][columna]=true;
                casillas.add(new Casilla(fila,columna));
            } 
            limiteColumnas--;
        }
    }
    
    public int cantidadCasillasVacias()
    {
        int cantidadCasillasVacias=15;
        int copiaLimiteColumnas=limiteColumnas;
        for (int fila = 0; fila < limiteFilas; fila++) {
            for (int columna = 0; columna < copiaLimiteColumnas; columna++) {
                if(matrizCasillas[fila][columna])
                    cantidadCasillasVacias--;
            }
            copiaLimiteColumnas--;
        }
        return cantidadCasillasVacias;
    }

    public boolean agregarHuecoDeInicio(int huecoInicial) {
        if(casillaEstaDentroTablero(huecoInicial))
        {
            int fila=casillas.get(huecoInicial).obtenerFila();
            int columna=casillas.get(huecoInicial).obtenerColumna();
            matrizCasillas[fila][columna]=false;
            casillas.get(huecoInicial).vacio();
            return true;
        }
        else
            return false;
    }

    public boolean moverFicha(int casillaOrigen, int casillaDestino) {
        if(casillaEstaDentroTablero(casillaOrigen) && casillaEstaDentroTablero(casillaDestino))
        {
            if(!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen))
                if(tratarDeMover(casillaOrigen,casillaDestino))
                {
                    casillas.get(casillaDestino).colocarNuevaFicha(casillas.get(casillaOrigen).obtenerColor());
                    casillas.get(casillaOrigen).vacio();
                    return true;
                }
        }
        return false;
    }

    public boolean casillaOcupada(int casilla) {
        int fila=casillas.get(casilla).obtenerFila();
        int columna=casillas.get(casilla).obtenerColumna();
        
        return matrizCasillas[fila][columna];
    }

    private boolean tratarDeMover(int casillaOrigen, int casillaDestino) {
        int filaOrigen=casillas.get(casillaOrigen).obtenerFila();
        int columnaOrigen=casillas.get(casillaOrigen).obtenerColumna();
        boolean seMovio=true;
        Casilla destinoCasilla=casillas.get(casillaDestino);
        if(!(moverEnFila(filaOrigen,columnaOrigen,destinoCasilla)))
        {
            if(!(moverEnColumna(filaOrigen,columnaOrigen,destinoCasilla)))
            {
                if(!(moverEnDiagonal(filaOrigen,columnaOrigen,destinoCasilla)))
                    seMovio=false;             
            }
        }
        return seMovio;
    }

    String mostrarTablero() {
        String lineaNumeros="";
        String lineaColores="";
        String tablero="";
        String espacio="  ";
        String espacioBase="         ";
        int copiaLimiteColumnas=this.limiteColumnas-1;
        int contadorColumnaLimite=0;
        
        for (int numeroCasilla = 0; numeroCasilla < casillas.size(); numeroCasilla++) {
            int fila=casillas.get(numeroCasilla).obtenerFila();
            int columna=casillas.get(numeroCasilla).obtenerColumna();
            if(numeroCasilla<9)
                lineaNumeros+=" ";
            lineaNumeros+=numeroCasilla+1+"    ";
            if(matrizCasillas[fila][columna])
                lineaColores+=casillas.get(numeroCasilla).obtenerColor();
            else
                lineaColores+=" O    ";
            if(!(numeroCasilla<copiaLimiteColumnas))
            {
                tablero+=espacioBase+lineaColores+"\n"+espacioBase+lineaNumeros+"\n\n";
                espacioBase+=espacio;
                contadorColumnaLimite++;
                copiaLimiteColumnas+=this.limiteColumnas-contadorColumnaLimite;
                lineaNumeros="";
                lineaColores="";
            }
        }
        return tablero;
    }

    private boolean moverEnColumna(int filaOrigen, int columnaOrigen,Casilla casillaDestino) {
        boolean seMovio=true;
        if(casillaDestino.esIgual(filaOrigen+2,columnaOrigen))
        {
            if(matrizCasillas[filaOrigen+1][columnaOrigen])
            {
                matrizCasillas[filaOrigen+1][columnaOrigen]=false;
                matrizCasillas[filaOrigen+2][columnaOrigen]=true;
                matrizCasillas[filaOrigen][columnaOrigen]=false;
            }
        }
        else if(casillaDestino.esIgual(filaOrigen-2, columnaOrigen))
        {
            if(matrizCasillas[filaOrigen-1][columnaOrigen])
            {
                matrizCasillas[filaOrigen][columnaOrigen]=false;
                matrizCasillas[filaOrigen-1][columnaOrigen]=false;
                matrizCasillas[filaOrigen-2][columnaOrigen]=true;
            }
        }
        else
            seMovio=false;
        return seMovio;
    }

    private boolean moverEnFila(int filaOrigen, int columnaOrigen, Casilla destinoCasilla) {
        boolean seMovio=true;
        if(destinoCasilla.esIgual(filaOrigen, columnaOrigen+2))
        {
            if(matrizCasillas[filaOrigen][columnaOrigen+1])
            {
                matrizCasillas[filaOrigen][columnaOrigen]=false;
                matrizCasillas[filaOrigen][columnaOrigen+1]=false;
                matrizCasillas[filaOrigen][columnaOrigen+2]=true;
            }
        }
        else if(destinoCasilla.esIgual(filaOrigen, columnaOrigen-2))
        {
            if(matrizCasillas[filaOrigen][columnaOrigen-1])
            {
                matrizCasillas[filaOrigen][columnaOrigen]=false;
                matrizCasillas[filaOrigen][columnaOrigen-1]=false;
                matrizCasillas[filaOrigen][columnaOrigen-2]=true;
            }
        }
        else
            seMovio=false;
        return seMovio;
    }

    private boolean moverEnDiagonal(int filaOrigen, int columnaOrigen, Casilla destinoCasilla) {
        boolean seMovio=true;
        if(destinoCasilla.esIgual(filaOrigen+2, columnaOrigen-2))
        {
            if(matrizCasillas[filaOrigen+1][columnaOrigen-1])
            {
                matrizCasillas[filaOrigen][columnaOrigen]=false;
                matrizCasillas[filaOrigen+1][columnaOrigen-1]=false;
                matrizCasillas[filaOrigen+2][columnaOrigen-2]=true;
            }
        }
        else if(destinoCasilla.esIgual(filaOrigen-2, columnaOrigen+2))
        {
            if(matrizCasillas[filaOrigen-1][columnaOrigen+1])
            {
                matrizCasillas[filaOrigen][columnaOrigen]=false;
                matrizCasillas[filaOrigen-1][columnaOrigen+1]=false;
                matrizCasillas[filaOrigen-2][columnaOrigen+2]=true;
            }
        }
        else
            seMovio=false;
        return seMovio;
    }
    
}
