package com.waltr.waltr.repository;

import com.waltr.waltr.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}