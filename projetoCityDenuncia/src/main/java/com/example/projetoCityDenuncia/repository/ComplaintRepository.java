package com.example.projetoCityDenuncia.repository;

import com.example.projetoCityDenuncia.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
