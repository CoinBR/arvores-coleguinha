/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author coinbr
 */
public class Comparator {

    public Comparator() {
    }
        
    public int getMin(Object a, Object b){
        return 0;
    }
    
    public int getMax(int a, int b){
        if (a > b){
            return a; 
        }
        return b;
    }   
}
