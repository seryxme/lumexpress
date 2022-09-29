package com.hotsystemsng.lumexpress.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
//@PropertySource("classpath:application.properties")
public class CloudinaryCloudServiceImpl implements CloudService {

//    private @Value("${cloudinary.cloud.name}") String CLOUD_NAME;
//
//    private @Value("${cloudinary.api.key}") String API_KEY;
//
//    private @Value("${cloudinary.api.secret}") String API_SECRET;
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dbgweeutq",
            "api_key", "137758798898716",
            "api_secret", "lXelA3eV8AHLz-w3xSdS5IrBe1Q",
            "secure", true));

    @Override
    public String upload(byte[] imageBytes, Map<?, ?> map) throws IOException {
        var uploadResponse = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
        return uploadResponse.get("url").toString();
    }
}
