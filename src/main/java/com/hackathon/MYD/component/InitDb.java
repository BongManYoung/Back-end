package com.hackathon.MYD.component;

import com.hackathon.MYD.model.product.ProductEntity;
import com.hackathon.MYD.model.product.repository.ProductRepository;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init1();
        initService.init2();
        initService.init3();
        initService.init4();
        initService.init5();
    }

    @RequiredArgsConstructor
    @Transactional
    @Component
    static class InitService {

        private final ProductRepository productRepository;
        private final StoreRepository storeRepository;

        List<ProductEntity> products = new ArrayList<>();

        public void init1() {
            StoreEntity store = new StoreEntity( "짬뽕과 손님 2호점");
            ProductEntity product1 = new ProductEntity("황금올리브", store);
            products.add(product1);
            ProductEntity product2 = new ProductEntity("짬뽕", store);
            products.add(product2);
            ProductEntity product3 = new ProductEntity("짜장면", store);
            products.add(product3);
            ProductEntity product4 = new ProductEntity("차돌박이 짬뽕", store);
            products.add(product4);
            ProductEntity product5 = new ProductEntity("쟁반 짜장", store);
            products.add(product5);
            ProductEntity product6 = new ProductEntity("삼선 짬뽕", store);
            products.add(product6);
            ProductEntity product7 = new ProductEntity("탕수육", store);
            products.add(product7);
            ProductEntity product8 = new ProductEntity("볶음밥", store);
            products.add(product8);
            ProductEntity product9 = new ProductEntity("깐쇼새우", store);
            products.add(product9);

            store.getProducts().addAll(products);

            storeRepository.save(store);
            productRepository.saveAll(products);
        }

        public void init2() {
            StoreEntity store = new StoreEntity( "네이스크림");
            ProductEntity product1 = new ProductEntity("엄마는 외계인", store);
            products.add(product1);
            ProductEntity product2 = new ProductEntity("아몬드 봉봉", store);
            products.add(product2);
            ProductEntity product3 = new ProductEntity("민트초코", store);
            products.add(product3);
            ProductEntity product4 = new ProductEntity("레인보우 샤베트", store);
            products.add(product4);
            ProductEntity product5 = new ProductEntity("아빠도 외계인", store);
            products.add(product5);
            ProductEntity product6 = new ProductEntity("짐스크림", store);
            products.add(product6);
            ProductEntity product7 = new ProductEntity("연어와 함께 춤을", store);
            products.add(product7);
            ProductEntity product8 = new ProductEntity("마녀의 과자", store);
            products.add(product8);
            ProductEntity product9 = new ProductEntity("치즈나무 숲", store);
            products.add(product9);
            ProductEntity product10 = new ProductEntity("뉴욕 치즈 케이크", store);
            products.add(product10);
            ProductEntity product11 = new ProductEntity("마법사의 할로윈", store);
            products.add(product11);
            ProductEntity product12 = new ProductEntity("더덕맛 아이스크림", store);
            products.add(product12);

            store.getProducts().addAll(products);

            storeRepository.save(store);
            productRepository.saveAll(products);
        }

        public void init3() {
            StoreEntity store = new StoreEntity( "종은이네 참치찌개");
            ProductEntity product1 = new ProductEntity("참치 김치 찌개", store);
            products.add(product1);
            ProductEntity product2 = new ProductEntity("참치 마요 볶음밥", store);
            products.add(product2);
            ProductEntity product3 = new ProductEntity("참치 비빔밥", store);
            products.add(product3);
            ProductEntity product4 = new ProductEntity("참치 죽", store);
            products.add(product4);
            ProductEntity product5 = new ProductEntity("참치 라면", store);
            products.add(product5);
            ProductEntity product6 = new ProductEntity("참치 김밥", store);
            products.add(product6);
            ProductEntity product7 = new ProductEntity("참치 부대찌개", store);
            products.add(product7);

            store.getProducts().addAll(products);

            storeRepository.save(store);
            productRepository.saveAll(products);
        }

        public void init4() {
            StoreEntity store = new StoreEntity("무리소 (무한 리필 소고기)");
            ProductEntity product1 = new ProductEntity("부채살", store);
            products.add(product1);
            ProductEntity product2 = new ProductEntity("갈비", store);
            products.add(product2);
            ProductEntity product3 = new ProductEntity("냉면", store);
            products.add(product3);
            ProductEntity product4 = new ProductEntity("된장찌개", store);
            products.add(product4);
            ProductEntity product5 = new ProductEntity("토시살", store);
            products.add(product5);
            ProductEntity product6 = new ProductEntity("우삼겹", store);
            products.add(product6);
            ProductEntity product7 = new ProductEntity("등심", store);
            products.add(product7);
            ProductEntity product8 = new ProductEntity("어", store);
            products.add(product8);

            store.getProducts().addAll(products);

            storeRepository.save(store);
            productRepository.saveAll(products);
        }

        public void init5() {
            // 블랙 슈가 버블티, 플레인요거트, 딸기요거트, 복숭아숭숭, 딸기 쏙쏙, 망고 스무디, 딸기 스무디, 밀크쉬이크, 파인 쏘다, 고구마 라떼, 청포도 에이드, 쿠키 프라프치
            StoreEntity store = new StoreEntity("더 미터");
            ProductEntity product1 = new ProductEntity("아메리카노", store);
            products.add(product1);
            ProductEntity product2 = new ProductEntity("카페라떼", store);
            products.add(product2);
            ProductEntity product3 = new ProductEntity("플레인 요거트", store);
            products.add(product3);
            ProductEntity product4 = new ProductEntity("딸기 요거트", store);
            products.add(product4);
            ProductEntity product5 = new ProductEntity("망고 요거트", store);
            products.add(product5);
            ProductEntity product6 = new ProductEntity("바닐라 라떼", store);
            products.add(product6);
            ProductEntity product7 = new ProductEntity("고구마 라떼", store);
            products.add(product7);
            ProductEntity product8 = new ProductEntity("복숭아 숭숭", store);
            products.add(product8);
            ProductEntity product9 = new ProductEntity("딸기 쏙쏙", store);
            products.add(product9);
            ProductEntity product10 = new ProductEntity("파인 쏘다", store);
            products.add(product10);
            ProductEntity product11 = new ProductEntity("밀크쉐이크", store);
            products.add(product11);
            ProductEntity product12 = new ProductEntity("블렉 슈가 버블티", store);
            products.add(product12);
            ProductEntity product13 = new ProductEntity("타로 버블티", store);
            products.add(product13);
            ProductEntity product14 = new ProductEntity("청포도 에이드", store);
            products.add(product14);
            ProductEntity product15 = new ProductEntity("쿠키 프라푸치노", store);
            products.add(product15);

            store.getProducts().addAll(products);

            storeRepository.save(store);
            productRepository.saveAll(products);
        }
    }
}
