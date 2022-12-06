package com.roxana.share.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roxana.share.entity.Share;

@Repository
public interface ShareDao extends JpaRepository<Share, Integer> {

}
