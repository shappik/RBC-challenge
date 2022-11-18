package com.rbc.dowjoneschallenge.storage;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.rbc.dowjoneschallenge.stock.LoadDatabase;
import com.rbc.dowjoneschallenge.stock.Stock;
import com.rbc.dowjoneschallenge.stock.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public void saveInDB(MultipartFile file, StockRepository repository) {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<Stock> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Stock.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Stock> stocks = csvToBean.parse();
            repository.saveAll(stocks);

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
