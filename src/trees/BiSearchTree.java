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
public class BiSearchTree {
    
    private BiNode root;
    private Comparator c;

    public BiSearchTree(Object element) {
        this.root = new BiNode(element);
        this.c = new Comparator();
    }
   /* 
    
    private void insert(BiNode node, Object element) {
           if (node != null) {
            if (element == this.c.getMin(element, node.getElement()) {
                if (node.getLeft() != null) {
                    inserir(node.getLeft(), valor);
                } else {
                    System.out.println("  Inserindo " + valor + " a getLeft() de " + BiNodede.valor);
                    BiNodede.getLeft() = new BiNode(valor);
                }
            } else if (valor > BiNodede.valor) {
                if (BiNodede.getRight() != null) {
                    inserir(BiNodede.getRight(), valor);
                } else {
                    System.out.println("  Inserindo " + valor + " a getRight() de " + BiNodede.valor);
                    BiNodede.getRight() = new BiNode(valor);
                }
            }
          }
        }     
    */
    
    
    
}
