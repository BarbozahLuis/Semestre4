<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Carrinho extends Model
{
    //hasfactory é para efetuar a conexão com o banco de dados
    use HasFactory;
    protected $fillable=[
        'id_produto','id-user','quantidade','status'
    ];
}
