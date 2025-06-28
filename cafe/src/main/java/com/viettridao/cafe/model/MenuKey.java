package com.viettridao.cafe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MenuKey {
    @Column(name = "product_id")
    private Integer idProduct;

    @Column(name = "menu_item_id")
    private Integer idMenuItem;
}
