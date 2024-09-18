import Expense from "@/models/Expense";
import connectMongo from "@/utils/dbConnect";

export const getExpenses = async (req, res) => {
    await connectMongo();
    try {
        const expenses = await Expense.find({ userId: req.user.userId });
        res.status(200).json({ expenses });
    } catch (error) {
        res.status(500).json({ error });
    }
};

export const addExpense = async (req, res) => {
    const { title, amount } = req.body;
    await connectMongo();
    try {
        const newExpense = new Expense({
            title,
            amount,
            userId: req.user.userId
        });
        await newExpense.save();
        res.status(201).json({ expense: newExpense });
    } catch (error) {
        res.status(500).json({ message: 'Erro ao adicionar despesa' });
    }
};

export const updateExpense = async (req, res) => {
    const { id } = req.query;
    const data = req.body;
    await connectMongo();

    try {
        const updatedExpense = await Expense.findOneAndUpdate(
            { _id: id, userId: req.user.userId },
            { $set: data },
            { new: true }
        );
        if (!updatedExpense) return res.status(404).json({ message: 'Despesa não encontrada' });
        res.status(200).json({ expense: updatedExpense });
    } catch (error) {
        res.status(500).json({ message: 'Erro ao atualizar despesa' });
    }
};

export const deleteExpense = async (req, res) => {
    const { id } = req.query;
    await connectMongo();

    try {
        const deletedExpense = await Expense.findOneAndDelete({
            _id: id, userId: req.user.userId
        });
        if (!deletedExpense) return res.status(404).json({ message: 'Despesa não encontrada' });
        res.status(200).json({ message: 'Despesa deletada com sucesso' });
    } catch (error) {
        res.status(500).json({ message: 'Erro ao deletar despesa' });
    }
};
