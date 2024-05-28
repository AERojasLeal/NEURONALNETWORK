package NeuronalNetwork;

public class Sigmoide {
double e;
double p;
	
public  Sigmoide(){
    p=1;
    e=Math.E;
    }	
double funcion(double a){
     return(  1/( 1 + Math.pow( e , -a/p)));	
    }
}
