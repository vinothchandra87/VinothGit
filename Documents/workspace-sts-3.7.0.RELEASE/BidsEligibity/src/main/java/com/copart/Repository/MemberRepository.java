package com.copart.Repository;

import com.copart.Enity.Member;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {

	
	List<Member> findById(int id);

}
