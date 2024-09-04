import Todo from "@/models/Todo";
import connectMongo from "@/utils/db.Connect";

//criar o CRUD

//read
export const getTodos = async()=>{

    connectMongo;
    try{
        return await Todo.find();
    }catch(error){
        console.error(error);
    }

}



//create
export const createTodo = async(data)=>{
    connectMongo;

    try{
        return await Todo.create(data);
    }catch(error){
        console.error(error);
    }
}

export const updateTodo = async(id, data)=>{
    await connectMongo();
    try{return await Todo.findByIdAndUpdate(id, data, {new:true, runValidators: true,});
}catch(error){
    console.error(error);
}
};

export const deteleTodo =async (id)=>{
    await connectMongo();
    try{
        return await Todo.deleteOne({_id: id});

    }catch(error){
        console.error(error)
    }
}

