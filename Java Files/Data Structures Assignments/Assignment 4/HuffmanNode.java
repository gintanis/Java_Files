public class HuffmanNode implements Comparable
{
    public String letter;
    public Double frequency;
    public HuffmanNode left, right;
    // public HuffmanNode(String letter, Double frequency)
    // public HuffmanNode(HuffmanNode left, HuffmanNode right)
    // public int compareTo(Object o)
    // public String toString()

    public int compareTo(Object o) {
        HuffmanNode huff = (HuffmanNode) o; 
        return this.frequency.compareTo(huff.frequency);
    }
    public HuffmanNode(String letter, Double frequency)
    {
        this.letter = letter;
        this.frequency = frequency;
    }
    public HuffmanNode(String letter, String frequency)
    {
        Double freq = Double.parseDouble(frequency) ;
        this.letter = letter; 
        this.frequency = freq; 
 
    }
 
    public HuffmanNode(HuffmanNode left, HuffmanNode right){
       this.letter = left.letter + right.letter; 
       this.frequency = left.frequency + right.frequency; 
       this.left = left; 
       this.right = right; 
    }

    public String toString()
    {
        return "<" + this.letter + ", " + this.frequency + ">";
    }
}