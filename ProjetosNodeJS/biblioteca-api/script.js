document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('livroForm');
    const livrosList = document.getElementById('livrosList');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        const titulo = document.getElementById('titulo').value;
        const autor = document.getElementById('autor').value;
        const ano = document.getElementById('ano').value;
        const genero = document.getElementById('genero').value;

        try {
            const response = await fetch('/livros', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ titulo, autor, ano, genero })
            });

            if (response.ok) {
                form.reset();
                carregarLivros();
            } else {
                console.error('Erro ao adicionar livro');
            }
        } catch (err) {
            console.error('Erro:', err);
        }
    });

    async function carregarLivros() {
        try {
            const response = await fetch('/livros');
            const livros = await response.json();
            livrosList.innerHTML = livros.map(livro => `
                <li>
                    ${livro.titulo} - ${livro.autor} (${livro.ano}) - ${livro.genero}
                </li>
            `).join('');
        } catch (err) {
            console.error('Erro ao carregar livros:', err);
        }
    }

    carregarLivros();
});
