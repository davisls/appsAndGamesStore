package br.com.ada.store.exception;

public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException() {
        super("Library not found");
    }
}
