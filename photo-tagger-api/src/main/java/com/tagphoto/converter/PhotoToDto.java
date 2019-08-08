package com.tagphoto.converter;

import com.tagphoto.model.Photo;
import com.tagphoto.model.PhotoDto;
import org.springframework.stereotype.Component;

@Component
public class PhotoToDto {

    public PhotoDto convert(Photo photo){
        PhotoDto photoDto = new PhotoDto();
        photoDto.setId(photo.getId());
        photoDto.setAddress(photo.getAddress());
        return photoDto;
    }
}
