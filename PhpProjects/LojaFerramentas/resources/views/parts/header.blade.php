@if (Auth::check()) {{-- se o usuario estiver autenticado, logado, ele direciona para a pagina interna --}}

<div>
    <h3>Olá, {{Auth::user()->name}}</h3>
    <h4>{{Auth::user()->tipo_usuario}}</h4>
</div>
    <form action="/logout" method="post">
        @csrf
        <button type="submit">Logout</button>
    </form>
    
    {{-- lógica criada para que se o usuário for ADM aparecer o botão para o usuário administrador --}}
    @if (Auth::user()->isAdmin())
    <div>
        <a href="/produtos"><h3>Dashboard Produtos - Adm</h3></a>
    </div>
        
    @endif
@else
    <div>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/registro">Registrar-se</a></li>
        </ul>
    </div>

@endif