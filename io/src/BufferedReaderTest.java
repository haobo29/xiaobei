import  java.io.*;
public class BufferedReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr=null;
		BufferedReader br=null;
		try {
	        //����һ��FileReader����
	        fr=new FileReader("D:\\myDoc\\hello.txt"); 
	        //����һ��BufferedReader ����
	        br=new BufferedReader(fr); 
	        //��ȡһ������ 
	        String line=br.readLine();
	        while(line!=null){ 
	            System.out.println(line);
	            line=br.readLine(); 
	        }
	    }catch(IOException e){
	            System.out.println("�ļ�������!");
	    }finally{
	    	 try {
	    	     //�ر� ��
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
