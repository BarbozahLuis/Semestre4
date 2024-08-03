<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
@include('components.header')

    <main>
        <h2>Nossos Produtos</h2>
        
        <section id="produtos">
            
            <article>
                <img src="produto1.jpg" alt="Imagem do Produto 1" width="300">
                <h3>Produto 1</h3>
                <p>Descrição breve do Produto 1. Este produto é ideal para X, Y e Z. É feito com materiais de alta qualidade e oferece um excelente desempenho.</p>
                <p><strong>Preço:</strong> R$ 100,00</p>
            </article>

           
            <article>
                <img src="produto2.jpg" alt="Imagem do Produto 2" width="300">
                <h3>Produto 2</h3>
                <p>Descrição breve do Produto 2. Este produto é conhecido por suas características inovadoras e design sofisticado. Perfeito para qualquer ocasião.</p>
                <p><strong>Preço:</strong> R$ 150,00</p>
            </article>

        
            <article>
                <img src="produto3.jpg" alt="Imagem do Produto 3" width="300">
                <h3>Produto 3</h3>
                <p>Descrição breve do Produto 3. Este produto combina eficiência e estilo, proporcionando uma experiência única para o usuário.</p>
                <p><strong>Preço:</strong> R$ 200,00</p>
            </article>
        </section>
    </main>

</body>
</html> -->

<div class="container">
        <h1>Produtos</h1>
        <a href="" class="btn btn-primary">Adicionar Produto</a>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($produtos as $produto)
                    <tr>
                        <td>{{ $produto->id }}</td>
                        <td>{{ $produto->nome }}</td>
                        <td>{{ $produto->descricao }}</td>
                        <td>{{ $produto->preco }}</td>
                        <td>{{ $produto->quantidade }}</td>
                        
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>