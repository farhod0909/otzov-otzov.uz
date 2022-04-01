package uz.protshm.recommenduz.service.fileItem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.protshm.recommenduz.dto.FileItemResponse;
import uz.protshm.recommenduz.entities.FileItem;
import uz.protshm.recommenduz.repository.FileItemRepository;
import uz.protshm.recommenduz.service.fileItem.FileItemService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileItemServiceImpl implements FileItemService {

    private final FileItemRepository repository;


    @Override
    public FileItemResponse productFile(MultipartFile file) throws IOException {
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        if (file.getOriginalFilename().contains("..")) throw new RuntimeException("File name is invalid!");
        String fileName = uid + file.getOriginalFilename().replaceAll(" ", "");
        Files.copy(file.getInputStream(), Path.of(fileName));
        FileItem myFileEntity = new FileItem();
        myFileEntity.setUid(uid);
        myFileEntity.setUrl(fileName);
        myFileEntity.setFileName(file.getOriginalFilename());
        myFileEntity.setSize(file.getSize() / 1024);
        myFileEntity.setContentType(file.getContentType());
        repository.save(myFileEntity);
        return new FileItemResponse(uid);
    }

    @Override
    public byte[] getFile(String uid) throws IOException {
        FileItem fileInfo = repository.findByUidAndDeletedFalse(uid).orElseThrow(() -> new RuntimeException("File not found:" + uid));
        File file = new File(fileInfo.getUrl());
        return Files.readAllBytes(Path.of(fileInfo.getUrl()));
    }
}
