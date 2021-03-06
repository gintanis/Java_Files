// Import the File class
// Import this class to handle errors
import java.io.*;
import java.util.*; 
public class HuffmanConverter
{

    // the size of the count[] & code[] arrays.
    public static final int NUMBER_OF_CHARACTERS = 256;
    // the contents of our message...
    private String contents;
    // the tree created from the msg
    private HuffmanTree huffmanTree;
    // tracks how often each character occurs
    private static int count[];
    // the huffman code for each character
    private String code[];
    // stores the # of unique chars in contents
    private int uniqueChars = 0;

    public HuffmanNode root; 

    public HuffmanConverter(){}
    public HuffmanConverter(HuffmanNode huff){ this.root = huff;} 

    public HuffmanConverter(String input)
    {
        this.contents = input;
        this.count = new int[NUMBER_OF_CHARACTERS];
        this.code = new String[NUMBER_OF_CHARACTERS];
    }



    /**
    * Records the frequencies that each character of our
    * message occurs...
    * I.e., we use 'contents' to fill up the count[] list...
     * @throws IOException
    */
    public void recordFrequencies() throws IOException
    { 
        FileReader myFile; 
        BufferedReader rd = new BufferedReader(new FileReader("love_poem_58.txt")); 
        String line = rd.readLine();
        int value = 0; 
        HashMap<Integer, Integer> hash = new HashMap<>();


        int i = 0; 
        char temp = ' '; 
        while (line != null) 
        {
            
            for (char c : line.toCharArray())
            {
               
                if (c != ' ')
                {
                    value = hash.getOrDefault((int) c, 0);
                    hash.put((int) c, value + 1);
                }
                
            }
            line = rd.readLine(); 
        }
        count = new int[(hash.size()*2)]; 
        int j = 0; 
        for (i = count.length-2; i >= 0; i-=2)
        {
            this.count[i+1] =  (int) hash.values().toArray()[j]; 
            this.count[i] =  (int) hash.keySet().toArray()[j]; 
            
            


            System.out.println("Key: " + count[i] + " and Frequency: " + count[i+1]); 
           
            j++; 
        }
        System.out.println(Arrays.toString(count)); 
      



    }
    
    
    public void frequenciesToTree(){

        String s = ""; 
        HuffmanNode[] huffs = new HuffmanNode[count.length];
        int j = 0; 
        for (int i = huffs.length-2; i >=0; i-=2)
        {
            char c = (char) count[i]; 
            String d = String.valueOf(count[i+1]); 
          
            
            huffs[j] = new HuffmanNode(String.valueOf(c), d);

            System.out.println(huffs[j]);
            s += c + " " + d + " "; 
            j++;
            
        }


    }



     /**
    * Iterates over the huffmanTree to get the code for each letter.
    * The code for letter i gets stored as code[i]... This method
    * behaves similarly to HuffmanTree's printLegend() method...
    * Warning: Don't forget to initialize each code[i] to ""
    * BEFORE calling the recursive version of treeToCode...
    */
    public void treeToCode()
    { 

       System.out.println(this.root); 
        this.treeToCode(this.root, " ");
     

    }


       /*
        * A private method to iterate over a HuffmanNode t using s, which
        * contains what we know of the HuffmanCode up to node t. This is
        * called by treeToCode(), and resembles the recursive printLegend
        * method in the HuffmanTree class. Note that when t is a leaf node,
        * t's letter tells us which index i to access in code[], and tells
        * us what to set code[i] to...
        */
    private void treeToCode(HuffmanNode t, String s)
    {   
    
        if( t.letter.length() > 1 )
		{
            
			treeToCode( t.left, s + "0");
			treeToCode( t.right, s+ "1" );


		}
		else
		{
          
			System.out.println( t.letter + " = " + s + " " );
            
		}
      
    }

     /**
        * Using the message stored in contents, and the huffman conversions
        * stored in code[], we create the Huffman encoding for our message
        * (a String of 0's and 1's), and return it...
        */
    public String encodeMessage()
    {  
        return null; 
    }
      /**
        * Reads in the contents of the file named filename and returns
        * it as a String. The main method calls this method on args[0]...
        */

    public static String readContents(String filename)
    {   
        return null; 
    }

       /*
        * Using the encoded String argument, and the huffman codings,
        * re-create the original message from our
        * huffman encoding and return it...
        */
    public String decodeMessage(String encodedStr)
    {
        return null; 
    }
    public static void main(String args[]) throws IOException
    {
    //call all your methods from h

        HuffmanConverter hC = new HuffmanConverter();
        HuffmanTree hT = new HuffmanTree(root);
        hC.recordFrequencies();
        hC.frequenciesToTree();

        try{
            String s = Arrays.toString(count).replaceAll("[/,/]", " "); 
            System.out.println(s); 

            BinaryHeap bH = HuffmanTree.legendToHeap(s); 

            HuffmanTree hT = HuffmanTree.createFromHeap(bH); 
            hT.printLegend();
        }
        catch (NumberFormatException nfe)
        {
            throw new NumberFormatException(); 
        }
  
        


    }





}