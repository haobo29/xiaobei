
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
			  //创建一个FileWriter对象
			  fw=new FileWriter("D:\\myDoc\\简介.txt"); 
			  //写入信息
			  fw.write("我热爱我的团队！"); 	       
			  fw.flush();  //刷新缓冲区
			 
		}catch(IOException e){
			  System.out.println("文件不存在!");
		}finally{
			try {
				if(fw!=null)
					fw.close();  //关闭流
	 	     } catch (IOException e) {
				e.printStackTrace();
			 }
		}
	}

}
