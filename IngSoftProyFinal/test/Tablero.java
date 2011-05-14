
import java.util.ArrayList;
import java.util.List;


class Tablero {
    private int limiteFilas;
    private int limiteColumnas;
    private boolean matriz[][];
    List <Casilla> casillas=new ArrayList<Casilla>();

    public Tablero() {
        limiteFilas=5;
        limiteColumnas=5;
        matriz=new boolean[limiteFilas][limiteColumnas];
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
                matriz[fila][columna]=true;
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
                if(matriz[fila][columna])
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
            matriz[fila][columna]=false;
            return true;
        }
        else
            return false;
    }

    public boolean moverFicha(int casillaOrigen, int casillaDestino) {
        if(casillaEstaDentroTablero(casillaOrigen) && casillaEstaDentroTablero(casillaDestino))
        {
            if(!casillaOcupada(casillaDestino) && casillaOcupada(casillaOrigen))
                return tratarDeMover(casillaOrigen,casillaDestino);
        }
        return false;
    }

    public boolean casillaOcupada(int casilla) {
        int fila=casillas.get(casilla).obtenerFila();
        int columna=casillas.get(casilla).obtenerColumna();
        
        return matriz[fila][columna];
    }

    private boolean tratarDeMover(int casillaOrigen, int casillaDestino) {
        int filaOrigen=casillas.get(casillaOrigen).obtenerFila();
        int columnaOrigen=casillas.get(casillaOrigen).obtenerColumna();
        Casilla casillaDestiny=casillas.get(casillaDestino);
        if(casillaDestiny.esIgual(filaOrigen+2,columnaOrigen))
        {
            if(matriz[filaOrigen+1][columnaOrigen])
            {
                matriz[filaOrigen+1][columnaOrigen]=false;
                matriz[filaOrigen+2][columnaOrigen]=true;
                matriz[filaOrigen][columnaOrigen]=false;
                return true;
            }
        }
        else if(casillaDestiny.esIgual(filaOrigen-2, columnaOrigen))
        {
            if(matriz[filaOrigen-1][columnaOrigen])
            {
                matriz[filaOrigen][columnaOrigen]=false;
                matriz[filaOrigen-1][columnaOrigen]=false;
                matriz[filaOrigen-2][columnaOrigen]=true;
                return true;
            }
        }
        else if(casillaDestiny.esIgual(filaOrigen, columnaOrigen+2))
        {
            if(matriz[filaOrigen][columnaOrigen+1])
            {
                matriz[filaOrigen][columnaOrigen]=false;
                matriz[filaOrigen][columnaOrigen+1]=false;
                matriz[filaOrigen][columnaOrigen+2]=true;
                return true;
            }
        }
        else if(casillaDestiny.esIgual(filaOrigen, columnaOrigen-2))
        {
            if(matriz[filaOrigen][columnaOrigen-1])
            {
                matriz[filaOrigen][columnaOrigen]=false;
                matriz[filaOrigen][columnaOrigen-1]=false;
                matriz[filaOrigen][columnaOrigen-2]=true;
                return true;
            }
        }
        else if(casillaDestiny.esIgual(filaOrigen+2, columnaOrigen-2))
        {
            if(matriz[filaOrigen+1][columnaOrigen-1])
            {
                matriz[filaOrigen][columnaOrigen]=false;
                matriz[filaOrigen+1][columnaOrigen-1]=false;
                matriz[filaOrigen+2][columnaOrigen-2]=true;
                return true;
            }
        }
        else if(casillaDestiny.esIgual(filaOrigen-2, columnaOrigen+2))
        {
            if(matriz[filaOrigen-1][columnaOrigen+1])
            {
                matriz[filaOrigen][columnaOrigen]=false;
                matriz[filaOrigen-1][columnaOrigen+1]=false;
                matriz[filaOrigen-2][columnaOrigen+2]=true;
                return true;
            }
        }
        return false;
    }
    
}
