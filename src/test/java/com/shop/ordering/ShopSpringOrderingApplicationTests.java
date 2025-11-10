package com.shop.ordering;

import com.shop.ordering.domain.model.utility.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopSpringOrderingApplicationTests {

    @Test
    void contextLoads() {
        var teste = IdGenerator.generateTimeBasedUUID();
        System.out.println(teste);

    }

}
