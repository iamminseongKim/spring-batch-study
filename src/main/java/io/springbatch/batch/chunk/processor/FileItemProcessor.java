package io.springbatch.batch.chunk.processor;

import io.springbatch.batch.domain.Product;
import io.springbatch.batch.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {
    @Override
    public Product process(ProductVO item) throws Exception {
        return null;
    }
}