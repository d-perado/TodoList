package controller;

import dto.todo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TodoService;

@RestController
@RequiredArgsConstructor
public class TodoController {
    TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<CreateTodoResponse> handlerCreateTodo(
            CreateTodoRequest request) {
        CreateTodoResponse result = todoService.createTodo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/todos")
    public ResponseEntity<GetTodoResponse> handlerGetTodo(
            @RequestParam Long todoId) {
        GetTodoResponse result = todoService.getTodo(todoId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/todos")
    public ResponseEntity<UpdateTodoResponse> handlerUpdateTodo(
            @RequestParam Long todoId,
            @RequestBody UpdateTodoRequest request) {
        UpdateTodoResponse result = todoService.updateTodo(todoId, request);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/todos")
    public ResponseEntity<Void> handlerDeleteTodo(
            @RequestParam Long todoId
    ) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
