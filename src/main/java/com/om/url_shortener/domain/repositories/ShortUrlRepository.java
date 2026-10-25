package com.om.url_shortener.domain.repositories;

import com.om.url_shortener.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface  ShortUrlRepository extends JpaRepository<ShortUrl,Long> {
    @Query("select s from ShortUrl s where s.isPrivate = false")
    Page<ShortUrl> findPublicShortUrls(Pageable pageable);

    Page<ShortUrl> findByCreatedById(Long userId, Pageable pageable);

    long deleteByIdInAndCreatedById(List<Long> ids, Long userId);

    @Query("select s from ShortUrl s")
    Page<ShortUrl> findAllShortUrls(Pageable pageable);

    Optional<ShortUrl> findByShortKey(String shortKey);

    boolean existsByShortKey(String shortKey);
}
