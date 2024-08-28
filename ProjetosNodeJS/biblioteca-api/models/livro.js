const mongoose = require('mongoose'); //efetua a conexão com o banco de dados


const LivroSchema = new mongoose.Schema({

    //efetua a declaração dos atributos
    titulo: {
        type: String,
        required: true
    },
    autor: {
        type: String,
        required: true
    },
    ano: {
        type: Number,
        required: true
    },
    genero: {
        type: String,
        required: false //required obriga ou não a existir uma informação como esta false a informação não é obrigatória
    }
});

module.exports = mongoose.model('Livro', LivroSchema);