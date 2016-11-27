package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import biz.IOrgBiz;
import biz.OrgBizImpl;

/**
 * Servlet implementation class ExpTree
 */
public class ExpTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpTree() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		response.setCharacterEncoding("GBK");
		String orgNo=request.getParameter("orgNo");
		IOrgBiz orgBiz=new OrgBizImpl();
		List<Map<String,String>> list=orgBiz.querySubOrg(orgNo);
		JSONArray json=JSONArray.fromObject(list);
		PrintWriter out=response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
