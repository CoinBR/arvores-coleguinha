/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import trees.ArvoreSimples;
import trees.ArvoreSimples.No;

/**
 *
 * @author coinbr
 */



public class SimpleTreeTest {
  
    public ArvoreSimples getSampleTree(){
        ArvoreSimples t = new ArvoreSimples("0");
        
        t.addChild(t.root(), "0_1a");
        t.addChild(t.root(), "0_1b");
        No _0_1c = t.addChild(t.root(), "0_1c");
        
        t.addChild(_0_1c, "0_1c_2a");
        No _0_1c_2b = t.addChild(_0_1c, "0_1c_2b");
        t.addChild(_0_1c, "0_1c_2c");;
        t.addChild(_0_1c, "0_1c_2d");
        
        No _0_1c_2b_3a = t.addChild(_0_1c_2b, "0_1c_2b_3a");
        t.addChild(_0_1c_2b, "0_1c_2b_3b");
        t.addChild(_0_1c_2b_3a, "0_1c_2b_3a_4a");  
        return t;
    }
    
    @Test
    public void testGetTreeHeight(){
        ArvoreSimples t = new ArvoreSimples("0");
        assertEquals(0, t.height());
        
        t.addChild(t.root(), "0_1a");
        assertEquals(1, t.height());
        t.addChild(t.root(), "0_1b");
        assertEquals(1, t.height());
        No _0_1c = t.addChild(t.root(), "0_1c");
        assertEquals(1, t.height());
        
        t.addChild(_0_1c, "0_1c_2a");
        assertEquals(2, t.height());
        No _0_1c_2b = t.addChild(_0_1c, "0_1c_2b");
        assertEquals(2, t.height());
        t.addChild(_0_1c, "0_1c_2c");
        assertEquals(2, t.height());
        t.addChild(_0_1c, "0_1c_2d");
        assertEquals(2, t.height());
        
        No _0_1c_2b_3a = t.addChild(_0_1c_2b, "0_1c_2b_3a");
        assertEquals(3, t.height());
        t.addChild(_0_1c_2b, "0_1c_2b_3b");
        assertEquals(3, t.height());
        t.addChild(_0_1c_2b_3a, "0_1c_2b_3a_4a");
        assertEquals(4, t.height());
        System.out.println("testGetTreeHeight");
        t.print();
    }
    
    @Test
    public void testGetElements(){
        ArvoreSimples t = this.getSampleTree();
        Iterator it = t.elements();
        assertEquals("0", it.next());
        assertEquals("0_1a", it.next());
        assertEquals("0_1b", it.next());
        assertEquals("0_1c", it.next());
        assertEquals("0_1c_2a", it.next());
        assertEquals("0_1c_2b", it.next());
        assertEquals("0_1c_2b_3a", it.next());
        assertEquals("0_1c_2b_3a_4a", it.next());
        assertEquals("0_1c_2b_3b", it.next());
        assertEquals("0_1c_2c", it.next());
        assertEquals("0_1c_2d", it.next());
        assertEquals(false, it.hasNext());
    }
    
    @Test
    public void testGetSize(){
        ArvoreSimples t = this.getSampleTree();
        assertEquals(11, t.size());
        
        t = new ArvoreSimples('1');
        assertEquals(1, t.size());
    }
      
}


