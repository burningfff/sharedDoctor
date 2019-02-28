package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface BalanceRepository extends JpaRepository<Balance,String> {

    Balance findBalanceByBalanceId(String balanceId);

    void deleteBalanceByBalanceId(String balanceId);
}
