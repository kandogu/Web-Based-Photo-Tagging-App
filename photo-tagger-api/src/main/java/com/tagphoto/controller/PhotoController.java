package com.tagphoto.controller;

import com.tagphoto.model.PhotoDto;
import com.tagphoto.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PhotoController {
    private final PhotoService photoService;

    @RequestMapping(value = "/main/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public PhotoDto get(@PathVariable String userName) {
        return photoService.get(userName);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.PUT)
    public void save(@PathVariable String id, @RequestParam("Tag") String tag) {
        photoService.putTag(id, tag);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam String userName) {
        return userName;
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String name) {
        photoService.deleteAssigment(name);
    }
}
