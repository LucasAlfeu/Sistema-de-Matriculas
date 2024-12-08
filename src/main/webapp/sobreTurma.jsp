<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PÃ¡gina de Notas</title>
  <link rel="stylesheet" href="./styles/sobreTurma.css">
</head>
<body>
  <header>
    <div class="nav">
      <a href="#">Início</a>
      <a href="#">Sair</a>
    </div>
  </header>

  <main>
    <h1>Nome da Turma</h1>
    <form class="form">
      <div class="table">
        <div class="row">
          <span>Nome do Aluno</span>
          <label>
            Nota:
            <input type="text" name="nota1">
          </label>
        </div>
        <div class="row">
          <span>Nome do Aluno</span>
          <label>
            Nota:
            <input type="text" name="nota2">
          </label>
        </div>
        <div class="row">
          <span>Nome do Aluno</span>
          <label>
            Nota:
            <input type="text" name="nota3">
          </label>
        </div>
        <div class="row">
          <span>Nome do Aluno</span>
          <label>
            Nota:
            <input type="text" name="nota4">
          </label>
        </div>
      </div>
      <div class="buttons">
        <button type="reset">Cancelar</button>
        <button type="submit">Cadastrar Notas</button>
      </div>
    </form>
  </main>
</body>
</html>
