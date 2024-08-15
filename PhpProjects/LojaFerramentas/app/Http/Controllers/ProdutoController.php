<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Produto;

class ProdutoController extends Controller
{
    /**
     * lista todos os produtos
     */
    public function index()
    {
        $produtos = Produto::all();
        return view('produtos.index',compact('produtos'));
    }

    /**
     * abre o formulario de cadastro
     */
    public function create()
    {
        return view('produtos.create');
    }

    /**
     * armazena/envia o formulario de cadastro
     */
    public function store(Request $request)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
            'preco'=> 'required|numeric',
        ]);

        Produto::create($request->all());

        return redirect()->route('produtos.index')-> 
        with('success','Produto criado com sucesso');
    }

    

    /**
     * vai abrir todas as informações do produto para que possamos efetuar a edição do mesmo
     */
    public function edit(Produto $produto)
    {
        return view('produtos.edit',compact('produto'));
    }

    
    public function update(Request $request, Produto $produto)
    {
        $request->validate([
            'nome'=> 'required|string|max:255',
            'descricao'=> 'required',
            'categoria'=> 'required',
            'quantidade'=> 'required|numeric',
            'preco'=> 'required|numeric',
        ]);

        $produto->update($request->all()); //coletando o produto e efetuando um update/atualização das informações do produto

        return redirect()->route('produtos.index')-> 
        with('sucess','Produto atualizado com sucesso');
    }

    
    public function destroy(Produto $produto)
    {
        $produto->delete();


        return redirect()->route('produtos.index')->
        with('sucess','Produto Deletado com Sucesso');
    }
}
