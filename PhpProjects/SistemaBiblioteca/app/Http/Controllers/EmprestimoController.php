<?php

namespace App\Http\Controllers;

use App\Models\Emprestimo;
use App\Models\Livro;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class EmprestimoController extends Controller
{
    public function add(Request $request, Livro $livro){
        $dados = $request->validate([
            'quantidade'=> 'required|numeric|min:1'
        ]);

        Emprestimo::create(['id_livro'=>$livro->id, 
                            'id_user'=>Auth::id(),
                            'quantidade'=>$request->quantidade]);

        return redirect()->route('livros.show', $livro)
        ->with('sucess','Livro emprestado com sucesso.');
    }
}
