package trees.util;

public class Node {

    public Node left;
    public Node right;

    public int value;
    
    public Node(int val) {
        this.value = val;
    }

    /** 
     * helper method to print the values in the tree in In-Order Traverse (LCR) - ascending order. 
     */
    public void printInOrder() {

        if (this.left != null)
            this.left.printInOrder();

        System.out.print(this.value + " ");
        
        if (this.right != null)
            this.right.printInOrder();
    }

    /** 
     * helper method to print the values in the tree in pre-Order Traverse (CLR).
     */
    public void printPreOrder() {

        System.out.print(this.value + " ");

        if (this.left != null)
            this.left.printPreOrder();
        
        if (this.right != null)
            this.right.printPreOrder();
    }


    /** 
     * helper method to print the values in the tree in post-Order Traverse (LRC). 
     */
    public void printPostOrder() {

        if (this.left != null)
            this.left.printPostOrder();
        
        if (this.right != null)
            this.right.printPostOrder();

        System.out.print(this.value + " ");
    }

    

}
