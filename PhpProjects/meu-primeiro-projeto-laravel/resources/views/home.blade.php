<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    @include('components.header')

    <h1>Home Page</h1>
    @include('components.footer')
    <main>
        <section id="home">
            <h2>Início</h2>
            <p>Esta é a seção inicial da nossa página. Aqui você pode encontrar uma introdução ao que oferecemos.</p>
        </section>

        <section id="sobre">
            <h2>Sobre Nós</h2>
            <p>Saiba mais sobre nossa empresa e a missão que nos move.</p>
        </section>

        <section id="servicos">
            <h2>Serviços</h2>
            <p>Descubra os serviços que oferecemos para você.</p>
        </section>

        <section id="contato">
            <h2>Contato</h2>
            <p>Entre em contato conosco para mais informações.</p>
        </section>
    </main>

    
</body>

</html>