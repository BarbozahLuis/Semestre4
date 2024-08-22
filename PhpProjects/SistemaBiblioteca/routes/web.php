<?php

use App\Http\Controllers\LivroController;
use App\Http\Controllers\DashboardController;
use App\Http\Controllers\HomeController;
use App\Http\Middleware\LivrosMiddleware;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;

//pagina inicial de Livros
Route::get('/', [HomeController::class, 'index'])->name('home');

//rota do tipo get será utilizada para mostrar o formulário na tela
Route::get('/registro',[UserController::class, 'showRegistroForm'])->
name('usuarios.registro');

//rota do tipo post será para processar o formulário após ele estar preenchido corretamente, as informações serão enviadas para o banco de dados
Route::post('/registro',[UserController::class, 'registro'])->
name('usuarios.registro');

//rota do tipo get será para mostrar a tela de login
Route::get('/login',[UserController::class, 'showLoginForm'])->
name('usuarios.login');

//rota do tipo post para processar o login após preenchido, as informações serão enviadas para o banco de dados
Route::post('/login', [UserController::class, 'login'])->
name('usuarios.login');

//rota para página interna onde ela só pode ser acessada após o usuário ter feito o login
Route::get('/dashboard',[DashboardController::class,'index'])//criar esse código após a criação da dashboardcontroller
->middleware('auth')->name('dashboard');    //nessa linha faremos a autenticação(validação) para que apenas o usuário que efetuou o login possa acessar

//rota do botão logout
Route::post('/logout',[UserController::class,'logout']);

Route::resource('livros',LivroController::class)->
middleware(LivrosMiddleware::class)->except('show');

//rota para visualização de um livro especifico
Route::get('livros/{livro}', [LivroController::class, 'show'])
->middleware('auth')->name('livros.show');



