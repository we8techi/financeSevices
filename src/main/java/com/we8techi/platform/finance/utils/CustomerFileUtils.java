package com.we8techi.platform.finance.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

/**
 * @author dhijadhav
 */

@Slf4j
public class CustomerFileUtils {

    private CustomerFileUtils(){}

    public static String encodedBase64String(MultipartFile inputFile) throws IOException {
        if(inputFile != null) {
            byte[] fileContent = inputFile.getBytes();
            return Base64.getEncoder().encodeToString(fileContent);
        }
        return null;
    }

    public static byte[] decodedBase64String(String imageContent) {
        if(!StringUtils.isEmpty(imageContent)) {
            return Base64.getDecoder().decode(imageContent);
        }
        return null;
    }
}
