
class Casilla{

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
        switch(numero){
            case 0:
                colorFicha = " R    ";
                break;
            case 1:
                colorFicha = " B    ";
                break;
            case 2:
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
    String obtenerColor(){
        return colorFicha;
    }

    void cambiarEstado() {
        if(ocupado)
            this.desocupar();
        else
            this.ocupar();
    }

    void clonar(Casilla casilla) {
        ocupado=casilla.ocupado;
        colorFicha=casilla.colorFicha;
    }
}
