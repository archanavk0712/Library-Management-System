package com.library.models;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String book;    // New Field
    private String author;  // New Field

    public Student(String studentId, String name, String email, String book, String author) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.book = book;
        this.author = author;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBook() { return book; }
    public void setBook(String book) { this.book = book; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
