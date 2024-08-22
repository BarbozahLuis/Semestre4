<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    //exibir formulario de login
    public function showLoginForm(){
        return view('usuarios.login');
    }

    //processar o login do usuário para acesso
    public function login(Request $request){
        $credentials = $request->validate([ //efetua a validação das credenciais solicitada abaixo
            'email'=>['required', 'email'],
            'password'=>['required'],
        ]);

        //criar If para efetuar a validação, e após a validação enviar para a página interna de livros
        if(Auth::guard('web')->attempt($credentials)){
            $request->session()->regenerate();
            return redirect()->intended('/dashboard'); //redireciona o cliente para a página interna de livros
        }

        //caso as crêdenciais solicitadas estejam incorretas retorna a mensagem abaixo
        return back()->withErrors([
            'email'=>'As credenciais não correspondem aos nossos registros.',
        ])->onlyInput('email');
    }

    //Exibir formulario de registro
    public function showRegistroForm(){
        return view('usuarios.registro');
    }

    //Processar o registro de um novo usuário
    public function registro(Request $request){
        //efetua a validação das informações preechidas
        $request->validate([
            'name'=>'required|string|max:255',
            'email'=>'required|string|email|max:255|unique:users',
            'password'=>'required|string|min:8|confirmed', //essa linha serve para os dois inputs de preencher a senha e de confirmação de senha
        ]);

        //efetua a criação da conta do usuário
        $usuario = User::create([
            'name'=>$request->name,
            'email'=>$request->email,
            'password'=>Hash::make($request)
        ]);
        //após a criação redireciona a pessoa para a página home
        return redirect('/login');
    }

    public function logout(Request $request){
        Auth::logout();

        $request->session()->regenerateToken();
        $request->session()->invalidate();
        $request->session()->regenerate();

        return redirect('/');
    }


}
