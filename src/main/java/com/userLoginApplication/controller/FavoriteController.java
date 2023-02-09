package com.userLoginApplication.controller;

import com.userLoginApplication.security.model.Favorite;
import com.userLoginApplication.service.FavoriteListService;
import com.userLoginApplication.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private FavoriteListService favoriteListService;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createUserFavourite(@RequestParam String username ) throws Exception {
        favoriteService.createFavorite(username);
    }
    @GetMapping(value = "/get")
    @CrossOrigin
    public Favorite getUserFavourite(@RequestParam Long favouriteId) throws Exception {
        return favoriteService.getFavoriteById(favouriteId);
    }
    @GetMapping(value = "/getAll")
    @CrossOrigin
    public List<Favorite> getAllUserFavourite(@RequestParam String username) throws Exception {
        return favoriteService.getAllFavoritesById(username);
    }

    @PutMapping(value = "/update")
    @CrossOrigin
    public void updateUserFavourite(@RequestParam Long favouriteId,
                                    @RequestBody Favorite favourite) throws Exception {
        favoriteService.updateFavoriteById(favouriteId,favourite );
    }

    @DeleteMapping(value = "/delete")
    @CrossOrigin
    public void deleteOrderById(@RequestParam Long favouriteId) throws Exception {
        favoriteService.deleteFavoriteById(favouriteId);
    }
}
