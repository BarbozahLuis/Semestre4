import { jwtMiddleware } from "@/utils/middleware";
import { getExpenses, addExpense, updateExpense, deleteExpense } from "@/controllers/ExpenseController";

export async function GET(req, res) {
    return jwtMiddleware(async (req, res) => {
        await getExpenses(req, res);
    })(req, res);
}

export async function POST(req, res) {
    return jwtMiddleware(async (req, res) => {
        await addExpense(req, res);
    })(req, res);
}

export async function PUT(req, res) {
    return jwtMiddleware(async (req, res) => {
        await updateExpense(req, res);
    })(req, res);
}

export async function DELETE(req, res) {
    return jwtMiddleware(async (req, res) => {
        await deleteExpense(req, res);
    })(req, res);
}
