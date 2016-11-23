package cn.jbit.dproxy;
/**
 * 学生管理接口
 *
 */
public interface StuManager {
	/**
	 * 按照指定id删除学生
	 * @param id
	 */
	public void deleteStu(int id);
	/**
	 * 查询指定id的学生
	 * @param id
	 * @return
	 */
	public String selectStu(int id);
}
