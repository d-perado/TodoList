package service;

import dto.todo.*;
import entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {
    TodoRepository todoRepository;


    public CreateTodoResponse createTodo(CreateTodoRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getContent());
        Todo savedTodo = todoRepository.save(todo);

        return new CreateTodoResponse(savedTodo);
    }

    public GetTodoResponse getTodo(Long todoId) {
        Todo foundTodo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다."));
        return new GetTodoResponse(foundTodo);
    }

    public UpdateTodoResponse updateTodo(Long todoId, UpdateTodoRequest request) {
        Todo foundTodo = todoRepository.findById(todoId).orElseThrow(
                ()-> new IllegalStateException("존재하지 않는 일정입니다."));

        foundTodo.modify(request.getTitle(), request.getContent());

        return new UpdateTodoResponse(foundTodo);
    }

    public void deleteTodo(Long todoId) {
        boolean existence = todoRepository.existsById(todoId);
        if(!existence) return;
        todoRepository.deleteById(todoId);
    }
}
