

public class HuffmanTree
{
    HuffmanNode root;


    public HuffmanTree(HuffmanNode huff)
    {
        this.root = huff; 
    }

    public void printLegend(){
        this.printLegend(this.root, " ");

    }

    public static void printLegend(HuffmanNode t, String s)
    {
        // assign 0 and 1 to elements
        if( t.letter.length() > 1 )
		{
            
			printLegend( t.left, s + "0");
			printLegend( t.right, s + "1" );
		}
		else
		{
			System.out.println( t.letter + " = " + s + " " );
		}
    }

    public static BinaryHeap legendToHeap(String legend)
    {

        
        String[] key = legend.split(" "); 
        HuffmanNode[] huffs = new HuffmanNode[key.length / 2];
        int i = 0; 
        int j = 0;
        
        while (i < key.length)
        {
            huffs[j] = new HuffmanNode(key[i], key[i + 1]); 

            i = i + 2; 
            j++; 
        }


        BinaryHeap heap = new BinaryHeap(huffs);
        System.out.println(heap);  
        return heap; 
       
      
        
    }

    public static HuffmanTree createFromHeap(BinaryHeap b)
    {
       
        while (b.getSize() > 1)
        {
            HuffmanNode huff1 = (HuffmanNode) b.deleteMin(); 
            HuffmanNode huff2 = (HuffmanNode) b.deleteMin(); 
            HuffmanNode huff = (HuffmanNode) new HuffmanNode(huff1, huff2); 
            b.insert(huff);
        }
        HuffmanTree t = new HuffmanTree((HuffmanNode) b.deleteMin()); 
        return t; 
    }

   

    public static void main(String[] args)
    {
        String testLegend = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2"; 
        BinaryHeap bH = HuffmanTree.legendToHeap(testLegend); 
        HuffmanTree hT = HuffmanTree.createFromHeap(bH); 
        hT.printLegend();
    }

 
    // public HuffmanTree(HuffmanNode huff)
    // public void printLegend()
    // public static BinaryHeap legendToHeap(String legend)
    // public static HuffmanTree createFromHeap(BinaryHeap b)
    // public static void main(String[] args)
}
