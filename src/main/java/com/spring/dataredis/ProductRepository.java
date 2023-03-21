package com.spring.dataredis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final RedisTemplate redisTemplate;
    String HASH_KEY = "Product";

    public Product save(Product p) {
        redisTemplate.opsForHash().put(HASH_KEY, String.valueOf(p.getId()), p);

        return p;
    }


    public List<Product> findAll() {
        return redisTemplate.opsForHash()
                            .values(HASH_KEY);
    }

    public Product findById(int id) {
        return (Product) redisTemplate.opsForHash()
                            .get(HASH_KEY, String.valueOf(id));
    }

    public String deleteProduct(int id) {
         redisTemplate.opsForHash()
                            .delete(HASH_KEY, String.valueOf(id));
        return "Product removed";
    }
}
