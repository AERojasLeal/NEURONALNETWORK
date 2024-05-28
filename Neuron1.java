package NeuronalNetwork;

public class Neuron1 {

    double activacionu;
    double[] entradas;
    double[]  pesos;
    double errorNodo;
    static Sigmoide sigmoide;
    
	
    public Neuron1(int nEntradas ){
        pesos = new double[nEntradas];
        entradas = new double[nEntradas];
        sigmoide = new Sigmoide();
        errorNodo=0;
    }

 
    void activacion(){
        double suma=0;
        for(int i=0;i<entradas.length;i++){
            suma+=entradas[i]*pesos[i];
	}
	activacionu = sigmoide.funcion(suma);
    }
    void verPesos(){
        System.out.print( "****Pesos****\n ");
        for(int i=0;i<entradas.length;i++){
            System.out.print( pesos[i] + "\n ");
        }
    }
    double getActivacion(){
        return activacionu;
    }
    double getError(){
        return errorNodo;
	}
    void setError(double errorNodo){
        this.errorNodo=errorNodo;
    }	
    double getPesos(int i){
        return pesos[i];
    }
    void setPesos(int i, double p){
        pesos[i]=p;
    }	
    double getEntradas(int i){
        return entradas[i];
    }
    void setEntradas(int i, double e){
        entradas[i]=e;
    }	
}
