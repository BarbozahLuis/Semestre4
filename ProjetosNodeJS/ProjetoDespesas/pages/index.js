import { useState, useEffect } from "react";
import styles from "./styles.module.css"; // Importa o arquivo de estilos CSS

const Home = () => {
  const [tasks, setTasks] = useState([]);
  const [formData, setFormData] = useState({
    title: "",
    value: "",
    dueDate: "",
  });
  const [isAdding, setIsAdding] = useState(false);
  const [isEditing, setIsEditing] = useState(null);

  // Fetch tasks from the API
  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await fetch("/api/task");
        const data = await response.json();
        if (Array.isArray(data)) {
          setTasks(data);
        } else {
          console.error("Unexpected data format:", data);
        }
      } catch (error) {
        console.error("Failed to fetch tasks:", error);
      }
    };

    fetchTasks();
  }, []);

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  // Submit form (add or edit task)
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const method = isEditing ? "PUT" : "POST";
      const url = isEditing ? `/api/task/${isEditing}` : "/api/task";
      
      const response = await fetch(url, {
        method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      const result = await response.json();

      if (response.ok) {
        if (isEditing) {
          setTasks((prev) =>
            prev.map((task) => (task.id === isEditing ? result : task))
          );
        } else {
          setTasks((prev) => [...prev, result]);
        }
        resetForm();
      } else {
        alert(result.message || "Error occurred");
      }
    } catch (error) {
      console.error("Failed to submit task:", error);
      alert("Error occurred while submitting the task.");
    }
  };

  // Edit task
  const handleEdit = (task) => {
    setFormData({
      title: task.title,
      value: task.value,
      dueDate: task.dueDate,
    });
    setIsEditing(task.id);
    setIsAdding(true);
  };

  // Delete task
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this task?")) {
      try {
        await fetch(`/api/task/${id}`, { method: "DELETE" });
        setTasks((prev) => prev.filter((task) => task.id !== id));
      } catch (error) {
        console.error("Failed to delete task:", error);
        alert("Error occurred while deleting the task.");
      }
    }
  };

  // Reset form
  const resetForm = () => {
    setFormData({
      title: "",
      value: "",
      dueDate: "",
    });
    setIsEditing(null);
    setIsAdding(false);
  };

  return (
    <>
      <header className={styles.header}>
        <div className={styles.headerContent}>
          <div className={styles.logo}>
            <img src="/img/logo.png" alt="Logo" />
          </div>
        </div>
      </header>

      <main className={styles.main}>
        <div className={styles}>
          <h1 className={styles.title}>Minhas Despesas</h1>
          <button
            className={styles.addBtn}
            onClick={() => setIsAdding((prev) => !prev)}
          >
            {isEditing ? "Edit Task" : "Adicione uma nova despesa"}
          </button>
        </div>

        {isAdding && (
          <form className={styles.taskForm} onSubmit={handleSubmit}>
            <input
              type="text"
              name="title"
              value={formData.title}
              onChange={handleInputChange}
              placeholder="Title"
              required
            />
            <input
              type="number"
              name="value"
              value={formData.value}
              onChange={handleInputChange}
              placeholder="Value"
              step="0.01"
              required
            />
            <input
              type="date"
              name="dueDate"
              value={formData.dueDate}
              onChange={handleInputChange}
              required
            />
            <button type="submit">
              {isEditing ? "Save Changes" : "Adicione uma despesa"}
            </button>
            <button type="button" onClick={resetForm}>
              Cancel
            </button>
          </form>
        )}

        <div className={styles.taskList}>
          {tasks.length > 0 ? (
            tasks.map((task) => (
              <div key={task.id} className={styles.taskItem}>
                <h3>{task.title}</h3>
                <p>Valor: R${task.value}</p>
                <p>Data: {new Date(task.dueDate).toLocaleDateString()}</p>
                <div className={styles.actions}>
                  <button onClick={() => handleEdit(task)}>Editar</button>
                  <button onClick={() => handleDelete(task.id)}>Deletar</button>
                </div>
              </div>
            ))
          ) : (
            <p>Não existe nenhuma despesa disponivel.</p>
          )}
        </div>
      </main>

      <footer className={styles.footer}>
        <p>&copy; Suas despesas sempre seguras</p>
        <div className={styles.socialLinks}>
          <a href="#" target="_blank" rel="noopener noreferrer">
            <i className="fab fa-facebook"></i>
          </a>
          <a href="#" target="_blank" rel="noopener noreferrer">
            <i className="fab fa-instagram"></i>
          </a>
        </div>
      </footer>
    </>
  );
};

export default Home;
