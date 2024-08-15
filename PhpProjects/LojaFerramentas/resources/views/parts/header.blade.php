@if (Auth::check()) {{-- se o usuario estiver autenticado, logado, ele direciona para a pagina interna --}}

<div>
    <h3>Olá, {{Auth::user()->name}}</h3>
    <h4>{{Auth::user()->tipo_usuario}}</h4>
</div>
    <form action="/logout" method="post">
        @csrf
        <button type="submit">Logout</button>
    </form>

@else
    <div>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/registro">Registrar-se</a></li>
        </ul>
    </div>

@endif