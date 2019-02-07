package com.prus.library.shell;

import com.prus.library.entities.CommentEntity;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@AllArgsConstructor
@ShellComponent
public class CommentCommands {

    private CommentService service;

    @ShellMethod("Get all comments by book id: ID")
    public String getAllCommentsByBookId(Long id) {
        return service.findAllByBookId(id).stream().map(CommentEntity::toString).collect(Collectors.joining("\n"));
    }

    @ShellMethod("Add comment to book: TEXT BOOK_ID")
    public void addCommentToBook(String text, Long bookId) {
        service.save(new CommentEntity(text, bookId));
    }

    @ShellMethod("Delete comment by id: ID")
    public void deleteCommentById(Long id) {
        service.deleteById(id);
    }

}
