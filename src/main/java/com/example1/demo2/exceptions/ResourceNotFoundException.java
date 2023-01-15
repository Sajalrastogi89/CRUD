package com.example1.demo2.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

   private String ResourceName;
   private String FeildName;
   private int FeildId;

    public ResourceNotFoundException(String resourceName, String feildName, int feildId) {
        super(String.format("%s does not have %s feild value:%d",resourceName,feildName,feildId));
        ResourceName = resourceName;
        FeildName = feildName;
        FeildId = feildId;
    }
}
