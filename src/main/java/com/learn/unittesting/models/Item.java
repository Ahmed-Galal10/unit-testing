package com.learn.unittesting.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    int id;
    String name;
    String brand;
    int quantity;
    double price;

    public Item(int id, String name, String brand, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
    }
}
