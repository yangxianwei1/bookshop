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
<form action="/bookshop/admin/category?method=update"  method="post" >
	<input type="hidden" name="method" value="addCategory">
        <table>
        <tr>
                <td> <input type= "hidden" name = "cid" value="${categoryud.cid}"></td>
            </tr>
            <tr>
                <td> 图书类型: <input type= "text" name = "cname" value="${categoryud.cname}"></td>
            </tr>
            <tr>
                <td> 类型描述: <input type= "text" name = "cdesc" value="${categoryud.cdesc}"></td>
            </tr>
            <tr>   
            	<td><input type ="submit"  value="更新"></td>
            </tr>
        </table>
    </form>
</body>
</html>