<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="..\css\styleNav.css">
</head>
<body>
<h1>Bem-vindo ao Nosso Site</h1>
        <nav>
            <ul>
                <li><a href="/home">Início</a></li>
                <li><a href="/produtos">Produto</a></li>
                <li><a href="/contato">Contato</a></li>
            </ul>
        </nav>
        <style>
            /* Reset básico para garantir consistência entre navegadores */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Estilização do corpo da página */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    color: #333;
    line-height: 1.6;
    padding: 20px;
}

/* Estilização do título */
h1 {
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

/* Estilização da navegação */
nav {
    background: #333;
    color: #fff;
    padding: 10px;
    border-radius: 5px;
}

nav ul {
    list-style: none;
    display: flex;
    justify-content: center;
}

nav ul li {
    margin: 0 15px;
}

nav ul li a {
    color: #fff;
    text-decoration: none;
    font-weight: bold;
}

nav ul li a:hover {
    text-decoration: underline;
    color: #ddd;
}

        </style>
</body>
</html>