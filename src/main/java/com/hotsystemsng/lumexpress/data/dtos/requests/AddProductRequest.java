package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Validated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private int quantity;
    @NotNull
    private MultipartFile image;

}
