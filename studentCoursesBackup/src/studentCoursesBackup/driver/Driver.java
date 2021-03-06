package studentCoursesBackup.driver;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String line;
		Node n_origin = null;
		char c[] = null;
		TreeBuilder tree = new TreeBuilder();
		TreeBuilder backup_tree_1 = new TreeBuilder();
		TreeBuilder backup_tree_2 = new TreeBuilder();

		FileProcessor fp = new FileProcessor(args[0]);
		
		while ((line = fp.readLine()) != null) {

			String parts[] = line.split(":");
			if(parts.length > 1){
			 c = parts[1].toCharArray();
			}
			if(parts.length > 1 && parts[1].length() == 1 && (c[0] >='A' && c[0] <= 'K')){
			//------------------------------------------------- Making Node ----------------------------------------------
			n_origin = new Node(Integer.parseInt(parts[0]), parts[1]);
			//---------------------------------- cloning for back up ----------------------------------------------------
			Node backup_Node_1 = (Node) n_origin.clone();
			Node backup_Node_2 = (Node) n_origin.clone();
			n_origin.registerObserver(backup_Node_1);
			n_origin.registerObserver(backup_Node_2);
			tree.insert_crc(n_origin);
			backup_tree_1.insert_crc(backup_Node_1);
			backup_tree_2.insert_crc(backup_Node_2);

		}
}
		FileProcessor fp_delete = new FileProcessor(args[1]);
		while ((line = fp_delete.readLine()) != null) {

			String parts[] = line.split(":");
			if(parts.length > 1){
			 c = parts[1].toCharArray();
			}
			if(parts.length > 1 && parts[1].length() == 1 && (c[0] >='A' && c[0] <= 'K')){
			Node n = new Node(Integer.parseInt(parts[0]), parts[1]);
			//-------------------------------------------- Deleting Node ------------------------------------------------
			tree.delete(n);

}
		}
		
		Results r1 = new Results(args[2]);
		Results r2 = new Results(args[3]);
		Results r3 = new Results(args[4]);

		
		tree.printNodes(r1);
		backup_tree_1.printNodes(r2);
		backup_tree_2.printNodes(r3);
	}

}
