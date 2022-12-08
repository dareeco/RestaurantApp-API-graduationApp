package com.example.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "restaurant_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String orderType; //Beer, Wine, Alcohol
    private String orderSpecificName; //Smirnoff Votka, Maraska Rum,Gin Sax Jagermaister...
    private Integer quantity;  //1,3,5...
    private String quantityType; //Bottles, Packs, Crates
}
