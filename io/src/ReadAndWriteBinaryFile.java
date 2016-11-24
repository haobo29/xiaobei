import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class ReadAndWriteBinaryFile {

	public static void main(String[] args) {
		DataInputStream dis = null;
		DataOutputStream out =null;
		try {
			  //�������������
				FileInputStream fis = new FileInputStream("D:\\myDoc\\FileCopy.class");
		      dis = new DataInputStream(fis);
		      //��������������
		      FileOutputStream outFile = new FileOutputStream("D:\\myDoc\\temp.class");
		      out = new DataOutputStream(outFile);
		      int temp;
		      //��ȡ�ļ���д���ļ�
		      while ( (temp = dis.read()) != -1) {
		        out.write(temp);
		      }
		    }catch (IOException ioe) {
		      ioe.printStackTrace();
		    }finally{
		    	try{
		    		   if(dis!=null)
		    			   dis.close();
		    		   if(out!=null)
		    			   out.close();
		    	   }catch(IOException ex){
			            ex.printStackTrace();
			       }
		    }
	   }
}
