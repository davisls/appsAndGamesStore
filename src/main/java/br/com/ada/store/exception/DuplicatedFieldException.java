package br.com.ada.store.exception;

public class DuplicatedFieldException extends RuntimeException {
    public DuplicatedFieldException(String field) {
        super("this " + field + " already exists");
    }
}
