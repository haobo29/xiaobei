package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.IOrgDao;
import dao.OrgDaoUtil;

public class OrgDaoImpl extends OrgDaoUtil implements IOrgDao {

	public List<Map<String,String>> queryDownToUp(String downNode, String upNode) {
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cn=getCn();
			String sql="select f.*,\n" +
			"       (case\n" + 
			"         when f.org_no in (select g.p_org_no\n" + 
			"                             from o_org g\n" + 
			"                            start with g.org_no = ?\n" + 
			"                           connect by g.org_no = prior g.p_org_no\n" + 
			"                                  and g.org_no != ?) or f.org_no = ? then\n" + 
			"          '1'\n" + 
			"         else\n" + 
			"          '0'\n" + 
			"       end) isExpand\n" + 
			"  from (select b.org_no, b.org_name, b.p_org_no, b.sort_no, b.is_leaf\n" + 
			"          from (select a.org_no,\n" + 
			"                       a.org_name,\n" + 
			"                       a.p_org_no,\n" + 
			"                       a.sort_no,\n" + 
			"                       CONNECT_BY_ISLEAF is_leaf,\n" + 
			"                       level             l\n" + 
			"                  from o_org a\n" + 
			"                 start with a.org_no = ?\n" + 
			"                connect by prior a.org_no = a.p_org_no) b\n" + 
			"         where b.l <= 2\n" + 
			"        union\n" + 
			"        select e.org_no, e.org_name, e.p_org_no, e.sort_no, e.is_leaf\n" + 
			"          from (select d.org_no,\n" + 
			"                       d.org_name,\n" + 
			"                       d.p_org_no,\n" + 
			"                       d.sort_no,\n" + 
			"                       CONNECT_BY_ISLEAF is_leaf,\n" + 
			"                       level             l\n" + 
			"                  from o_org d\n" + 
			"                 start with d.p_org_no in\n" + 
			"                            (select c.p_org_no\n" + 
			"                               from o_org c\n" + 
			"                              start with c.org_no = ?\n" + 
			"                             connect by c.org_no = prior c.p_org_no\n" + 
			"                                    and c.org_no != ?)\n" + 
			"                connect by prior d.org_no = d.p_org_no\n" + 
			"                 order siblings by d.sort_no) e\n" + 
			"         where e.l = 1) f";
			ps=cn.prepareStatement(sql);
			String[] parameters ={downNode,upNode,upNode,upNode,downNode,upNode};
			for(int i=0;i<parameters.length;i++){
				ps.setString(i+1, parameters[i]);
			}
			rs=ps.executeQuery();
			List<Map<String,String>> reList=new ArrayList<Map<String,String>>();
			while(rs.next()){
				String orgNo=rs.getString("org_no");
				String orgName=rs.getString("org_name");
				String porgNo=rs.getString("p_org_no");
				String isLeaf=rs.getString("is_leaf");
				String isExpand=rs.getString("isExpand");
				Map<String,String> map=new HashMap<String,String>();
				map.put("ORG_NO", orgNo);
				map.put("ORG_NAME", orgName);
				map.put("P_ORG_NO", porgNo);
				map.put("IS_LEAF", isLeaf);
				map.put("ISEXPAND", isExpand);
				reList.add(map);
			}
			return reList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeRes(cn, ps, rs);
		}
		return null;
	}

	public List<Map<String,String>> querySubOrg(String orgNo) {
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cn=getCn();
			String sql="select b.*\n" +
			"from\n" + 
			"(\n" + 
			"select a.org_no,a.org_name,a.p_org_no,a.sort_no,CONNECT_BY_ISLEAF is_leaf,level l\n" + 
			" from o_org a start with a.org_no=?\n" + 
			"connect by prior a.org_no=a.p_org_no order siblings by a.sort_no\n" + 
			") b\n" + 
			"where b.l = 2";
			ps=cn.prepareStatement(sql);
			ps.setString(1, orgNo);
			rs=ps.executeQuery();
			List<Map<String,String>> reList=new ArrayList<Map<String,String>>();
			while(rs.next()){
				String org_no=rs.getString("org_no");
				String orgName=rs.getString("org_name");
				String porgNo=rs.getString("p_org_no");
				String isLeaf=rs.getString("is_leaf");
				Map<String,String> map=new HashMap<String,String>();
				map.put("ORG_NO", org_no);
				map.put("ORG_NAME", orgName);
				map.put("P_ORG_NO", porgNo);
				map.put("IS_LEAF", isLeaf);
				reList.add(map);
			}
			return reList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			freeRes(cn, ps, rs);
		}
		return null;
	}

	
}
