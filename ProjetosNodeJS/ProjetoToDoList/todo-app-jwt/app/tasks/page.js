'use client';

import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';

export default function TaskPage() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState('');
  const router = useRouter();

  useEffect(() => {
    const fetchTasks = async () => {
      const token = localStorage.getItem('token');
      if (!token) {
        router.push('/login'); // Redireciona para login se o usuário não estiver autenticado
        return;
      }

      const response = await fetch('/api/tasks', {
        headers: {
          Authorization: `Bearer ${token}`, // Envia o token no header da requisição
        },
      });

      if (response.ok) {
        const data = await response.json();
        setTasks(data.tasks);
      } else {
        router.push('/login'); // Redireciona para login se houver erro
      }
    };

    fetchTasks();
  }, [router]);

  const addTask = async () => {
    const token = localStorage.getItem('token');
    const response = await fetch('/api/tasks', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ title: newTask }),
    });

    const data = await response.json();
    setTasks([...tasks, data.task]);
    setNewTask('');
  };

  const deleteTask = async (id) => {
    const token = localStorage.getItem('token');
    await fetch(`/api/tasks?id=${id}`, {
      method: 'DELETE',
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    setTasks(tasks.filter((task) => task._id !== id));
  };

  return (
    <div>
      <h1>Task List</h1>
      <input
        type="text"
        value={newTask}
        onChange={(e) => setNewTask(e.target.value)}
        placeholder="New task"
      />
      <button onClick={addTask}>Add Task</button>
      <ul>
        {tasks.map((task) => (
          <li key={task._id}>
            {task.title}
            <button onClick={() => deleteTask(task._id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
