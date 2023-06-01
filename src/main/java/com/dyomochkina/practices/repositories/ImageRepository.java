package com.dyomochkina.practices.repositories;

import com.dyomochkina.practices.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
