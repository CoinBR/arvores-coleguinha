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
public class BiNode {
    private Object el;
    private BiNode left;
    private BiNode right;
    
    public BiNode(Object element){
        this.el = element;
        this.left = null;
        this.right = null;
    }
    
    public void swapElements(BiNode target){
        Object tmp = this.getElement();
        this.setElement(target.getElement());
        target.setElement(tmp);  
        
    }

    public Object getElement() {
        return el;
    }

    public void setElement(Object el) {
        this.el = el;
    }

    public BiNode getLeft() {
        return left;
    }

    public void setLeft(BiNode left) {
        this.left = left;
    }

    public BiNode getRight() {
        return right;
    }

    public void setRight(BiNode right) {
        this.right = right;
    }
    
    
           
}
