package uz.protshm.recommenduz.service.fileItem;

import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;
import uz.protshm.recommenduz.dto.FileItemResponse;


public interface FileItemService {
    FileItemResponse productFile(MultipartFile file) throws IOException;

    byte[] getFile(String uid) throws IOException;
}
