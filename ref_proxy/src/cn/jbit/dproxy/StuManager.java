package cn.jbit.dproxy;
/**
 * ѧ������ӿ�
 *
 */
public interface StuManager {
	/**
	 * ����ָ��idɾ��ѧ��
	 * @param id
	 */
	public void deleteStu(int id);
	/**
	 * ��ѯָ��id��ѧ��
	 * @param id
	 * @return
	 */
	public String selectStu(int id);
}
