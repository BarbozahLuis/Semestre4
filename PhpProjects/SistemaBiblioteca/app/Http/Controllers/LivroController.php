<?php

namespace App\Http\Controllers;

use App\Models\Livro;
use Illuminate\Http\Request;

class LivroController extends Controller
{

    //lista todos os produtos
    public function index(){
        $livros=Livro::all();// essa variavel recebe todos os livros cadastrado no banco de dados utilizando esse metodo all
        return view ('livros.index',compact('livros'));//o compact livros busca todos os livros que estão no model esta diretamente ligado com o model
    }

    //Quando chamamos o create ele vai exibir o formulario para preenchermos
    public function create(){
        return view('livros.create');
    }

    //após o create efetuar a validar as informações a partir do store em seguida ele envia as informações para o banco de dados
    public function store(Request $request)
    {
        $request->validate([
            'nome'=>'required|string|max:255',
            'descricao'=>'required',
            'categoria'=>'required',
            'quantidade'=>'required|numeric',
        ]);

        Livro::create($request)->all();

        return redirect()->route('livros.index')->
        with('success', 'Livro Criado com Sucesso');
    }

    //o edit ira abrir todas as informações do produto para que possamos efetuar a edição do mesmo
    public function edit(Livro $livro){
        return view('livros.edit',compact('produto'));
    }

    //o update faz a atualização do produto, ele irá permitir que façamos alterações
    public function update(Request $request, Livro $livro){
        $request->validate([
            'nome'=>'required|string|max:255',
            'descricao'=>'required',
            'categoria'=>'required',
            'quantidade'=>'required|numeric',
        ]);

        $livro->update($request->all());//coletando a informação do livro desejado e efetuando o update/atualização das informações desse livro

        return redirect()->route('livros.index')->
        with('sucess','Livro atualizado com sucesso');
    }

    public function destroy(Livro $livro){
        $livro->delete();

        return redirect()->route('livros.index')->
        with('sucess','Livro Deletado com sucesso');
    }

    //exibir os livros em livrosController
    public function show(Livro $livro){
        return view('livros.show',compact('livro'));
    }

}
