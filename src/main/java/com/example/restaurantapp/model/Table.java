package com.example.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "restaurant_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<MenuItem> menuItems;
    private float totalSum;
    private String TableName;

}
