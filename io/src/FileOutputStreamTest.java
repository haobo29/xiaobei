
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	
	public static void main(String[] args) {
		FileOutputStream fos=null;
		 try {
			 String str ="�ú�ѧϰJava";
	         byte[] words  = str.getBytes();
	         fos = new FileOutputStream("D:\\myDoc\\hello.txt");
	         fos.write(words, 0, words.length);
	         System.out.println("hello�ļ��Ѹ���!");
	      }catch (IOException obj) {
	    	  System.out.println("�����ļ�ʱ����!");
	      }finally{
	    	  try{
	    		  if(fos!=null)
	    			  fos.close();
	    	  }catch (IOException e) {
		    	 e.printStackTrace();
	    	  }
	      }
	}
}
