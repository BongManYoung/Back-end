package com.hackathon.MYD.model.store;

import com.hackathon.MYD.model.product.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 허새찬
 */
@Entity(name = "store")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeIdx;

    @Column(name = "store_name")
    private String storeName;

    @OneToMany(mappedBy = "storeIdx")
    @Column(name = "product_id")
    private final List<ProductEntity> products = new ArrayList<>();

    public StoreEntity(String storeName) {
        this.storeName = storeName;
    }
}
