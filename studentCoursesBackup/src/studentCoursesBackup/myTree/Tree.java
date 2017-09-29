package manav_panchal_assign_2;

public class Tree {

	
	Node root;
	
	
	public Tree(){
		
		root = null;
	}
	 void insertrec(Node n) {
	       root = insert(n,root);
	    }
	
	Node insert(Node node,Node root){
		
		//System.out.println(node.B_num);
		if(root == null){
			
			
			root = node;
			//System.out.println(root.B_num);
			return root;
		}
		//System.out.println("A"+node.B_num);
		//System.out.println("B-"+root.B_num);
		
		if(node.B_num < root.B_num){
			//System.out.println("A");
			root.left = insert(node,root.left);
		}else if(node.B_num > root.B_num){
			
			root.right = insert(node,root.right);
		}else if(node.B_num == root.B_num){
			
			//System.out.println("--"+node.courses.get(0));
			int index = root.courses.indexOf(node.courses.get(0));
			if(index  < 0){
			root.courses.add(node.courses.get(0));
		}
		}
		return root;
		
	}
	 void delete(Node node)
	    {
	        root = deleteRec(node, root);
	    }
	 private Node deleteRec(Node node, Node root) {
		// TODO Auto-generated method stub
		 
		 if(root == null){return root;}
		 
		 if(node.B_num < root.B_num){
				//System.out.println("A");
				root.left = deleteRec(node,root.left);
			}else if(node.B_num > root.B_num){
				
				root.right = deleteRec(node,root.right);
			}else if(node.B_num == root.B_num){
				
				//System.out.println("--"+node.courses.get(0));
				int index = root.courses.indexOf(node.courses.get(0));
				if(index != -1){
					
					root.courses.remove(index);
				}
				root.somethingHappened();
			}
			
			return root;
		 
		 
		 
		 
		 
		
	}
	void printNodes(Results result)  {
	       inorderRec(root,result);
	    }
	 
	    // A utility function to Tredo inorder traversal of BST
	    void inorderRec(Node root,Results results) {
	        if (root != null) {
	            inorderRec(root.left,results);
	            results.storeNewResult(root.B_num + ":" + root.courses);
	           /* System.out.println(root.B_num);
	            System.out.println(root.courses);*/
	            inorderRec(root.right,results);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		Node n_origin = null;
		// n_origin =  new Node(1234, "A");
		//Node backup_node = (Node)n_origin.clone();
		//Node backup_node2 = (Node)n_origin.clone();
		//n_origin.registerObserver(backup_node);
		//n_origin.registerObserver(backup_node2);
		/*Node n1 = new Node(4545, "B");
		Node n2 = new Node(4545, "C");
		Node n3 = new Node(4545, "D");
		Node n4 = new Node(3434,"F");*/
		Tree tree = new Tree();
		Tree backup_tree_1 = new Tree();
		Tree backup_tree_2 = new Tree();
	//	tree.insertrec(n_origin);
		//backup_tree_1.insertrec(backup_node);
		//backup_tree_2.insertrec(backup_node2);
		/*tree.insertrec(n1);
		tree.insertrec(n2);
		tree.insertrec(n3);
		tree.insertrec(n4);*/
		FileProcessor fp = new FileProcessor("C:\\Users\\MANAV\\Desktop\\input.txt");
		while((line = fp.readLine())!= null){
			
			String parts[] = line.split(":");
			 n_origin = new Node(Integer.parseInt(parts[0]),parts[1]);
			Node backup_Node_1 = (Node)n_origin.clone();
		Node backup_Node_2 = (Node)n_origin.clone();
		n_origin.registerObserver(backup_Node_1);
		n_origin.registerObserver(backup_Node_2);
			tree.insertrec(n_origin);
			backup_tree_1.insertrec(backup_Node_1);
		backup_tree_2.insertrec(backup_Node_2);
		
			
			
			
		}
		FileProcessor fp_delete = new FileProcessor("C:\\Users\\MANAV\\Desktop\\delete.txt");
while((line = fp_delete.readLine())!= null){
			
			String parts[] = line.split(":");
			Node n = new Node(Integer.parseInt(parts[0]),parts[1]);
			tree.delete(n);
			
			
			
			
		}
		//Node n2 = new Node(1234, "A");
		Results r1 = new Results("C:\\Users\\MANAV\\Desktop\\Fall_2017\\output1.txt");
		Results r2 = new Results("C:\\Users\\MANAV\\Desktop\\Fall_2017\\output2.txt");
		Results r3 = new Results("C:\\Users\\MANAV\\Desktop\\Fall_2017\\output3.txt");
		//tree.delete(n2);
		//n_origin.somethingHappened();
		//tree.delete(n3);
		System.out.println("----------------------- Main--------------------------\n");
		tree.printNodes(r1);
		System.out.println("----------------------- Back Up 1 --------------------------\n");
		backup_tree_1.printNodes(r2);
		System.out.println("----------------------- Back Up 2 --------------------------\n");
		backup_tree_2.printNodes(r3);
		
	}

}
