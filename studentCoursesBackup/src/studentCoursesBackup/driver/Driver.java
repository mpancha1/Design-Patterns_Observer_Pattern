package manav_panchal_assign_2;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String line;
		Node n_origin = null;

		TreeBuilder tree = new TreeBuilder();
		TreeBuilder backup_tree_1 = new TreeBuilder();
		TreeBuilder backup_tree_2 = new TreeBuilder();

		FileProcessor fp = new FileProcessor(args[0]);
		//"C:\\Users\\MANAV\\Desktop\\input.txt"
		//"C:\\Users\\MANAV\\Desktop\\delete.txt"
		while ((line = fp.readLine()) != null) {

			String parts[] = line.split(":");
			n_origin = new Node(Integer.parseInt(parts[0]), parts[1]);
			Node backup_Node_1 = (Node) n_origin.clone();
			Node backup_Node_2 = (Node) n_origin.clone();
			n_origin.registerObserver(backup_Node_1);
			n_origin.registerObserver(backup_Node_2);
			tree.insert_crc(n_origin);
			backup_tree_1.insert_crc(backup_Node_1);
			backup_tree_2.insert_crc(backup_Node_2);

		}
		FileProcessor fp_delete = new FileProcessor(args[1]);
		while ((line = fp_delete.readLine()) != null) {

			String parts[] = line.split(":");
			Node n = new Node(Integer.parseInt(parts[0]), parts[1]);
			tree.delete(n);

		}
		//C:\\Users\\MANAV\\Desktop\\Fall_2017\\output1.txt
		Results r1 = new Results(args[2]);
		Results r2 = new Results(args[3]);
		Results r3 = new Results(args[4]);

		System.out.println("----------------------- Main--------------------------\n");
		tree.printNodes(r1);
		System.out.println("----------------------- Back Up 1 --------------------------\n");
		backup_tree_1.printNodes(r2);
		System.out.println("----------------------- Back Up 2 --------------------------\n");
		backup_tree_2.printNodes(r3);
	}

}
