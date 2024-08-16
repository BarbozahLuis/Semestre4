<?php

namespace App\Http\Controllers;
use App\Models\Produto;
use Illuminate\Http\Request;

class DashboardController extends Controller
{
    public function index(Request $request)
    {
        $search = $request->input('search'); //digitar a pesquisa
        $produtos = Produto::when($search, function ($query, $search) { //buscar o produto
            return $query->where('nome', 'like', "%{$search}%") //busca o produto baseado na palavra que foi digitada na pesquisa do produto
                         ->orWhere('descricao', 'like', "%{$search}%")// o "like" é utilizado para buscar algo parecido com a palavra, se retirarmos irá buscar apenas coisas identicas a pesquisa
                         ->orWhere('categoria','like',"%{$search}%");
        })->get();




        return view('usuarios.dashboard', compact('produtos'));
    }
}

