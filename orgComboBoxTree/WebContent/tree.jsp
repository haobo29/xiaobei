<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>延迟加载（异步取数据）</title>
<script type="text/javascript" src="js/ligerui/jquery/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/ligerui/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="js/ligerui/ligerUI/js/plugins/ligerComboBox.js"></script>
<script type="text/javascript" src="js/ligerui/ligerUI/js/plugins/ligerTree.js"></script>
 <link rel="stylesheet" type="text/css" href="js/ligerui/ligerUI/skins/Aqua/css/ligerui-all.css" />
</head>
<body>
<input type="text" id="org">
<script type="text/javascript">
$(function(){
	var orgNoDef=<%=(String)request.getAttribute("orgNoDef") %>;
	var treeData=<%=request.getAttribute("treeData") %>;
	var orgComboBox=$("#org").ligerComboBox({
		width : 150,
		selectBoxWidth: 200,
        selectBoxHeight: 300, 
	    valueField:"ORG_NO",
	    textField:"ORG_NAME",
	    valueFieldID:"orgNoHidden",
	    treeLeafOnly: false,
	    resize:true,
	    slide:true,
	    tree: { 
			/*url: "InitTree?down="+orgNoDef,*/
			data:treeData,
			textFieldName:"ORG_NAME",
			idFieldName:"ORG_NO",
			parentIDFieldName :"P_ORG_NO",
		    checkbox: false,
		    slide:true,
		    /*isExpand:function(e){
				if(e.data.ISEXPAND&&e.data.ISEXPAND=='1'){
					return true;
				}
				return false;
    		},*/
		    
		    isLeaf:function(node){
		        if(node.IS_LEAF=="0"){
		            if(!node.children){
		                node.children=[];
		            }
		             return false;
		        }
		        return true;
		    },
		    /*onBeforeExpand:function(node){
			    var treeMgr=orgComboBox.innerTree;
			    if(node.data.children&&node.data.children.length==0){
				    var orgNoNode=node.data.ORG_NO;
				    treeMgr.loadData(node,"ExpTree?orgNo="+orgNoNode);
				}
			}*/
		    delay: function(e)
            {
		    	if(e.data.ISEXPAND=="1"){
		    		return false;
		    	}
		    	if(e.data.IS_LEAF=="0"){
		    		return { url: "ExpTree?orgNo="+e.data.ORG_NO}
		    	}
                return false;
            }
	    }
	});
	if(orgNoDef!=null&&orgNoDef!=""){
		orgComboBox.selectValue(orgNoDef);
	}
})
</script>
</body>
</html>
	