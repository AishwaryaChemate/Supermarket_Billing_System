package com.market.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.demo.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
