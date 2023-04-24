/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadeDatos;

import CapadeNegocio.*;

/**
 *Ayudantia Fernandoo
 * @author fernando
 */
public class ADTConjunto {

    //A={5,6,7,8,9,10,11}
    public static void main(String[] args) {
        int VectorOrigen[]={5,6,7,8,9,10,11};
        int VectorCopia[]=new int[VectorOrigen.length];//{0,0,0,0,0,0,0};
        /* arraycopy(VectorOrigen,
                     posicionInicialVectorOrigen,
                     VectorCopia,
                     posicionInicialVectorCopia,
                     Cantidad
                      );
         */
        System.arraycopy(VectorOrigen, 2, VectorCopia, 1, 3);
        for (int i = 0; i < VectorCopia.length; i++) {
            System.out.println("VectorCopia ["+i+"] = "+VectorCopia[i]);
        }
    }
    
}
