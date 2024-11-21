package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.CustomerDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author dhijadhav
 */

@Repository
public interface CustomerDocumentsRepository extends JpaRepository<CustomerDocuments, Long> {

    @Query("From CustomerDocuments WHERE customerId =:customerId and documentType=:documentType")
    Optional<CustomerDocuments> findByIdAndDocumentType(@Param("customerId") Long customerId, @Param("documentType") String documentType);

    @Query("From CustomerDocuments WHERE customerId =:customerId")
    List<CustomerDocuments> findByCustomerId(@Param("customerId") Long customerId);

    @Query(value = "select * from financedb.customer_documents cd where cd.customer_id in \n" +
            "(select c.id from financedb.customer c where c.company_id = :companyId  and cd.document_type = :documentType)", nativeQuery = true)
    List<CustomerDocuments> findByCompanyIdAndDocumentType(@Param("companyId") Long companyId, @Param("documentType") String documentType);


}
