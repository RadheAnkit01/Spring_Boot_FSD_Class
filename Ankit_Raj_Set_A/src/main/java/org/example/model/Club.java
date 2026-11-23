package org.example.model;

import jakarta.persistence.*;

@Table(name = "club")
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "category", unique = true, length = 100)
    private String category;
    @Column(name = "facultyCoordinator", unique = false, length = 100)
    private String facultyCoordinator;
    @Column(name = "maxMembers", length = 100)
    private int maxMembers;
    @Column(name = "description", length = 300)
    private String description;

    public Club(String name, String category, String facultyCoordinator, int maxMembers, String description) {
        this.name = name;
        this.category = category;
        this.facultyCoordinator = facultyCoordinator;
        this.maxMembers = maxMembers;
        this.description = description;
    }

    public Club() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFacultyCoordinator() {
        return facultyCoordinator;
    }

    public void setFacultyCoordinator(String facultyCoordinator) {
        this.facultyCoordinator = facultyCoordinator;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
