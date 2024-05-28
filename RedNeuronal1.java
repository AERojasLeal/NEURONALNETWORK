package NeuronalNetwork;

public class RedNeuronal1 {
    int nodosCapaK;
    int entCapaK;	
    int nodosCapaJ;
    int entCapaJ;
    double L=0.5;
    Neuron1 [] neuronK;
    Neuron1 [] neuronJ;
    static double balance =-1;
    
    public RedNeuronal1(int nodosCapaK, int nodosCapaJ, int entCapaK, int entCapaJ){
        this.nodosCapaK = nodosCapaK;
        this.nodosCapaJ = nodosCapaJ;
        this.entCapaK = entCapaK;
        this.entCapaJ = entCapaJ;
    }
    
 
    int getNodosCapaK(){
        return nodosCapaK;
    }
    int getNodosCapaJ(){
        return nodosCapaJ;
    }
    int getEntCapaK(){
        return entCapaK;
    }
    int getEntCapaJ(){
        return entCapaJ;
    }
    void crearRed(){
        neuronK = new Neuron1[getNodosCapaK()];
        for(int i=0;i<getNodosCapaK();i++){
            neuronK[i] = new Neuron1(getEntCapaK());
	}	
        neuronJ = new Neuron1[getNodosCapaJ()];
	for(int j=0;j<getNodosCapaJ();j++){
            neuronJ[j] = new Neuron1(getEntCapaJ());
		}				
    }
	
    void inicialiaPesos(){
	for(int k=0;k<nodosCapaK;k++){
            for(int i=0;i<entCapaK;i++){
			neuronK[k].setPesos(i,Math.random());
            }
	}
	for(int j=0;j<nodosCapaJ;j++){
            for(int n=0;n<entCapaJ;n++){
                neuronJ[j].setPesos(n,Math.random());
		}		
	}		
    }
/*  
    void predePesos(double pesosJ[][],double pesosK[][]){
	for(int k=0;k<nodosCapaK;k++){
            for(int i=0;i<entCapaK;i++){
			neuronK[k].setPesos(i,pesosK[k][i]);
            }
	}
	for(int j=0;j<nodosCapaJ;j++){
            for(int n=0;n<entCapaJ;n++){
                neuronJ[j].setPesos(n,pesosJ[j][n]);
		}		
	}
    }
*/        
        
    void entradasJ(double capaI[]){
	for(int j=0;j<nodosCapaJ;j++){
            for(int i=0;i<capaI.length;i++){
                neuronJ[j].setEntradas(i,capaI[i]);
            }
	}
    }
    void activacionJ(){
        for(int j=0;j<nodosCapaJ;j++){
            neuronJ[j].activacion();
	}
    }		
    void activacionK(){
        for(int k=0;k<nodosCapaK;k++){
            neuronK[k].activacion();
	}
    }
    void entradasK(){
        int j;
	for(int k=0;k<nodosCapaK;k++){
            for( j=0;j<nodosCapaJ;j++){
                neuronK[k].setEntradas(j , neuronJ[j].getActivacion());
            }
            neuronK[k].setEntradas(j, balance);
	}
    }
    void errorCapaK(double apreder[][], int epoca){
        double errorl;
	for(int k=0;k<nodosCapaK;k++){
            errorl=( apreder[k][epoca]-	neuronK[k].getActivacion())*neuronK[k].	getActivacion()*(1-neuronK[k].getActivacion());	
            neuronK[k].setError(errorl);
	}			
    }
    void pesos_JK(){
        for(int k=0;k<nodosCapaK;k++){
            for(int i=0;i<entCapaK;i++){
                neuronK[k].setPesos( i,neuronK[k].getPesos( i)+(L*neuronK[k].getError()*neuronK[k].getEntradas(i)));
            }	
        }	
    }
    void errorCapaJ(){
        double suma;
	double errj;
	for(int j=0;j<nodosCapaJ;j++){
            suma=0;
            for(int k=0;k<nodosCapaK;k++){
		suma+=neuronK[k].getError()*neuronK[k].getPesos(j);
            }   
            errj=neuronJ[j].getActivacion()*(1- neuronJ[j].getActivacion())*suma;
            neuronJ[j].setError(errj);
	}	
    }		
    void pesos_IJ(){
        for(int j=0;j<nodosCapaJ;j++){
            for(int i=0;i<entCapaJ;i++){
		neuronJ[j].setPesos( i,neuronJ[j].getPesos( i) + (L*neuronJ[j].getError()*neuronJ[j].getEntradas(i)));					
            }		
	}
    }
    double  getEerrorK(){
        double suma=0;
	for(int j=0;j<nodosCapaK;j++){
            suma+=neuronK[j].getError();
	}
	return Math.abs(suma);		
    }
    void verErrorK(){
        System.out.print( "error de Red " + getEerrorK()*100 + "% \n"); 
    }
	
    double getActivacionK(int neuron){
        if( neuronK[neuron].getActivacion() >= 0.5)
            return 1;
       	else
            return 0;
    }
    void verPesos_IJ(){
        System.out.print( "***pesos IJ*** \n");
	for(int j=0;j<nodosCapaJ;j++){
            neuronJ[j].verPesos();
	}
    }	
    void verPesos_JK(){
	System.out.print( "***pesos JK*** \n");
	for(int k=0;k<nodosCapaK;k++){
		neuronK[k].verPesos();
	}
    }
}
