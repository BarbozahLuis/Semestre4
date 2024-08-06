<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\VagaController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('vagas', [VagaController::class]);