package com.hackathon.MYD.model.product;

import com.hackathon.MYD.model.store.StoreEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author 허새찬
 */
@Entity(name = "product")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productIdx;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeIdx;

    public ProductEntity(String productName, StoreEntity storeIdx) {
        this.productName = productName;
        this.storeIdx = storeIdx;
    }
}
