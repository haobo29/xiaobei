package biz;

import java.util.List;
import java.util.Map;

import dao.IOrgDao;
import dao.impl.OrgDaoImpl;

public class OrgBizImpl implements IOrgBiz {
	IOrgDao orgDao=new OrgDaoImpl();

	public List<Map<String, String>> queryDownToUp(String downNode,
			String upNode) {
		List<Map<String,String>> list=null;
		if(downNode.equals(upNode)){
			list=orgDao.queryOrgAndSub(upNode);
		}else{
			list=orgDao.queryDownToUp(downNode, upNode);
		}
		return list;
	}

	public List<Map<String, String>> querySubOrg(String orgNo) {
		List<Map<String,String>> list=orgDao.querySubOrg(orgNo);
		return list;
	}

	public List<Map<String, String>> queryAllOrg(String orgNo, String orgNoDef) {
		
		return orgDao.queryAllOrg(orgNo, orgNoDef);
	}

}
