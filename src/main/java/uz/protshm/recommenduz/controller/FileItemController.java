package uz.protshm.recommenduz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.protshm.recommenduz.dto.FileItemResponse;

import uz.protshm.recommenduz.service.fileItem.FileItemService;


import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file-item")
@RequiredArgsConstructor
public class FileItemController {

    private final FileItemService service;

    @GetMapping(value = "/{uid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFile(@PathVariable String uid) throws IOException {
        return service.getFile(uid);
    }

    @PostMapping
    public FileItemResponse saveFile(@RequestParam MultipartFile file) throws IOException {
        return service.productFile(file);
    }
}
