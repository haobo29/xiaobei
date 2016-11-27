package dao;

import java.util.List;
import java.util.Map;

public interface IOrgDao {
	public List<Map<String,String>> queryDownToUp(String downNode,String upNode);
	public List<Map<String,String>> querySubOrg(String orgNo);
}
