@extends('layouts.app')


@section('content')

<div class="container">
    <h1>Dashboard de livros</h1>


    <form method="GET" action="{{ route('dashboard') }}">
        <input type="text" name="search" placeholder="Pesquisar livros..." value="{{ request('search') }}">
        <button type="submit">Pesquisar</button>
    </form>


    <div class="row">
        @foreach ($livros as $livro)
            <div class="col-md-4">
                <div class="card">
                    <img src="assets/img/img1.jpg" class="card-img-top" alt="{{ $livro->nome }}">
                    <div class="card-body">
                        <h5 class="card-title">{{ $livro->nome }}</h5>
                        <p class="card-text">{{ $livro->descricao }}</p>
                        <p class="card-text">{{ $livro->categoria }}</p>
                        <a href="{{ route('livros.show', $livro->id) }}" class="btn btn-primary">Ver livro</a>
                    </div>
                </div>
            </div>
        @endforeach
    </div>
</div>
@endsection
