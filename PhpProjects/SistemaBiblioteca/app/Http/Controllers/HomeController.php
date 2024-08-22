<?php


namespace App\Http\Controllers;


use App\Http\Controllers\Controller;
use App\Models\Livro;


class HomeController extends Controller
{
    public function index()
    {
        // Pegue os livros mais recentes, por exemplo
        $livros = Livro::take(5)->get();
        return view('home', compact('livros'));
    }
}
