package com.example.asm.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadFile {

        public File handerUpLoadFile(MultipartFile uploadFile) {
            String folderPath = "F:\\Java5\\ASM_Java5\\src\\main\\resources\\static\\image";
            File myUpLoadFolder = new File(folderPath);
            // thiếu thì tạo
            if (!myUpLoadFolder.exists()) {
                myUpLoadFolder.mkdirs();
            }
            File saveFile = null;
            try {
                // Lưu file vào thư mực
                saveFile = new File(myUpLoadFolder, uploadFile.getOriginalFilename());
                // chuyển dữ liệu sang file vừa tạo
                uploadFile.transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return saveFile;
        }
    }
