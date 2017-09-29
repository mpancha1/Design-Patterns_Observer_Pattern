package manav_panchal_assign_2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface {
   
	//private String[] results;
	//private int i;
	private  String file_path;
	BufferedWriter bw;
	
	
	public Results(String file_path_C){
		
		//results = new String[100];
		file_path = file_path_C;
		File file = new File(file_path);
		//file.createNewFile();
		
		try {
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file_path));
			bw.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Exception Can not Create File or Can not write in ti file!! ");
			e.printStackTrace();
		}
		
		//i = 0;
		
	}
	
	

	public void storeNewResult(String s){
		
		
		
		System.out.println(s);
		writeToFile(s);
		
		
		
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		bw.close();
		super.finalize();
	}

	@Override
	public void writeToFile(String s) {
		// TODO Auto-generated method stub
		
		//File file = new File("C:\\Users\\MANAV\\Desktop\\Fall 2017\\DP\\Assignments\\Assignment_1\\output_assi1.txt");
		
		try {

			
			bw = new BufferedWriter(new FileWriter(file_path,true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			try {
				
				bw.append(s);
				bw.newLine();
				//bw.close();
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				System.err.println("Can not Write in to file");
				e.printStackTrace();
				
			}try {
				finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		
		
	}
	

}

