package com.rbc.dowjoneschallenge.stock;

import com.rbc.dowjoneschallenge.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class StockController {

    private final StockRepository repository;
    private final StorageService storageService;

    @Autowired
    StockController(StockRepository repository, StorageService storageService) {
        this.repository = repository;
        this.storageService = storageService;
    }

    @GetMapping("/stocks/{stock}")
    List<Stock> one(@PathVariable String stock) {

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher(stock, ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Stock> example = Example.of(Stock.from(stock), customExampleMatcher);

        List<Stock> stocks = repository.findAll(example);

        return stocks;
    }


    @PostMapping("/stocks")
    Stock newStock(@RequestBody Stock newStock) {
        return repository.save(newStock);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);

        storageService.saveInDB(file, repository);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded and saved in DB " + file.getOriginalFilename() + "!");

        return "Success";
    }

}
