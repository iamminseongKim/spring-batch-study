package io.springbatch.batch.partition;

import io.springbatch.batch.domain.ProductVO;
import io.springbatch.batch.job.api.QueryGenerator;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ProductPartitioner implements Partitioner {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        ProductVO[] products = QueryGenerator.getProductList(dataSource);
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 0;

        for (ProductVO product : products) {
            ExecutionContext value = new ExecutionContext();

            result.put("partition" + number, value);
            value.put("product", product);

            number++;
        }

        return result;
    }
}
