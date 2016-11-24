import  java.io.*;
public class BufferedReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr=null;
		BufferedReader br=null;
		try {
	        //创建一个FileReader对象
	        fr=new FileReader("D:\\myDoc\\hello.txt"); 
	        //创建一个BufferedReader 对象
	        br=new BufferedReader(fr); 
	        //读取一行数据 
	        String line=br.readLine();
	        while(line!=null){ 
	            System.out.println(line);
	            line=br.readLine(); 
	        }
	    }catch(IOException e){
	            System.out.println("文件不存在!");
	    }finally{
	    	 try {
	    	     //关闭 流
	    		if(br!=null)
	    			br.close();
	    		if(fr!=null)
	    			fr.close(); 
	 	     } catch (IOException e) {
				e.printStackTrace();
			 }
	    }
	}
}
