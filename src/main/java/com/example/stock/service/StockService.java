package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional

    /*
        java synchronized 문제점
        서버가 1대일때는 되는듯싶으나 여러대의 서버를 사용하게되면 사용하지 않았을때와 동일한 문제가 발생된다.
        인스턴스단위로 thread-safe 이 보장이 되고, 여러서버가 된다면 여러개의 인스턴스가 있는것과 동일기때문입니다.
     */
    public synchronized void decress(Long id, Long quantity) {
        /*
            get stock
            재고감소
            저장
         */

        Stock stock = stockRepository.findById(id).orElseThrow();

        stock.decress(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
