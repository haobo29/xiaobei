import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//���� FileReader�������.
		Reader fr=null;
		StringBuffer sbf=null;
		try {
			fr = new FileReader("D:\\myDoc\\���.txt");
			char ch[]=new char[1024];  //�����ַ�������Ϊ��תվ
			sbf=new StringBuffer();
			int length=fr.read(ch);  //���ַ���������
	        //ѭ����ȡ��׷���ַ�
	        while ((length!= -1)) { 
	            sbf.append(ch);   //׷�ӵ��ַ���
	            length=fr.read();
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
   	    } finally{
			try {
				if(fr!=null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sbf.toString());
	}

}
