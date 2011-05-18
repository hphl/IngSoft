
class Casilla {

    private boolean ocupado;
    private String colorFicha;
    
    public Casilla() {
        ocupado=true;
        crearColor();
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

    boolean ocupado() {
        return ocupado;
    }

    void desocupar() {
        ocupado=false;
        colorFicha=" O    ";
    }

    void ocupar() {
        ocupado=true;
    }

    void cambiarColor(Casilla casilla) {
        colorFicha=casilla.colorFicha;
    }
    String obtenerColor()
    {
        return colorFicha;
    }
}
