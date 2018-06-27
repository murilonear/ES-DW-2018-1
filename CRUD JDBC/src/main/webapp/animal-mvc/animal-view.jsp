<!DOCTYPE html>
<%@page import="dw.AnimalModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Animais</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Animal</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  name="nome"
                  value="${param.nome}"
                  type="text"
                  placeholder="Nome"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="idade"
                  value="${param.idade}"
                  type="number"
                  placeholder="Idade"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="raca"
                  value="${param.raca}"
                  type="text"
                  placeholder="Raca"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir</button>
              <button name="op" value="salvar" class="btn btn-default">Salvar</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Nome</td>
            <td>Idade</td>
            <td>Raca</td>
            <td>#</td>
          </tr>
          <%
          List<AnimalModel> animais = (List<AnimalModel>) request.getAttribute("animais");
          for (AnimalModel v:animais) {
          %>
            <tr>
              <td><a href="animal?nome=<%=v.getNome()%>&idade=<%=v.getIdade()%>&raca=<%=v.getRaca()%>"><%=v.getNome()%></a></td>
              <td><%=v.getIdade()%></td>
              <td><%=v.getRaca()%></td>
              <td><a href="animal?op=excluir&nome=<%=v.getNome()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>