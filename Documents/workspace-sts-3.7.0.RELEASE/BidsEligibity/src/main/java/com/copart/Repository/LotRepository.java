package com.copart.Repository;

import com.copart.Enity.Lot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LotRepository extends CrudRepository<Lot,Integer>{
	List<Lot> findById(int id);
	

}
