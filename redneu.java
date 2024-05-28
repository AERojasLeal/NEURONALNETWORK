package NeuronalNetwork;
public class redneu {
    static RedNeuronal1 redNeuronal = new RedNeuronal1(1,2,3,3);
    static double capaI[][]  = {{1,1,-1}, // {epoca}{entradas}
                                {0,0,-1},
                                {1,0,-1},
                                {0,1,-1}};
    static double aprender[][] = {{0,0,1,1}};  //[0][epoca]
/*
    static double pesosJ[][] = {{1.1503048374891909, 1.3891955254342272,-0.4969160060605727},
                                {-0.42336426457520077, -0.497115161751244, 0.10365610093343036}};
    static double pesosK[][] = {{ 0.4990035887707379, 1.0046368492717503, 0.7881761794837765}};
*/
    public static void main(String[] args) {
       
        redNeuronal.crearRed();
        redNeuronal.inicialiaPesos();
//        redNeuronal.predePesos(pesosJ,pesosK);

        int n=1000000;
	int i=0;
	int k=0;
	int epoca;
        
	while( i<capaI.length && k<n){
            epoca=i;
            System.out.println("*** epoca***" + epoca + " ***iter***" + k);
            System.out.println("***entradas " + capaI[epoca][0] + " , " + capaI[epoca][1] + "***aprender***" + aprender[0][epoca] );
            redNeuronal.entradasJ(capaI[epoca]);
            redNeuronal.activacionJ();
            redNeuronal.entradasK();
            redNeuronal.activacionK();
            
            redNeuronal.errorCapaK(aprender,epoca);
            if(redNeuronal.getActivacionK(0) == aprender[0][epoca]){	
                }else
                    {
                    i=-1;
                    redNeuronal.pesos_JK();
                    redNeuronal.errorCapaJ();
                    redNeuronal.pesos_IJ();
                    }		
            i++;
            k++;
	}
        redNeuronal.verPesos_IJ();
        redNeuronal.verPesos_JK();
        redNeuronal.verErrorK();
    }
}