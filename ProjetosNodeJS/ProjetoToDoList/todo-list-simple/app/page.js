'use client';

import { useState, useEffect } from 'react';

export default function Home() {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState('');
  const [editTodo, setEditTodo] = useState(null); // Para armazenar a tarefa que está sendo editada

  useEffect(() => {
    fetchTodos();
  }, []);

  // Mostrar as tarefas
  const fetchTodos = async () => {
    const response = await fetch('/api/todos');
    const data = await response.json();
    setTodos(data.data);
  };

  // Adicionar uma nova tarefa
  const addTodo = async () => {
    const response = await fetch('/api/todos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title: newTodo, completed: false }), // Adicionando status "completed"
    });
    const data = await response.json();
    setTodos([...todos, data.data]);
    setNewTodo('');
  };

  // Atualizar uma tarefa existente
  const updateTodo = async (id, updatedTodo) => {
    await fetch(`/api/todos/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(updatedTodo),
    });
    // Atualiza a lista local após a atualização
    setTodos(todos.map(todo => (todo._id === id ? { ...todo, ...updatedTodo } : todo)));
    setEditTodo(null); // Limpar a tarefa que está sendo editada
  };

  // Deletar uma tarefa
  const deleteTodo = async (id) => {
    await fetch(`/api/todos/${id}`, {
      method: 'DELETE',
    });
    setTodos(todos.filter((todo) => todo._id !== id));
  };

  // Manipular a edição da tarefa
  const handleEdit = (todo) => {
    setEditTodo(todo);
  };

  // Manipular a mudança do checkbox
  const handleCheckboxChange = (id, completed) => {
    updateTodo(id, { completed: !completed });
  };

  // Manipular a alteração do título da tarefa
  const handleTitleChange = (e) => {
    setEditTodo({
      ...editTodo,
      title: e.target.value,
    });
  };

  // Finalizar a edição
  const handleUpdate = () => {
    if (editTodo) {
      updateTodo(editTodo._id, editTodo);
    }
  };

  return (
    <div>
      <h1>To-Do List</h1>
      <input
        type="text"
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
        placeholder="Adicionar nova tarefa"
      />
      <button onClick={addTodo}>Adicionar Tarefa</button>

      <ul>
        {todos.map((todo) => (
          <li key={todo._id}>
            {todo.title} - 
            {todo.completed ? 'Concluido':'Pendente'}
            <input
              type="checkbox"
              checked={todo.completed}
              onChange={() => handleCheckboxChange(todo._id, todo.completed)}
            />
            
            {editTodo && editTodo._id === todo._id ? (
              <>
                <input
                  type="text"
                  value={editTodo.title}
                  onChange={handleTitleChange}
                />
                <button onClick={handleUpdate}>Salvar</button>
              </>
              
            ) : (
              <>
                
                <button onClick={() => handleEdit(todo)}>Editar</button>
              </>
            )}
            
            <button onClick={() => deleteTodo(todo._id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
