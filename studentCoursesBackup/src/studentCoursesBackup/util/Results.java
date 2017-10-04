package studentCoursesBackup.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface {
   
	
	private  String file_path;
	BufferedWriter bw;
	
	
	public Results(String file_path_C){
		
		
		file_path = file_path_C;
		File file = new File(file_path);
		
		
		try {
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file_path));
			bw.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Exception Can not Create File or Can not write in ti file!! ");
			e.printStackTrace();
		}
		
		
		
	}
	
	

	public void storeNewResult(String s){
		
		
		
		
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
		
		
		
		try {

			
			bw = new BufferedWriter(new FileWriter(file_path,true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			try {
				
				bw.append(s);
				bw.newLine();
				
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

