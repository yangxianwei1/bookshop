<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
<style>
        *{
            margin: 0;
            padding: 0;
        }
        #container{
            width: 800px;
            height: 700px;
            border: 1px solid red;
            margin: 0 auto;
        }
        #top{
            height: 100px;
            width: 100%;
            border: 1px solid black;
        }
          #bottom{
            
            width: 100%;
            height: 600px;
            border: 1px solid yellow;
        }  
        #left{
            float: left;
            width: 20%;
            height: 100%;
            border: 1px solid rgb(203, 193, 193);
        }
        #right{
            float: left;
            width: 79%;
            height: 100%;
            border: 1px solid palegreen;
        }
        .cman{
            list-style: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script>
        $(function(){ 
            $("li:contains('类型管理')").click(function(){
                $(this).next().slideToggle();
            }).css("cursor","pointer");
            $("li:contains('图书管理')").click(function(){
                $(this).next().slideToggle();
            }).css("cursor","pointer"); 
             
        })
    </script>
</head>
<body>
<div id="container">

    <div id="top">

    </div>
    <div id="bottom">
        <div id="left">
            <ul class="cman" style="margin-top: 32px;">
                <li>类型管理</li>
                <ul class="findul"   style="margin-left:22px;margin-top: 8px;list-style: none;">
                    <li><a target="mainFrame" href="https://baidu.com">查看类型</a></li>
                    <li style="margin-top: 5px;"><a href="/bookshop/admin/category?method=add">添加类型</a></li>
                </ul>
            </ul>

            <ul class="cman" style="margin-top: 32px;">
                <li>图书管理</li>
                <ul class="findul"   style="margin-left:22px;margin-top: 8px;list-style: none;">
                    <li>添加图书</li>
                    <li style="margin-top: 5px;">查看图书</li>
                </ul>
            </ul>

        </div>
        <div id="right">
            <iframe width="100%" height="100%" name="mainFrame">

            </iframe>
        </div>
    </div>

</div>

</body>
</html>