<?php

use App\Http\Controllers\ProdutoController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;

//rota para exibir a pagina home
Route::get('/', function () {
    return view('home');
});

//no código abaixo a rota do tipo get vai ser para mostrar o formulário na tela
Route::get('/registro',[UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

//no código abaixo a rota do tipo post vai ser para processar o formulário após preenchido, quando clicar no botão de enviar, ele vai enviar as informações para o banco de dados
Route::post('/registro',[UserController::class, 'registro'])->
name('usuarios.registro');


//no código abaixo a rota do tipo get vai ser para mostrar o login na tela
Route::get('/login',[UserController::class, 'showLoginForm'])->
name('usuarios.login');

//no código abaixo a rota do tipo post vai ser para processar o login após preenchido, quando clicar no botão de enviar, ele vai enviar as informações para o banco de dados
Route::post('/login',[UserController::class, 'login'])->
name('usuarios.login');

//criar uma rota para página interna onde ela só pode ser acessado se o usuário tiver feito o login
Route::get('/dashboard',function(){
    return view('usuarios.dashboard');
})->middleware('auth')->name('usuarios.dashboard');    //nessa linha faremos a autenticação(validação) para que apenas o usuário que efetuou o login possa acessar


//rota do botão logout
Route::post('/logout',[UserController::class,'logout']);

//rota produtos
Route::resource('produtos', ProdutoController::class)->middleware('auth');