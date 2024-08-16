<?php

namespace App\Http\Controllers;
use App\Models\Produto;

class HomeController extends Controller
{
    public function index()
    {

        //Pegue os 5 produtos mais recentes, por exemplo
        $produtos = Produto::take(5)->get(); //metódo take utilizado para pegar os ultimos 5 produtos criados
        return view('home', compact('produtos'));
    }
}
