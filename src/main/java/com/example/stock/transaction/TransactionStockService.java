package com.example.stock.transaction;

import com.example.stock.service.StockService;

public class TransactionStockService {

    private StockService stockService;

    public TransactionStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public void decress(Long id, Long quantity) {
        startTransaction();

        stockService.decress(id, quantity);

        endTransaction();
    }

    public void startTransaction() {

    }

    public void endTransaction() {

    }
}
