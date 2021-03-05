<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Read
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        		<div class="form-group">
                        			<label>BNO</label><input class="form-control"name='BNO' readonly="readonly" value = '<c:out value = "board.bno"/>'>
                        		</div>
                        		<div class="form-group">
                        			<label>Title</label><input class="form-control"name='title' readonly="readonly" value = '<c:out value = "board.title"/>'>
                        		</div>
                        			
                        		<div class = "form-group">
                        			<label>Text area</label>
                        			<textarea class="form-control" rows = "3" cols ="50" name = 'content'><c:out value = "board.content"/></textarea>
                        		</div>
                        		
                        		<div class = "form-group">
                        			<label>Writer</label><input class = "form-control" name ='writer' value = '<c:out value = "board.writer"/>'>
                        		</div>
                        		
                        		<div class = "form-group">
                        			<label>RegDate</label><input class = "form-control" name ='regDate' readonly ="readonly" value = '<c:out value = "board.regdate"/>'>
                        		</div>
                        		
                        		<div class = "form-group">
                        			<label>UpdateDate</label><input class = "form-control" name ='updateDate' readonly="readonly" value = '<c:out value = "board.updateDate"/>'>
                        		</div>
                        			
                        		<button data-oper = 'modify' class="btn btn-default" 
                        		onclick = "location.href='/board/modify?bno=<c:out value = "${board.bno}"/>'">Modify</button>
                        		
                        		 <button data-oper = 'modify' class="btn btn-info"
                        		onclick = "location.href='/board/list'">List</button>
                        	
                            <!-- /.table-responsive -->
                          
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
       <%@include file="../includes/footer.jsp" %>