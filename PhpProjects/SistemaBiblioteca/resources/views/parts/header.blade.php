
{{-- if criado para efetuar o checking e verificar se o login foi feito, se o usuario esta cadastrado e como o usuario esta cadastrado --}}
<header class="header">
    @if (Auth::check())
        <div class="user-info">
            <h3>Olá, Seja Bem-vindo {{ Auth::user()->name }}</h3>
            <h4>{{ Auth::user()->tipo_usuario }}</h4>
        </div>
        
        @if (Auth::user()->isAdmin())
        <button class="button" onclick="window.location.href='/dashboard'">
            Home
        </button>
        <button class="admin-dashboard-button" onclick="window.location.href='/livros'">
            Adicionar Livro
        </button>
        @endif
        <form action="/logout" method="post" class="logout-form">
            @csrf
            <button type="submit" class="logout-button">Logout</button>
        </form>
    @else
        <div class="auth-links">
            <ul>
                <li><a href="/login">Login</a></li>
                <li><a href="/registro">Registro</a></li>
            </ul>
        </div>
    @endif
</header>

