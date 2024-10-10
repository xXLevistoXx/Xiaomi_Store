package com.web_project.school.service;

import com.web_project.school.model.WishlistModel;

import java.util.List;
import java.util.UUID;

public interface WishlistService {
    public List<WishlistModel> findAllWishlists();

    public WishlistModel findWishlistById(UUID id);

    public WishlistModel addWishlist(WishlistModel wishlist);

    public WishlistModel updateWishlist(WishlistModel wishlist);

    public void deleteWishlist(UUID id);
}