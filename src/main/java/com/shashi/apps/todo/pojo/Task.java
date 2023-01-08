package com.shashi.apps.todo.pojo;

import java.sql.Date;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class )
@ToString
@Entity
@Table
@NamedQuery(name="Task.findByCreatedBy",
            query = "select t from Task t where t.user.id=:createdBy"
)
public @Data class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="sequence_on_task")
    @SequenceGenerator(name="sequence_on_task", sequenceName = "sequence_on_task", allocationSize = 1)
    private Long id;
    private String shortDesc;
    private String largeDesc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="created_by")
    @JsonBackReference
    private User user;
    private String scheduleType;
    private Date timing;
    private String status;
    private String comments;
    private Date createdAt;
    private Date updatedAt;
}
