<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Sistema Sousa</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(45deg, cyan, yellow);
            color: #333;
        }

      h1 {
            font-family: "Audiowide", sans-serif;/* Aplicando fonte Roboto */
            margin-top: 0;
            margin-bottom: 20px;
            text-align: center;
            color: black; /* Cor do texto */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* Contorno */
        }
        form {
            background-color: black; /* Alterado para fundo preto */
            padding: 80px;
            border-radius: 50px;
            box-shadow: 0 4px 6px white);
            text-align: center;
        }

        table {
            margin: 0 auto;
        }
         label {
            color: white; /* Ajuste para deixar os rótulos brancos */
        }

        input[type="text"], input[type="password"] {
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: calc(100% - 20px);
        }

        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #ff5733; /* Cor de destaque */
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #e64e2d;
        }

        h4 {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>
   <h1>Sistema Sousa</h1>

    <form action="ServletLOgar" method="post">
        <input type="hidden" value="<%=request.getParameter("url")%>" name="url">
        <table>
            <tr>
                <td><label for="login">Login:</label></td>
            </tr>
            <tr>
                <td><input type="text" id="login" name="login" placeholder="Digite seu login"></td>
            </tr>
            <tr>
                <td><label for="senha">Senha:</label></td>
            </tr>
            <tr>
                <td><input type="password" id="senha" name="senha" placeholder="Digite sua senha"></td>
            </tr>
            <tr>
                <td><input type="submit" value="acesar"></td>
            </tr>
        </table>
    </form>

    <h4>${msg}</h4>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

</html>