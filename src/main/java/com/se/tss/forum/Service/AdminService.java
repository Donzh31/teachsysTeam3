package com.se.tss.forum.Service;

import com.se.tss.forum.Entity.Adm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminService extends JpaRepository<Adm, String> {

}

