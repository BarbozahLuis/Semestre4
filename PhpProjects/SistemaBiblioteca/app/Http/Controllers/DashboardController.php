<?php


namespace App\Http\Controllers;


use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Livro;


class DashboardController extends Controller
{
    public function index(Request $request)
    {
        $search = $request->input('search'); //digitar a pesquisa
        $livros = Livro::when($search, function ($query, $search) { //buscar o livro
            return $query->where('nome', 'like', "%{$search}%") //busca o livro baseado na palavra que foi digitada na pesquisa do livro
                         ->orWhere('descricao', 'like', "%{$search}%")// o "like" é utilizado para buscar algo parecido com a palavra, se retirarmos irá buscar apenas coisas identicas a pesquisa
                         ->orWhere('categoria','like',"%{$search}%");
        })->get();




        return view('usuarios.dashboard', compact('livros'));
    }
}
