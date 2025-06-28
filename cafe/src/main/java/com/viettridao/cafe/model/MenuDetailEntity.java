package com.viettridao.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_item_ingredients")
public class MenuDetailEntity {
    @EmbeddedId
    private MenuKey id;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("idMenuItem")
    @JoinColumn(name = "menu_item_id")
    private MenuItemEntity menuItem;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "unit")
    private String unitName;

    @Column(name = "is_deleted")
    private Boolean deleted;
}
