@extends('layouts.app')


@section('content')


<div class="container">
    <h1 class="my-4">Livros</h1>


    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif


    <a class="btn btn-success mb-2" href="{{ route('livros.create') }}"> Inserir um Novo Livro</a>


    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Categoria</th>
            <th>Quantidade</th>
            <th width="280px">Ação</th>
        </tr>
        @foreach ($livros as $livro)
        <tr>
            <td>{{ $loop->iteration }}</td>
            <td>{{ $livro->nome }}</td>
            <td>{{ $livro->descricao }}</td>
            <td>{{ $livro->categoria}}</td>
            <td>{{ $livro->quantidade}}</td>
            <td>
                <form action="{{ route('livros.destroy', $livro->id) }}" method="POST">
                    {{-- <a class="btn btn-info" href="{{ route('livros.show', $livro->id) }}">Mostrar</a> --}}
                    <a class="btn btn-primary" href="{{ route('livros.edit', $livro->id) }}">Editar</a>


                    @csrf
                    @method('DELETE')
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </td>
        </tr>
        @endforeach
    </table>
</div>
@endsection
