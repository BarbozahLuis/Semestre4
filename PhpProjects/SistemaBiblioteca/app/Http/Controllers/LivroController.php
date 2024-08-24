<?php

namespace App\Http\Controllers;

use App\Models\Livro;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class LivroController extends Controller
{

    //lista todos os livros
    public function index()
    {
        $livros = Livro::all();// essa variavel recebe todos os livros cadastrado no banco de dados utilizando esse metodo all
         return view('livros.index',compact('livros')); //esse compact livros, buscas todos os livros do model pois o model esta ligado diretamente com o banco de dados
    }

    /**
     * abre o formulario de cadastro
     */
    //quando chamamos a create ele vai exibir o formulario para preenchermos
    public function create()
    {
        return view('livros.create');
    }

    /**
     * armazena/envia o formulario de cadastro
     */
    //após o create ele vai validar as informações a partir do store, e em seguida enviar as informações para o banco de dados
    public function store(Request $request)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
        ]);

        Livro::create($request->all());

        return redirect()->route('livros.index')-> 
        with('sucess','Livro criado com sucesso');
    }

    

    /**
     * vai abrir todas as informações do livro para que possamos efetuar a edição do mesmo
     */
    public function edit(Livro $livro)
    {
        return view('livros.edit',compact('livro'));
    }

    
    public function update(Request $request, Livro $livro)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
        ]);

        $livro->update($request->all()); //coletando o livro e efetuando um update/atualização das informações do livro

        return redirect()->route('livros.index')-> 
        with('sucess','Livro atualizado com sucesso');
    }

    
    public function destroy(Livro $livro)
    {
        $livro->delete();


        return redirect()->route('livros.index')->
        with('sucess','Livro Deletado com Sucesso');
    }

    //mostrar os livros em livrocontroller
    public function show(Livro $livro){
        return view('livros.show',compact('livro'));
    }

}
