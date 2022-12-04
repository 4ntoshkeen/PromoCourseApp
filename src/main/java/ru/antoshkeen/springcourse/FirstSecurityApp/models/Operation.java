package ru.antoshkeen.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "operation")
public class Operation {

    @ManyToOne
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;

    @Column(name = "operationcode")
    String operationCode;

    @Column(name = "protocol")
    String protocol;

    public Operation(Person owner, String name, String type, String operationCode, String protocol) {
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.operationCode = operationCode;
        this.protocol = protocol;
    }

    public Operation() {

    }


    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}


