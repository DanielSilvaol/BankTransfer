package com.work.cvc.transfer.Infra.Repository;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransferRepository extends JpaRepository<Transfer,Integer> {
}
