package com.hotsystemsng.lumexpress.data.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class LumExpressUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String imageUrl;
    private boolean isEnabled;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Notification> messages = new ArrayList<>();
}
