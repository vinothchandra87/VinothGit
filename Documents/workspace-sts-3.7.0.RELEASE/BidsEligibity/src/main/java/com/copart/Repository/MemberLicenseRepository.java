package com.copart.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.copart.Enity.MemberLicense;

public interface MemberLicenseRepository extends CrudRepository<MemberLicense, Integer> {
	
	List<MemberLicense> findById(int id);

}
