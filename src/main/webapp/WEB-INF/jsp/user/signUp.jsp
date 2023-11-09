<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="sign-up-box">
		<h1 class="mb-4">회원가입</h1>
		<form id="signUpForm" method="post" action="/user/sign-up">
			<table>
				<tr>
					<th>* 아이디 (4자 이상)<br></th>
					<td>
						<%-- input 박스 옆에 중복확인을 붙이기 위해 div를 하나 더 만들고 d-flex --%>
						<div class="d-flex">
							<input type="text">
							<button type="button"></button>
						</div>
						
						<%-- 아이디 중복 체크 결과 --%>
						<%-- d-none class : display none (보이지 않기) --%>
						<div></div>
						<div></div>
						<div></div>
					</td>
				</tr>
				<tr>
					<th>* 비밀번호</th>
					<td><input type="password"></td>
				</tr>
				<tr>
					<th>* 비밀번호 확인</th>
					<td><input type="password"></td>
				</tr>
				<tr>
					<th>* 이름</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>* 이메일</th>
					<td><input type="text"></td>
				</tr>
			</table>
			<br>
			
			<button type="submit">회원가입</button>
		</form>
	</div>
</div>

<script>

</script>