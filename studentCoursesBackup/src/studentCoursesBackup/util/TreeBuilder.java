package manav_panchal_assign_2;

public class TreeBuilder {

	Node root;

	public TreeBuilder() {

		root = null;
	}

	void insertrec(Node n) {
		root = insert(n, root);
	}

	Node insert(Node node, Node root) {

		// System.out.println(node.B_num);
		if (root == null) {

			root = node;
			// System.out.println(root.B_num);
			return root;
		}
		// System.out.println("A"+node.B_num);
		// System.out.println("B-"+root.B_num);

		if (node.B_num < root.B_num) {
			// System.out.println("A");
			root.left = insert(node, root.left);
		} else if (node.B_num > root.B_num) {

			root.right = insert(node, root.right);
		} else if (node.B_num == root.B_num) {

			// System.out.println("--"+node.courses.get(0));
			int index = root.courses.indexOf(node.courses.get(0));
			if (index < 0) {
				root.courses.add(node.courses.get(0));
			}
		}
		return root;

	}

	void delete(Node node) {
		root = deleteRec(node, root);
	}

	private Node deleteRec(Node node, Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}

		if (node.B_num < root.B_num) {
			// System.out.println("A");
			root.left = deleteRec(node, root.left);
		} else if (node.B_num > root.B_num) {

			root.right = deleteRec(node, root.right);
		} else if (node.B_num == root.B_num) {

			// System.out.println("--"+node.courses.get(0));
			int index = root.courses.indexOf(node.courses.get(0));
			if (index != -1) {

				root.courses.remove(index);
			}
			root.somethingHappened();
		}

		return root;

	}

	void printNodes(Results result) {
		inorderRec(root, result);
	}

	// A utility function to Tredo inorder traversal of BST
	void inorderRec(Node root, Results results) {
		if (root != null) {
			inorderRec(root.left, results);
			results.storeNewResult(root.B_num + ":" + root.courses);
			/*
			 * System.out.println(root.B_num); System.out.println(root.courses);
			 */
			inorderRec(root.right, results);
		}
	}

}
