package cn.jbit.sproxy;
/**
 * ѧ������̬������
 * �ڽ��в���ǰ��¼������־
 */
public class StuManagerSproxy implements StuManager {

	StuManager stumanager;

	public StuManagerSproxy() {
		this.stumanager = new StuManagerImpl();
	}

	public void deleteStu(int id) {
		log("deleteStu");
		stumanager.deleteStu(id);

	}

	public String selectStu(int id) {
		log("selectStu");
		return stumanager.selectStu(id);

	}
	/**
	 * ��¼������־
	 */
	public void log(String oper) {
		System.out.println("log before execute "+ oper);
	}

}
