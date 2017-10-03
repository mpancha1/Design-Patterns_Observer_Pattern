package manav_panchal_assign_2;

public class TreeBuilder {

	Node root;

	public TreeBuilder() {

		root = null;
	}

	void insert_crc(Node n) {
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
		root = delete_crc(node, root);
	}

	private Node delete_crc(Node node, Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}

		if (node.B_num < root.B_num) {
			// System.out.println("A");
			root.left = delete_crc(node, root.left);
		} else if (node.B_num > root.B_num) {

			root.right = delete_crc(node, root.right);
		} else if (node.B_num == root.B_num) {

			// System.out.println("--"+node.courses.get(0));
			int index = root.courses.indexOf(node.courses.get(0));
			if (index != -1) {

				root.courses.remove(index);
			}
			root.notifyall();
		}

		return root;

	}

	void printNodes(Results result) {
		print(root, result);
	}

	
	void print(Node root, Results results) {
		if (root != null) {
			print(root.left, results);
			results.storeNewResult(root.B_num + ":" + root.courses);
			/*
			 * System.out.println(root.B_num); System.out.println(root.courses);
			 */
			print(root.right, results);
		}
	}

}
