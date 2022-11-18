package com.rbc.dowjoneschallenge.storage;

import com.rbc.dowjoneschallenge.stock.StockRepository;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void store(MultipartFile file);

    void saveInDB(MultipartFile file, StockRepository repository);

}
