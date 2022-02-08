
public class BT
{
    // 1) node constructor
    class Node 
    {
        Node left;
        Node right;
        Node parent;
        int element;
        
        public Node (int item)
        {
            this.element = item; 
            left = right = null; 
        }
    }
    
    // 2) constructor
    public BT ()
    {
        
    }

    Node makeBST(int[] arr, int start, int end)
    {
         if (start > end) {

            return null;

        }
        
        // make middle = root
        
        int middle = (start + end) / 2;
        Node node = new Node(arr[middle]);
        
        node.left = makeBST(arr, start, middle - 1);
        node.right = makeBST(arr, middle + 1, end);

         

        return node;
        
    }

    void inOrder(Node node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.element + " ");
        inOrder(node.right);

    }



    public static void main(String[] args) {
        Node root = null; 
    
        BT tree = new BT();

        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};

        int n = arr.length;

        root = tree.makeBST(arr, 0, n - 1);
        tree.inOrder(root);

    }
}
