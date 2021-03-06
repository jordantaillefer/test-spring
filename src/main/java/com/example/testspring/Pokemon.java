package com.example.testspring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    public Pokemon() {
    }

    public Pokemon(UUID id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Pokemon(String name, String type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
    }

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}