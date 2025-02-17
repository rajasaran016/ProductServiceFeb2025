package com.firstapp.productservicefeb2025.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;
}
