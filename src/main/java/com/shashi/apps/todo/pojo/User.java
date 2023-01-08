package com.shashi.apps.todo.pojo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties
@Entity
@Table(name="todo_user")
public @Data class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_on_todo_user")
    @SequenceGenerator(name = "sequence_on_todo_user", sequenceName = "sequence_on_todo_user", allocationSize = 1)
    private Long id;
    private String name;
    private String type;
    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> task;
    private String email;
    private String contactNumber;
    private String addrLine;
    private String pincode;
    private String country;
    private String state;
    private String city;
    private Date createdAt;
    private Date updatedAt;
}
