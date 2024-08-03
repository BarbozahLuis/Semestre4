<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contato</title>
</head>
<body>
    <!-- Cabeçalho incluído aqui para consistência -->
    @include('components.header')
    <main>
        <h2>Contato</h2>
        
        <section id="informacoes">
            <h3>Informações de Contato</h3>
            <p><strong>Email:</strong> contato@exemplo.com</p>
            <p><strong>Telefone:</strong> (11) 1234-5678</p>
            <p><strong>Endereço:</strong> Rua Exemplo, 123, Bairro Exemplo, Cidade - Estado</p>
        </section>

        <section id="formulario">
            <h3>Formulário de Contato</h3>
            <form action="enviar-email.php" method="post">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required><br><br>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br><br>
                
                <label for="telefone">Telefone:</label>
                <input type="tel" id="telefone" name="telefone"><br><br>
                
                <label for="mensagem">Mensagem:</label><br>
                <textarea id="mensagem" name="mensagem" rows="4" cols="50" required></textarea><br><br>
                
                <input type="submit" value="Enviar">
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Nossa Empresa. Todos os direitos reservados.</p>
    </footer>
</body>
</html>
