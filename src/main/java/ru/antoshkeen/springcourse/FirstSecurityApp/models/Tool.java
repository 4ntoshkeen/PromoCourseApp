package ru.antoshkeen.springcourse.FirstSecurityApp.models;

import javax.persistence.*;

@Entity
@Table(name = "tool")
public class Tool {
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

    @Column(name = "size")
    String size;

    @Column(name = "quantity")
    int quantity;

    @Override
    public String toString() {
        return "Tool{" +
                "owner=" + owner +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }

    public Tool(String name, String type, String size, int quantity, Person owner) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.owner = owner;
    }

    public Tool() {

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
