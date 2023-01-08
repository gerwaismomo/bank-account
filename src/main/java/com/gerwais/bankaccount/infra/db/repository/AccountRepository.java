package com.gerwais.bankaccount.infra.db.repository;

import com.gerwais.bankaccount.infra.db.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findTopByUserOrderByDateDesc(String user);

    List<AccountEntity> findAllByUserOrderByDateDesc(String user);

}
