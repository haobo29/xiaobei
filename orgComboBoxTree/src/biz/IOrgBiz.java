package biz;

import java.util.List;
import java.util.Map;

public interface IOrgBiz {
	public List<Map<String,String>> queryDownToUp(String downNode,String upNode);
	public List<Map<String,String>> querySubOrg(String orgNo);
	public List<Map<String,String>> queryAllOrg(String orgNo,String orgNoDef);
}
