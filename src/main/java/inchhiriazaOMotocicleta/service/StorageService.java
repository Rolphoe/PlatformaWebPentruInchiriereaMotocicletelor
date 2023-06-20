package inchhiriazaOMotocicleta.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    private final String uploadDir = "src/main/resources/static/images/";


    public String storeFile(MultipartFile file) {
        File dir = new File(uploadDir);
        if (!dir.exists()){
            dir.mkdir();
        }

        String originalFilename = file.getOriginalFilename();

        try {
            Path filePath = Paths.get(uploadDir).resolve(originalFilename);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "/images/" + originalFilename;

        } catch (IOException e) {
            throw new RuntimeException("Nu sa putut încărca poza " + originalFilename + ". Încearcă din nou!", e);
        }
    }
}