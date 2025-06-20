package com.quitq.repo;

import com.quitq.model.Wallet;
import com.quitq.model.WalSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    List<Wallet> findByUserUserId(int userId);
    Wallet findByUserUserIdAndWalSource(int userId, WalSource walSource);

}
