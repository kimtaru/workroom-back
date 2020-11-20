package com.workroom.springboot.domain.issues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IssuesRepository extends JpaRepository<Issues, Long> {

}
