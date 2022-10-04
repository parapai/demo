package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TblKaryawan;

@Repository
public interface KaryawanRepository extends JpaRepository<TblKaryawan, String>{

	
}
