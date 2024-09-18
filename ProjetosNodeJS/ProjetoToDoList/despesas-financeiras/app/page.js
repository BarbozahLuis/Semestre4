'use client';

import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';

export default function TaskPage() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState('');
  const router = useRouter();

  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await fetch('/api/tasks');
        if (response.ok) {
          const data = await response.json();
          setTasks(data.tasks);
        } else {
          console.error('Failed to fetch tasks');
        }
      } catch (error) {
        console.error('An error occurred while fetching tasks:', error);
      }
    };

    fetchTasks();
  }, []);

  const addTask = async () => {
    try {
      const response = await fetch('/api/tasks', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title: newTask }),
      });

      if (response.ok) {
        const data = await response.json();
        setTasks([...tasks, data.task]);
        setNewTask('');
      } else {
        console.error('Failed to add task');
      }
    } catch (error) {
      console.error('An error occurred while adding task:', error);
    }
  };

  const deleteTask = async (id) => {
    try {
      await fetch(`/api/tasks?id=${id}`, {
        method: 'DELETE',
      });

      setTasks(tasks.filter((task) => task._id !== id));
    } catch (error) {
      console.error('An error occurred while deleting task:', error);
    }
  };

  return (
    <div>
      <div className="header">
        <img src="https://i.imgur.com/tN7q4jN.png" alt="FinTrack Logo" />
        <button>Logout</button>
      </div>
      <div className="container">
        <h1>FinTrack</h1>
        <div className="input-group">
          <label htmlFor="new-task">Insira uma nova tarefa:</label>
          <input
            type="text"
            id="new-task"
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
            placeholder="Nova tarefa"
          />
          <button onClick={addTask} className="add-task-button">Adicionar Tarefa</button>
        </div>
        {tasks.map((task) => (
          <div className="input-group" key={task._id}>
            <label htmlFor={`task-${task._id}`}>{task.title}:</label>
            <input type="text" id={`task-${task._id}`} value={task.title} readOnly />
            <div className="button-group">
              <button className="edit">Editar</button>
              <button className="delete" onClick={() => deleteTask(task._id)}>Deletar</button>
              <button className="concluded">Concluído</button>
            </div>
          </div>
        ))}
      </div>
      <div className="footer">
        <button>Sobre nós</button>
        <button>Contato</button>
      </div>
    </div>
  );
}
