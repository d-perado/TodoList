package dto.todo;

import lombok.Getter;

@Getter
public class CreateTodoRequest {
    private String title;
    private String content;
}
