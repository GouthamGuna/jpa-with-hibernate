package in.gmsk.service;

import in.gmsk.entity.FileData;
import in.gmsk.respository.StorageRepository;
import in.gmsk.util.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {

        FileData fileData = repository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(FilesUtils.compressImage(file.getBytes())).build());
        if (fileData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<FileData> dbImageData = repository.findByName(fileName);
        byte[] images=FilesUtils.decompressImage(dbImageData.get().getFileData());
        return images;
    }
}
