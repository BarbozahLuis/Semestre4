import connectMongo from '@/utils/dbConnect';
import Todo from '@/models/Todo';
import { NextResponse } from 'next/server';

//método put para atualizar/alterar informação referente a tarefa utilizando o id da tarefa
export async function PUT(req, { params }) {
  await connectMongo();
  try {
    const data = await req.json();//converte o que esta dentro do data(input) em json para conversar com o banco de dados
    const todo = await Todo.findByIdAndUpdate(params.id, data, {//coleta a informação através do parametro ID, e altera a informação que esta no data
      new: true,
      runValidators: true,
    });
    if (!todo) {
      return NextResponse.json({ success: false }, { status: 400 });
    }
    return NextResponse.json({ success: true, data: todo });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 400 });
  }
}

//método delete para deletar uma tarefa através do ID da tarefa
export async function DELETE(req, { params }) {
    await connectMongo();
    try {
        const deletedTodo = await Todo.deleteOne({ _id: params.id });
        if (!deletedTodo) {
            return NextResponse.json({ success: false }, { status: 400 });
        }
        return NextResponse.json({ success: true, data: {} });
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}
