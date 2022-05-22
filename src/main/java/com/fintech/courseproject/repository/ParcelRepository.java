package com.fintech.courseproject.repository;

import com.fintech.courseproject.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
