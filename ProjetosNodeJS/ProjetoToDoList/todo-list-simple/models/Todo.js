import mongoose from 'mongoose';

// base da coleção referente ao banco de dados mongoDB que é não relacional, irá conectar o model com o a coleção do banco de dados
const TodoSchema = new mongoose.Schema({
  title: {
    type: String,
    required: true,
  },
  completed: {
    type: Boolean,
    default: false,
  },
});


export default mongoose.models.Todo || mongoose.model('Todo', TodoSchema);
