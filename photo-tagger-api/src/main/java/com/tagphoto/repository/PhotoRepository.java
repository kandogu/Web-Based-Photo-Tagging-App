package com.tagphoto.repository;

import com.couchbase.client.java.query.N1qlQueryResult;
import com.tagphoto.model.Photo;
import com.tagphoto.query.PhotoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PhotoRepository {

    private final CouchbaseTemplate photoCouchbaseTemplate;

    public Optional<Photo> findById(String id) {
        return Optional.ofNullable(photoCouchbaseTemplate.findById(id, Photo.class));
    }

    public void save(Photo photo) {
        photoCouchbaseTemplate.save(photo);
    }


    public Photo getPhoto() {
        String id;
        N1qlQueryResult result = photoCouchbaseTemplate.getCouchbaseBucket().query(PhotoQuery.untaggedPhoto());
        boolean flag = result.allRows()
                .stream()
                .findFirst()
                .isPresent();
        if (flag) {
            id = result.allRows()
                    .stream()
                    .findFirst().get().value()
                    .get("id").toString();
            if (findById(id).isPresent())
                return findById(id).get();
            else
                return null;
        }
        return null;
    }

    public Optional<Photo> getPhotoWithUser(String username) {
        String id = "empty";
        N1qlQueryResult result = photoCouchbaseTemplate.getCouchbaseBucket().query(PhotoQuery.assignedPhoto(username));
        boolean flag = result.allRows()
                .stream()
                .findFirst()
                .isPresent();
        if (flag) {
            if (result.allRows().stream().findFirst().isPresent())
                id = result.allRows()
                        .stream()
                        .findFirst()
                        .get().value()
                        .get("id").toString();
            else
                id = null;
            return Optional.ofNullable(photoCouchbaseTemplate.findById(id, Photo.class));
        }
        return Optional.ofNullable(photoCouchbaseTemplate.findById(id, Photo.class));
    }

}
