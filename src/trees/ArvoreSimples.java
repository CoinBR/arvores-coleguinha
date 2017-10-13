package trees;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
public class ArvoreSimples
{
	//Atributos da �rvore
	No raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new No(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da �rvore */
	public No root()
	{
		return raiz;
	}
	/** Retorna o n� pai de um n� */
	public No parent(No v)
	{
		return (v.parent());
	}

	/** retorna os filhos de um n� */
	public Iterator children(No v)
	{
		return v.children();
	}
	/** Testa se um n� � interno */
	public boolean isInternal(No v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um n� � externo*/
	public boolean isExternal(No v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um n� � a raiz */
	public boolean isRoot(No v)
	{
		return v == raiz;
	}
	/** Adiciona um filho a um n� */
	public No addChild(No v, Object o)
	{
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
                return novo;
	}
	/** Remove um n�
	 *  S� pode remover n�s externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(No v) throws InvalidNoException
	{
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidNoException();
		Object o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posi��o */
	public void swapElements(No v, No w)
	{
		/*M�todo que serve de exerc�cio
		 * Este m�todo dever� fazer com que o objeto
		 * que estava na posi��o v fique na posi��o w
		 * e fazer com que o objeto que estava na posi��o w
		 * fique na posi��o v
		 */ 
            
            Object tmp = v.element();
            v.setElement(w.element());
            w.setElement(tmp);
            tmp = null;		
	}
	/** Retorna a profundidade de um n� */
	public int depth(No v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(No v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da �rvore */
	public int height()
	{
            return this.getNodeHeight(raiz);
	}
        
        public int getNodeHeight(No node){
            if (this.isExternal(node)){
                return 0;
            }
            int height = 0;
            for(Iterator<No> childIter = node.children(); childIter.hasNext();){
                int childHeight = this.getNodeHeight(childIter.next());
                if (childHeight > height){
                    height = childHeight;
                }
            }
            return 1+height;            
        }
        
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements()
	{
            ArrayList els = new ArrayList();
            for(Iterator<No> nodeIter = this.Nos(); nodeIter.hasNext();){
                els.add(nodeIter.next().element());
            }    
            return els.iterator();
        }
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator Nos()
	{
            return Nos(this.raiz).iterator();               
	}
        
        private Collection Nos(No node){
            ArrayList nodes = new ArrayList();
            nodes.add(node);
            for(Iterator<No> childIter = node.children(); childIter.hasNext();){
                nodes.addAll(this.Nos(childIter.next()));
            }
            return nodes;
        }
        
	/** Retorna o n�mero de n�s da �rvore
	 */
	public int size()
	{
            int i = 0;
            for(Iterator<No> nodesIter = this.Nos(); 
                    nodesIter.hasNext();
                    i++, nodesIter.next()){}
            return i;
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(No v, Object o)
	{
		v.setElement(o);
                return v;
	}
        
        public void print(){
            this.raiz.print();
        }


    private static class InvalidNoException extends Exception {

        public InvalidNoException() {
        }
    }
	/* In�cio da classe aninhada para armazenar o n�*/
	public class No
	{
		private Object o;
		private No pai;
		private Vector filhos = new Vector();
		public No(No pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public No parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(No o)
		{
			filhos.add(o);
		}
		public void removeChild(No o)
		{
			filhos.remove(o);
		}
		public int childrenNumber()
		{
			return filhos.size();
		}
		public Iterator children()
		{
			return filhos.iterator();
		}
                
                public void print() {
                    print("", true);
                }
        
                private void print(String prefix, boolean isTail) {
                    System.out.println(prefix + (isTail ? "└── " : "├── ") + this.element());
                    for (int i = 0; i < filhos.size() - 1; i++) {
                        No filho = (No) filhos.get(i); 
                        filho.print(prefix + (isTail ? "    " : "│   "), false);
                    }
                    if (filhos.size() > 0) {
                        No filho = (No) filhos.get(filhos.size() - 1);
                        filho.print(prefix + (isTail ?"    " : "│   "), true);
                    }
                }                
	}
	/* Fim da classe aninhada para armazenar o n� */
}
