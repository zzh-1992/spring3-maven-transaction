package com.grapefruit.spring3maven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @Id
    private String id;

    private String name;

    private String address;
    // 其他属性和方法...
}
