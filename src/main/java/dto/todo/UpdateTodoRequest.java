package dto.todo;

import lombok.Getter;

@Getter
public class UpdateTodoRequest {
    private String title;
    private String content;
}
