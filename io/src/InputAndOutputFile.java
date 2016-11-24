
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutputFile {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//1��������������,�����ȡD:/ �ҵ��ഺ˭����.txt�ļ�
			fis = new FileInputStream("D:/�ҵ��ഺ˭����.txt");
			//2���������������
			fos = new FileOutputStream("C:/myFile/myPrime.txt",true);
			//3��������תվ����,���ÿ�ζ�ȡ������
			byte[] words=new byte[1024];
			//4��ͨ��ѭ��ʵ���ļ���ȡ
			while((fis.read())!=-1){
				fis.read(words);
				fos.write(words, 0, words.length);
			}
			System.out.println("������ɣ���鿴�ļ���");		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//5���ر���
	        try {
	        	if(fos!=null)
	        		fos.close();
	        	if(fis!=null)
	        		fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
