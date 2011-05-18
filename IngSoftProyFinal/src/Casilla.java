


class Casilla {
    private int fila;
    private int columna;
    private String colorFicha="";

    public Casilla() {
        fila=0;
        columna=0;
    }

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        crearColor();
    }

    int obtenerFila() {
        return fila;
    }

    int obtenerColumna() {
        return columna;
    }

    boolean esIgual(int fila, int columna) {
        if(this.fila==fila && this.columna==columna)
            return true;
        else
            return false;
    }

    private void crearColor() {
        int numero=0;
        do {
            numero=(int) Math.round((Math.random()*10)); 
        } while (numero>2);
        switch(numero+1)
        {
            case 1:
                colorFicha = " R    ";
                break;
            case 2:
                colorFicha = " B    ";
                break;
            case 3:
                colorFicha = " A    ";
                break;
        }
    }

    String obtenerColor() {
        return colorFicha;
    }

    void vacio() {
        colorFicha=" O    ";
    }

    void colocarNuevaFicha(String nuevoColorFicha) {
        colorFicha=nuevoColorFicha;
    }
    
}
