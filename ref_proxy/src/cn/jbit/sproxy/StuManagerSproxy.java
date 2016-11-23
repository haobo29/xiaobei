package cn.jbit.sproxy;
/**
 * 学生管理静态代理类
 * 在进行操作前记录操作日志
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
	 * 记录操作日志
	 */
	public void log(String oper) {
		System.out.println("log before execute "+ oper);
	}

}
