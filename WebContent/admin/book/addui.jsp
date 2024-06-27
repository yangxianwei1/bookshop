<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bookshop/admin/book?method=add"  method="post" enctype="multipart/form-data" >
	<input type="hidden" name="method" value="addCategory">
        <table>
            <tr>
                <td> 图书类名称: <input type= "text" name = "bname"></td>
            </tr>
            <tr>
                <td> 作者: <input type= "text" name = "author"></td>
            </tr>
            <tr>
                <td> 价格: <input type= "text" name = "price"></td>
            </tr>
            <tr>
                <td> 图书简介:
                    <textarea name="bdesc">

                    </textarea>

                </td>
               
            </tr>
            <tr>
                <td> 出版社: <input type= "text" name = "publisher"></td>
            </tr>
            <tr>
                <td> 出版日期: <input type= "text" name = "birth"></td>
            </tr>
            <tr>
                <td> 图书封面: <input type= "file" name = "photo"></td>
            </tr>
            <tr>
                <td> 图书类型: <input type= "text" name = "categoryid"></td>
            </tr>
            <tr>
            	<td><input type ="submit"  value="添加图书"></td>
            </tr>
        </table>
    </form>
</body>
</html>