package cn.jbit.sproxy;
/**
 * ������
 */
public class Test {
	public static void main(String[] args) {		
		System.out.println("----��ʹ�þ�̬������в���------");		
		//����Ŀ������󣬲�ʹ�þ�̬����
		StuManager sm1=new StuManagerImpl();
		//ɾ��ָ��idѧ��
		sm1.deleteStu(5);
		//��ѯָ��idѧ����Ϣ
		System.out.println(sm1.selectStu(5));
		System.out.println("----ʹ�þ�̬������в���------");		
		//������̬���������
		StuManager sm2=new StuManagerSproxy();
		//ɾ��ָ��idѧ��
		sm2.deleteStu(5);
		//��ѯָ��idѧ����Ϣ
		System.out.println(sm2.selectStu(5));
	}
}
