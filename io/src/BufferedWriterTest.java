import  java.io.*;
public class BufferedWriterTest {
	public static void main(String[] args) {
		FileWriter fw=null;
		BufferedWriter bw=null;
		FileReader fr=null;
		BufferedReader br=null;
		try {
	       //����һ��FileWriter ����
	       fw=new FileWriter("D:\\myDoc\\hello.txt"); 
	       //����һ��BufferedWriter ����
	       bw=new BufferedWriter(fw); 
	       bw.write("��Һã�"); 
	       bw.write("������ѧϰBufferedWriter��"); 
	       bw.newLine(); 
	       bw.write("����ָ�̣�"); 
	       bw.newLine();		       
	       bw.flush();
	       		       
	       //��ȡ�ļ�����
	        fr=new FileReader("D:\\myDoc\\hello.txt"); 
	        br=new BufferedReader(fr); 
	        String line=br.readLine();
	        while(line!=null){ 
	            System.out.println(line);
	            line=br.readLine(); 
	        }
	      
	        fr.close(); 
	       }catch(IOException e){
	            System.out.println("�ļ�������!");
	       }finally{
	    	   try{
	    		   if(fw!=null)
	    			   fw.close();
	    		   if(br!=null)
	    			   br.close();
	    		   if(fr!=null)
	    			   fr.close();  
	    	   }catch(IOException ex){
		            ex.printStackTrace();
		       }
	       }
	}
}
