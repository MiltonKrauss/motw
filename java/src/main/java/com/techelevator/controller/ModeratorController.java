package com.techelevator.controller;

import com.techelevator.dao.ModeratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;


@CrossOrigin
@RestController
@PreAuthorize("hasAnyRole('ADMIN', 'MOD')")
public class ModeratorController {

    @Autowired
    private ModeratorDao modDao;


    //moderator services
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/moderator/characters/{id}", method = RequestMethod.DELETE)
    public void deleteCharacterById(@PathVariable int id) {
        if(!modDao.deleteCharacterById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/moderator/ban/{id}", method = RequestMethod.PUT)
    public void banUser(@PathVariable int id) {
        if(!modDao.banUser(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}