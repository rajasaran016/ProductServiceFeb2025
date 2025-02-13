package com.firstapp.productservicefeb2025.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {

    private String title;
    private String description;
    private String image;
    private CategoryRequestDTO category;
}
