package com.hotsystemsng.lumexpress.data.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Cart cart;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set<Address> address = new HashSet<>();

}

