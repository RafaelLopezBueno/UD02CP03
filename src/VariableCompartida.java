public class VariableCompartida {
    private int i=0;
    private boolean hayValor=false;

    // Sin synchronized/wait la lectora se perdia valores (escribia mas rapido de lo que leia).
    // Ahora la escritora espera a que se lea el valor anterior antes de escribir otro.
    public synchronized void establecer(int valor){
        while (hayValor) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.i=valor;
        hayValor=true;
        notifyAll();
    }

    // La lectora espera a que haya un valor nuevo antes de leer.
    public synchronized int obtener(){
        while (!hayValor) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hayValor=false;
        notifyAll();
        return i;
    }
}
