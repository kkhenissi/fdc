package kkhenissi.fidecoin.billingservice.repository;

import kkhenissi.fidecoin.billingservice.enteties.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
