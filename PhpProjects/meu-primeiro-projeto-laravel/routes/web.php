<?php

use App\Http\Controllers\ProdutoController;
use Illuminate\Support\Facades\Route;

Route::get('/home', function () {
    return view('home');
});

Route::get('/contato', function () {
    return view('contato');
});

Route::get('/produtos', [ProdutoController::class, 'index']);

Route::get('/', function () {
    return view('home');
});
