package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//All the business logic is used in this class
@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextId++,"Excel",166.99,"pleasedownload.com",4.3));

        products.add(new PhysicalProduct(nextId++,"Keyboard",55.67, 20.0, "3*4*3"));
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p
                        .getId().equals(id))
                        .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p ->p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries(){
        List<String> summaries = new ArrayList<>();

        for(Product p : products){
            summaries.add(p.getSummary());
        }

        return summaries;
    }
}
