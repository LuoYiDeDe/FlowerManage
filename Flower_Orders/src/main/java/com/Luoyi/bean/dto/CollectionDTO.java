package com.Luoyi.bean.dto;

import com.Luoyi.bean.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDTO {
    private Integer userid;
    private Products products;
}
