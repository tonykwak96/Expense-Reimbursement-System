package com.example.Project1.Repo;

import com.example.Project1.Models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReimbursementRepo extends JpaRepository<Reimbursement, Integer> {

    /**
     * Find reimbursement by Id
     * @param id
     * @return reimbursement instance
     */
    Optional<Reimbursement> findById(Integer id);

    /**
     * Find all reimbursements of given user id
     * @param id
     * @return list of reimbursements
     */
    List<Reimbursement> findAllById(@Param("id") int id);

    /**
     * Update reimbursement status
     * @param status
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value ="update reimbursements set status = ?1 where id = ?2", nativeQuery = true)
    void updateStatusById(String status, int id);

    /**
     * Update reimbursement user
     * @param user_id
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value ="update reimbursements set user_id = ?1 where id = ?2", nativeQuery = true)
    void updateUserById(int user_id, int id);

}
