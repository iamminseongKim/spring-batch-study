package io.springbatch.batch.chunk.writer;

import io.springbatch.batch.domain.ApiRequestVO;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class ApiItemWriter1 implements ItemWriter<ApiRequestVO> {
    @Override
    public void write(Chunk<? extends ApiRequestVO> chunk) throws Exception {

    }
}
