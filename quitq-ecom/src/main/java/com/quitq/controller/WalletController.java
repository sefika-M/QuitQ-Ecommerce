package com.quitq.controller;

import com.quitq.model.Wallet;
import com.quitq.model.WalSource;
import com.quitq.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

  
    @PostMapping("/addWallet")
    public Wallet addWallet(@RequestBody Wallet wallet) {
        return walletService.addWallet(wallet);
    }

    @GetMapping("getWalletsByUserId/{userId}")
    public List<Wallet> getWalletsByUserId(@PathVariable int userId) {
        return walletService.getWalletsByUserId(userId);
    }
    
    @GetMapping("/getAllWallets")
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }
    

    @GetMapping("/getWalletBywalletId/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable int walletId) {
        return walletService.searchByWalletId(walletId);
    }
}
