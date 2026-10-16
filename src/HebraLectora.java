public class HebraLectora implements Runnable{
    private VariableCompartida vc;

    public HebraLectora(VariableCompartida vc){
        this.vc=vc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            System.out.println("Valor de vc="+vc.obtener());
        }
    }
}
