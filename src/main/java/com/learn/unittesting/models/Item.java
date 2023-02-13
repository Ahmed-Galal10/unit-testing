package com.learn.unittesting.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private String brand;
    private int quantity;
    private double price;
    @Transient
    private double totalValue;

    public Item(int id, String name, String brand, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
    }
}
