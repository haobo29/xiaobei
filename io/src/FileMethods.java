
import  java.io.*;
public class FileMethods {
	public static void main(String[] args) {
	    FileMethods fm=new FileMethods();
	    File file=null;
	    file=new File("D:\\myDoc\\test.txt");
	    //fm.create(file);
	    fm.showFileInfo(file);
	    //fm.delete(file); 
   }
   /**
    * �����ļ��ķ���
    * @param file �ļ�����
    */
   public void create(File file){
	   if(!file.exists()){
		   try {
			   file.createNewFile();
			   System.out.println("�ļ��Ѵ�����");
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
	   }
   }
   /**
    * ɾ���ļ�
    * @param file �ļ�����
    */
   public void delete(File file){
	   if(file.exists()){
		   file.delete();
		   System.out.println("�ļ���ɾ����");
	   }
   }
   
   /**
    * ��ʾ�ļ���Ϣ
    * @param file �ļ�����
    */
   public void showFileInfo(File file){
	   if(file.exists()){ //�ж��ļ��Ƿ����
		   if(file.isFile()){ //������ļ�
			   System.out.println("����:" +  file .getName());
		       System.out.println("���·��: " + file.getPath());
		       System.out.println("����·��: " + file.getAbsolutePath());   
		       System.out.println("�ļ���С:" + file.length()+ " �ֽ�");   
		   } 
		   if(file.isDirectory()){
			   System.out.println("���ļ���Ŀ¼");
		   }
	   }else
		   System.out.println("�ļ�������");
   }
}


