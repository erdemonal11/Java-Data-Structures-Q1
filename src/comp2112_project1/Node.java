/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2112_project1;

/**
 *
 * @author emre
 */
public class Node {

    int coeff,power;
    Node next;

    public Node(int coeff, int power) {
        this.coeff = coeff;
        this.power=power;
        next = null;
    }
    
    public Node(){
        
    }
    
    
    public String toString(){
        if(this.power==0){
            return "" + this.coeff;
        }
        return this.coeff + "x" + "^" + this.power + " ";
    }
    
}
