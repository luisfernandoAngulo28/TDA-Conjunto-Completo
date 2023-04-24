/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadeNegocio;

/**
 * Ayudantia
 * pasos
 *1.Atributos
 *2.Constructor
 *3.setters
 *4.getters
 *5.toString
 * 
 * @author fernando
 */
public class Conjunto {
    //Atributos
    int C[];
    int dim;
    //Constructo
    
    public Conjunto(int cant) {
      this.C=new int[cant];
       this.dim=-1;
      
        
    }
    //setters
    /*
    //Insertar un elemento al conjunto
    Void Insertar(elem)
    Pre://El conjunto no esta lleno
          //El elemento no debe pertenecer al Conjunto
    Post:El Conjunto se Modifica
    */
    public void insertar(int elemento){
       if(!Llena()){
          if(!Pertenece(elemento)){
              dim++;
              C[dim]=elemento;
          } 
       }else{
           System.out.println("Error::Insertar: el Conjunto ya esta lleno");
           System.exit(1); 
       } 
    }

    public  boolean Pertenece(int elemento) {
     int posicion=0;
        while ((posicion<=dim) &&(C[posicion]!=elemento)) {            
            posicion++;
        }
        return (posicion<=dim);
    }

    public  boolean Llena() {
        return (dim==C.length-1);
    }
    public  boolean Vacia() {
        return (dim==-1);
    }
    
    
    public int obtenerElemento(int pos){
        return this.C[pos];
    }
    //A={2,3,4,5,6}
    //B={5,6,7,8,9,10,11}
    //AUB={2,3,4,5,6,7,8,9,10,11}
    public void union(Conjunto A,Conjunto B){
        for (int i = 0; i <= A.dim; i++) {
             insertar(A.C[i]);
             //AUB={2,3,4,5,6}
        }
        for (int j = 0; j <= B.dim; j++) {
            insertar(B.obtenerElemento(j));
            //AUB={2,3,4,5,6,7,8,9,10,11}
        }
    }
    //----------------------------------------------------
    //A={2,3,4,5,6}
    //B={5,6,7,8,9,10,11}
    //AIB={5,6}
    public void interseccion(Conjunto A,Conjunto B){
        for (int i = 0; i <= A.dim; i++) {
            if (B.Pertenece(A.obtenerElemento(i))) {
                insertar(A.obtenerElemento(i));
            }
        }
    }
    
    
    public void redimencionar(){
        if (Llena()) {//A={2,3,4,5,6}
            int conjuntoAuxiliar[]=new int[C.length]; 
            System.arraycopy(C, 0, conjuntoAuxiliar, 0, C.length);
            C=new int [conjuntoAuxiliar.length+10];
            System.arraycopy(conjuntoAuxiliar, 0, C, 0, conjuntoAuxiliar.length);
        }
    }
    
    //toString
    @Override
    public String toString(){
        String Salida="{";
        for (int i = 0; i <= dim; i++) {
            Salida=Salida+C[i]+",";
        }
        Salida=Salida.substring(0, Salida.length()-1);
        return Salida+"}";
    }
    
    public static void main(String[] args) {
        Conjunto conjuntoA=new Conjunto(20);
        for (int i = 2; i < 7; i++) {
            conjuntoA.insertar(i);
        }
        System.out.println("A="+conjuntoA.toString());
        //Salida 
        //A={2,3,4,5,6}
         Conjunto conjuntoB=new Conjunto(8);
        for (int i = 5; i < 12; i++) {
            conjuntoB.insertar(i);
        }
        System.out.println("B="+conjuntoB.toString());
        //B={5,6,7,8,9,10,11}
        Conjunto conjuntoC=new Conjunto(20);
        conjuntoC.interseccion(conjuntoA, conjuntoB);
         System.out.println("AIB="+conjuntoC.toString());
         
        
    }
    
    
    
    
    
    
    
    
    
    
}
