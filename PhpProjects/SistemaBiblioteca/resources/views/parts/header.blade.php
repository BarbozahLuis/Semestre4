
{{-- if criado para efetuar o checking e verificar se o login foi feito, se o usuario esta cadastrado e como o usuario esta cadastrado --}}
@if (Auth::check())
    <div>
        <h3>Olá, Seja Bem vindo {{Auth::user()->name }}</h3>
        <h4>{{Auth::user()->tipo_usuario}}</h4>
    </div>
    <form action="/logout" method="post">
        @csrf
        <button type="submit">Logout</button>
    </form>
    @if(Auth::user()->isAdmin())
        <div>
            <a href="/livros"><h3>Dashborad Livros - Adm</h3></a>
        </div>
    @endif
@else
    <div>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/registro">Registro</a></li>
        </ul>
    </div>
   
@endif

