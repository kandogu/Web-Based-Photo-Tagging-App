package com.tagphoto.query;

import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.SimpleN1qlQuery;

public class PhotoQuery {

    private PhotoQuery() {

    }


    private static final String UNTAGGED_PHOTO = "SELECT meta().id as id," +
            "           address FROM `Images` WHERE tagList=[] AND assignedTo=\"\" LIMIT 1";

    private static final String ASSIGNNED_PHOTO = "SELECT meta().id AS id," +
            "           address FROM `Images` WHERE tagList=[] AND assignedTo=\"";

    //gets a untagged photo from pics bucket
    public static SimpleN1qlQuery untaggedPhoto() {
        return N1qlQuery.simple(UNTAGGED_PHOTO);
    }

    //gets a untagged and assigned photo with given name from pics bucket
    public static SimpleN1qlQuery assignedPhoto(String username) {
        return N1qlQuery.simple(ASSIGNNED_PHOTO + username + "\"");
    }
}
