<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify/Delete</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- 폼에 처음에는 /board/modify 액션이 붙어있다 -->
				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>BNO</label><input class="form-control" name='bno'
							readonly="readonly" value='<c:out value = "board.bno"/>'>
					</div>
					<div class="form-group">
						<label>Title</label><input class="form-control" name='title'
							value='<c:out value = "board.title"/>'>
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" cols="50" name='content'><c:out
								value="board.content" /></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label><input class="form-control" name='writer'
							readonly = "readonly" value='<c:out value = "board.writer"/>'>
					</div>
					
					<div class = "form-group">
						<label>RegDate</label><input class="form-control" name= 'regDate'
							readonly = "readonly" value = '<c:out value = "board.regdate"/>'>
					</div>
					
					<div class = "form-group">
						<label>UpdateDate</label><input class="form-control" name= 'updateDate'
							readonly = "readonly" value = '<c:out value = "board.updateDate"/>'>
					</div>

					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>

					<!-- /.table-responsive -->
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<script type ="text/javascript">

$(document).ready(function(){

	var formObj = $("form");
	
	$(button).ready(function(e){
		
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operaiton);
		
		if(operation ==="remove"){
			//폼의 액션을 /board/remove로 변경한다
			formObj.attr("action","/board/remove").attr("method","post");
		}else if(operation ==="list"){
			self.location = "/board/list";
			return;
		}
		formObj.submit();
	})
})
</script>
<%@include file="../includes/footer.jsp"%>