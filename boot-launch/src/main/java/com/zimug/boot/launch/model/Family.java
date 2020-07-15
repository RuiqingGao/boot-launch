package com.zimug.boot.launch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Family {
    @Value("${family.family-name}")
    private String familyName;
}