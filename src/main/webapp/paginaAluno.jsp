<!DOCTYPE html>
<%@ page import="br.ufrrj.model.Discente" %>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/paginaAluno.css">
  <title>PÃ¡gina do Aluno</title>
</head>
<body>
  <header>
  
      <%Discente discente = (Discente) session.getAttribute("discente");%>

	<%if (discente == null) { response.sendRedirect("index.jsp"); } %>
    <h1>Página do Aluno</h1>
    <nav>
      <a href="./paginaAluno.jsp">Início</a>
      <a href="./index.jsp">Sair</a>
    </nav>
  </header>

  <div class="container">
    <h2><%= discente.getNome() %></h2>
    <table>
      <thead>
        <tr>
          <th>Turma</th>
          <th>Carga Horária</th>
          <th>Nota</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Turma 01</td>
          <td>60h</td>
          <td>0.0</td>
          <td class="status">Aprovado</td>
        </tr>
        <tr>
          <td>Turma 02</td>
          <td>60h</td>
          <td>0.0</td>
          <td class="status">Aprovado</td>
        </tr>
        <tr>
          <td>Turma 03</td>
          <td>30h</td>
          <td>0.0</td>
          <td class="status">Aprovado</td>
        </tr>
        <tr>
          <td>Turma 04</td>
          <td>90h</td>
          <td>0.0</td>
          <td class="status">Aprovado</td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
</html>