
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterFiletTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Writer fw=null;
		try {
			  //����һ��FileWriter����
			  fw=new FileWriter("D:\\myDoc\\���.txt"); 
			  //д����Ϣ
			  fw.write("���Ȱ��ҵ��Ŷӣ�"); 	       
			  fw.flush();  //ˢ�»�����
			 
		}catch(IOException e){
			  System.out.println("�ļ�������!");
		}finally{
			try {
				if(fw!=null)
					fw.close();  //�ر���
	 	     } catch (IOException e) {
				e.printStackTrace();
			 }
		}
	}

}
