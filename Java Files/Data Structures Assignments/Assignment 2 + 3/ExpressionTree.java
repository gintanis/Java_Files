import java.util.Stack;

class ExpressionTree
{

    public class Node {
        public Object element;
        public Node leftChild;
        public Node rightChild;
        
        public Node (Object o) {
            this (o, null, null);
        }
        
        public Node (Object o, Node leftChild, Node rightChild) {
            this.element = o;
            this.leftChild = null;
            this.rightChild = null;
        }
        
        public String toString() {
            return element.toString();
        }     
    }

    Node root; 

    public ExpressionTree(){root = null; }



    public void prefix (Node n)
    {

        if (n != null)
        {
            System.out.print(n.element); 
            prefix(n.leftChild);
            prefix(n.rightChild);
        }
    }
    public void postfix(Node n)
    {
        
        if (n!= null){ 
            postfix(n.leftChild);
            postfix(n.rightChild);
            System.out.print(n.element);

        }

        
       

    }
    public void infix(char[] ch) {
      
        Stack <Node> inStk = new Stack <Node> (); 
        Converter c = new Converter(); 
        Node curr = null; 

        for (int i =0; i< ch.length; i++)
        {
            curr = new Node(ch[i]); 
            if (c.caseSwitch(Character.toString(ch[i])) <= 0)
            {
                inStk.push(curr); 
            }
            else
            {
                curr = new Node ("(" + inStk.pop() + curr + inStk.pop() + ")");
                inStk.push(curr);

            }
        }

        System.out.print("infix: " + curr); 
    
    }

    /* 
        Each node is an operator,
        Each leaf is an operand.
    */

   
    public Node convert (char[] postF)
    {
        ParserHelper p = new ParserHelper();
        ExpressionTree eT = new ExpressionTree(); 
        Stack<Node> stk = new Stack<Node>();
        Node curr = root; 
        Node cL, cR; 
        Converter c = new Converter(); 

       
         

        for (int i = 0 ; i < postF.length; i++ )
        {
            String s = Character.toString(postF[i]);
            if (c.caseSwitch(s) < 0)
            {
                curr = new Node(s);
                stk.push(curr);
            }
            else if(c.caseSwitch(s) == 0)
            {
                curr = new Node(s);
                stk.push(curr);
            }
            else
            {
                curr = new Node(s);
                cR = stk.pop();      
                cL = stk.pop();
                //System.out.println(cL);
                
                curr.leftChild = cL;
                curr.rightChild = cR; 

                

                stk.push(curr); 
            }
            
            
            System.out.println("Root: " + curr + " Left Child: " + curr.leftChild + " Right Child: " + curr.rightChild); 
            System.out.println(""); 
            
            
        }
        curr = stk.peek(); 
        stk.pop(); 


        return curr; 
    }





   

   public static void main (String[] args)
   {
    Converter convertP = new Converter(); 
    ExpressionTree eT = new ExpressionTree(); 
    String e = "(4+8)*(6-5)/((3-2)*(2+2))"; 
    char[] eqArr = convertP.toPostFix(e).toCharArray(); 
    Node root = eT.convert(eqArr); 



 
    System.out.print("prefix: "); 
    eT.prefix(root);

    System.out.println("");

    eT.infix(eqArr);

    System.out.println("");

    System.out.print("postfix: ");
    eT.postfix(root);

 


    
   }
}