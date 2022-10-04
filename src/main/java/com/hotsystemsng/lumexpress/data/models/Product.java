package com.hotsystemsng.lumexpress.data.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();
    private String imageUrl;
}
