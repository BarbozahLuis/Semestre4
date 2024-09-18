'use client';

import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';

export default function ExpensePage() {
    const [expenses, setExpenses] = useState([]);
    const [newExpense, setNewExpense] = useState({ title: '', amount: '' });
    const router = useRouter();

    useEffect(() => {
        const fetchExpenses = async () => {
            const token = localStorage.getItem('token');
            if (!token) {
                router.push('/login');
                return;
            }

            const response = await fetch('/api/expenses', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });

            if (response.ok) {
                const data = await response.json();
                setExpenses(data.expenses);
            } else {
                router.push('/login');
            }
        };

        fetchExpenses();
    }, [router]);

    const addExpense = async () => {
        const token = localStorage.getItem('token');
        const response = await fetch('/api/expenses', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify(newExpense),
        });

        const data = await response.json();
        setExpenses([...expenses, data.expense]);
        setNewExpense({ title: '', amount: '' });
    };

    const deleteExpense = async (id) => {
        const token = localStorage.getItem('token');
        await fetch(`/api/expenses?id=${id}`, {
            method: 'DELETE',
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });

        setExpenses(expenses.filter((expense) => expense._id !== id));
    };

    return (
        <div>
            <h1>Gerenciamento Financeiro</h1>
            <input
                type="text"
                placeholder="Título da Despesa"
                value={newExpense.title}
                onChange={(e) => setNewExpense({ ...newExpense, title: e.target.value })}
            />
            <input
                type="number"
                placeholder="Valor"
                value={newExpense.amount}
                onChange={(e) => setNewExpense({ ...newExpense, amount: e.target.value })}
            />
            <button onClick={addExpense}>Adicionar Despesa</button>
            <ul>
                {expenses.map((expense) => (
                    <li key={expense._id}>
                        {expense.title} - ${expense.amount}
                        <button onClick={() => deleteExpense(expense._id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
