package br.com.olivum.banking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bank", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@GenericGenerator(name = "id", strategy = "native")
public class Bank implements Serializable {
    @Id
    @GeneratedValue(generator = "id")
    @Column(name = "id")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
