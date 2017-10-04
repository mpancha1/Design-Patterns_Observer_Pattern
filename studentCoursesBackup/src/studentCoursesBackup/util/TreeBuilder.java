package studentCoursesBackup.util;
import studentCoursesBackup.myTree.Node;

public class TreeBuilder {

	private Node root;

	public TreeBuilder() {

		root = null;
	}
	// Insering Node in to tree
	public void insert_crc(Node n) {
		root = insert(n, root);
	}

	Node insert(Node node, Node root) {

		
		if (root == null) {

			root = node;
		
			return root;
		}

		if (node.B_num < root.B_num) {
		
			root.left = insert(node, root.left);
		} else if (node.B_num > root.B_num) {

			root.right = insert(node, root.right);
		} else if (node.B_num == root.B_num) {

			int index = root.courses.indexOf(node.courses.get(0));
			if (index < 0) {
				root.courses.add(node.courses.get(0));
			}
		}
		return root;

	}
	// Searching the node if found delete the corrosponding course if have any
	public void delete(Node node) {
		root = delete_crc(node, root);
	}

	private Node delete_crc(Node node, Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}

		if (node.B_num < root.B_num) {
	
			root.left = delete_crc(node, root.left);
		} else if (node.B_num > root.B_num) {

			root.right = delete_crc(node, root.right);
		} else if (node.B_num == root.B_num) {

			
			int index = root.courses.indexOf(node.courses.get(0));
			if (index != -1) {

				root.courses.remove(index);
			}
			root.notifyall();
		}

		return root;

	}
	// populating Tree
	public void printNodes(Results result) {
		print(root, result);
	}

	
	void print(Node root, Results results) {
		if (root != null) {
			print(root.left, results);
			results.storeNewResult(root.B_num + ":" + root.courses);
			print(root.right, results);
		}
	}

}
