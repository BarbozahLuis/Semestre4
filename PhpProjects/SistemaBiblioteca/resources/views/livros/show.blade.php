@extends('layouts.app')


@section('content')
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="assets/img/img0.png" class="img-fluid" alt="{{ $livro->nome }}">
            </div>
            <div class="col-md-6">
                <h2>{{ $livro->nome }}</h2>
                <p>{{ $livro->categoria }}</p>
                <p>{{ $livro->descricao }}</p>
			
                <form method="POST" action="{{ route('carrinho.add', $livro->id) }}">
                    @csrf
                    <button type="submit" class="btn btn-primary">Efetuar empréstimo</button>
                </form>
            </div>
        </div>
    </div>
@endsection
