<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

//definir os atributos que serão preechidos para as  especificações dos livros
class Livro extends Model
{
    use HasFactory;
    protected $fillable=[
        'nome',
        'descricao',
        'categoria',
        'quantidade',
        'img'
    ];
}
