class Solution
{
    
    public Node getRightMostNode(Node node, Node curr)
    {
        while(node.right!=null && node.right != curr)
        {
            node = node.right;
        }
        return node;
    }

    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	   Node dummy = new Node(-1);
	   Node curr  = root, prev =dummy;
	   while(curr != null)
	   {
	       Node left = curr.left;
	       if(left == null)
	       {
	           prev.right = curr;
	           curr.left = prev;
	           prev = prev.right;
	           curr = curr.right;
	       }
	       
	       else
	       {
	           Node rightMostNode = getRightMostNode(left,curr);
	           if(rightMostNode.right == null)
	           {
	               rightMostNode.right = curr;
	               curr = curr.left;
	           }
	           
	           else
	           {
	               rightMostNode.right = null;
	               prev.right =curr;
	               curr.left = prev;
	               prev = prev.right;
	               curr = curr.right;
	           }
	       }
	   }
	   
	   Node head = dummy.right;
	   dummy.right = head.left =null;
       /* for circular dublly linked list
           head.left =prev;
           prev.right = head;
            
         
        */
       
	   return head;
    }
}