package com.tagphoto.service;

import com.tagphoto.converter.PhotoToDto;
import com.tagphoto.model.Photo;
import com.tagphoto.model.PhotoDto;
import com.tagphoto.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoToDto photoToDto;

    public PhotoDto get(String userName) {
        Photo photo;
        System.out.println(userName);
        if (!photoRepository.getPhotoWithUser(userName).isPresent()){
            photo = photoRepository.getPhoto();
            if (photo == null){
                    return null;
            }
            photo.setAssignedTo(userName);
            photoRepository.save(photo);
        }
        else {
            photo = photoRepository.getPhotoWithUser(userName).get();
        }
        return photoToDto.convert(photo);
    }

    public void putTag(String id, String tag) {
        if (photoRepository.findById(id).isPresent()) {
            Photo photo = photoRepository.findById(id).get();
            photo.addTag(tag);
            photoRepository.save(photo);
        }
    }

    public void deleteAssigment(String name){
        Photo photo;
        if(photoRepository.getPhotoWithUser(name).isPresent()){
            photo = photoRepository.getPhotoWithUser(name).get();
            photo.setAssignedTo("");
            photoRepository.save(photo);
        }
    }
}
