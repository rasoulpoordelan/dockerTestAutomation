package com.onetechone.access.repository;

import com.onetechone.access.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name,Long> {
}
