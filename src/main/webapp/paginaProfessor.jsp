<!DOCTYPE html>
<%@ page import="br.ufrrj.model.Docente" %>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/paginaProfessor.css">
  <title>Página do Professor</title>
</head>
<body>
<header>

      <%Docente docente = (Docente) session.getAttribute("docente");%>

	<%if (docente == null) { response.sendRedirect("index.jsp"); } %>
    <h1>P�gina do Professor</h1>
    <nav>
      <a href="./paginaProfessor.jsp">In�cio</a>
      <a href="./index.jsp">Sair</a>
    </nav>
</header>

<div class="container">
    <div class="box">
        <h2><%= docente.getNome() %></h2>
        <div class="actions">
            <a href="./cadastrarTurma.jsp">Cadastrar</a>
            <a href="./solicitarTurma.jsp">Solicitar</a>
        </div>
    </div>
    <table>
      <thead>
        <tr>
          <th>Turma</th>
          <th>Nome da Disciplina</th>
          <th>Nota</th>
          <th>Situa��o</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Turma 01</td>
          <td>Nome da Disciplina</td>
          <td>0.0</td>
          <td>Aprovado</td>
          <td class="actions">
            <a href="./sobreTurma.jsp">Saiba Mais</a>
          </td>
        </tr>
        <tr>
          <td>Turma 02</td>
          <td>Nome da Disciplina</td>
          <td>0.0</td>
          <td>Aprovado</td>
          <td class="actions">
            <a href="./sobreTurma.jsp">Saiba Mais</a>
          </td>
        </tr>
        <tr>
          <td>Turma 03</td>
          <td>Nome da Disciplina</td>
          <td>0.0</td>
          <td>Aprovado</td>
          <td class="actions">
            <a href="./sobreTurma.jsp">Saiba Mais</a>
          </td>
        </tr>
        <tr>
          <td>Turma 04</td>
          <td>Nome da Disciplina</td>
          <td>0.0</td>
          <td>Aprovado</td>
          <td class="actions">
            <a href="./sobreTurma.jsp">Saiba Mais</a>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
</html>