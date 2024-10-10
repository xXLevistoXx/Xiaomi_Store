package com.web_project.school.service;

import com.web_project.school.model.WishlistModel;
import com.web_project.school.repository.WishlistRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryWishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;

    public InMemoryWishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public List<WishlistModel> findAllWishlists() {
        return wishlistRepository.findAll(Sort.by("id"));
    }

    @Override
    public WishlistModel findWishlistById(UUID id) {
        return wishlistRepository.findById(id).orElse(null);
    }

    @Override
    public WishlistModel addWishlist(WishlistModel wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public WishlistModel updateWishlist(WishlistModel wishlist) {
        if (wishlistRepository.existsById(wishlist.getId())) {
            return wishlistRepository.save(wishlist);
        }
        return null;
    }

    @Override
    public void deleteWishlist(UUID id) {
        if (wishlistRepository.existsById(id)) {
            wishlistRepository.deleteById(id);
        }
    }
}