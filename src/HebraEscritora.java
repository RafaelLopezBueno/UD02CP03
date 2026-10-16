public class HebraEscritora implements Runnable{
    private VariableCompartida vc;

    public HebraEscritora(VariableCompartida vc){
        this.vc=vc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            vc.establecer(i);
        }
    }
}
