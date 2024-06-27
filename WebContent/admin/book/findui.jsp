<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
 <table>
            <tr>
                <td>图书id</td>
                <td>图书类型名称</td>
                <td>图书类型描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${page.datas}" var="categorys" >
                <tr>
                  	  <td>${categorys.cid}</td>
               	 		<td>${categorys.cname}</td>
               		 <td>${categorys.cdesc}</td>
               		 <td><a href="/bookshop/admin/category?method=updateUI&cid=${categorys.cid}">修改</a> |
               		 <a href="/bookshop/admin/category?method=delete&cid=${categorys.cid}">删除</a></td>
                </tr>
            </c:forEach>   
            <tr>
            	<td>总数据：${page.count}条</td>
            	<td>当前页：${page.currentPage}</td>
                <td>
                	<c:forEach begin="1" end="${page.countPage}" var="i"  >
                		
                		<a href="/bookshop/admin/category?method=findUI&pid=${i}">${i}</a>
                	</c:forEach>
                </td>	
            </tr> 
        </table>   
</body>
</html>