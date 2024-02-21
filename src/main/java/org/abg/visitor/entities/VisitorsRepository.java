package org.abg.visitor.entities;

import org.abg.visitor.dto.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorsRepository extends JpaRepository<Visitor, Long> {
}
