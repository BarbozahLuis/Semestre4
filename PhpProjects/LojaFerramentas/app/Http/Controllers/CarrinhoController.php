<?php

namespace App\Http\Controllers;

use App\Models\Carrinho;
use App\Models\Produto;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;


class CarrinhoController extends Controller
{
    public function add(Request $request, Produto $produto){
        $dados = $request->validate([
            'quantidade'=> 'required|numeric|min:1'
        ]);

        Carrinho::create(['id_produto'=>$produto->id, 
                            'id_user'=>Auth::id(),
                            'quantidade'=>$dados]);

        return redirect()->route('produtos.show', $produto)
        ->with('success','Produto adicionado ao Carrinho.');
    }
}
