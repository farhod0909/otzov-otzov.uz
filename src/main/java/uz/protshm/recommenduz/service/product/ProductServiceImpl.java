package uz.protshm.recommenduz.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.protshm.recommenduz.dto.ProductCreatedDto;
import uz.protshm.recommenduz.dto.ProductDto;
import uz.protshm.recommenduz.entities.FileItem;
import uz.protshm.recommenduz.entities.Product;
import uz.protshm.recommenduz.repository.FileItemRepository;
import uz.protshm.recommenduz.repository.ProductRepository;
import uz.protshm.recommenduz.service.product.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final FileItemRepository fileRepository;

    @Override
    public ProductDto add(ProductCreatedDto dto) {
        checkDto(dto);
        return ProductDto.toDto(repository.save(Product.builder()
                .name(dto.getName())
                .photos(dto.getPhotos().stream().map(fileRepository::getByUid).collect(Collectors.toList()))
                .build()));
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product product = get(id);
        product.setName(dto.getName());
        List<FileItem> photos = new ArrayList<>();
        for (String photo : dto.getPhotos()) {
            photos.add(fileRepository.findByUidAndDeletedFalse(photo).orElseThrow(() -> new RuntimeException("File not found!")));
        }
        product.setPhotos(photos);
        return ProductDto.toDto(repository.save(product));
    }

    @Override
    public void delete(Long id) {
        repository.delete(get(id));
    }

    @Override
    public ProductDto getOne(Long id) {
        return ProductDto.toDto(get(id));
    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        repository.findAll().forEach(it -> {
            productDtos.add(ProductDto.toDto(it));
        });
        return ResponseEntity.ok(productDtos);
    }

    private void checkDto(ProductCreatedDto dto) {
        if (dto.getName() == null) {
            throw new RuntimeException("Name is null or empty.");
        } else if (dto.getName().isEmpty()) {
            throw new RuntimeException("Name is null or empty.");
        }
        dto.getPhotos().forEach(photoUid -> {
            if (!fileRepository.existsByUid(photoUid)) {
                throw new RuntimeException("File not found = " + photoUid);
            }
        });
    }


    private Product get(Long id) {
        Optional<Product> byDeletedFalseAndId = repository.findByDeletedFalseAndId(id);
        if (byDeletedFalseAndId.isPresent()) {
            return byDeletedFalseAndId.get();
        } else {
            throw new RuntimeException("Product not found!");
        }

    }
}
