package io.springbatch.batch.chunk.writer;

import io.springbatch.batch.domain.ApiRequestVO;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class ApiItemWriter3 implements ItemWriter<ApiRequestVO> {
    @Override
    public void write(Chunk<? extends ApiRequestVO> chunk) throws Exception {

    }
}
