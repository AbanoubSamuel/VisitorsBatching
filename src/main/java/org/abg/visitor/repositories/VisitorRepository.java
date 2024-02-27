package org.abg.visitor.repositories;

import org.abg.visitor.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
