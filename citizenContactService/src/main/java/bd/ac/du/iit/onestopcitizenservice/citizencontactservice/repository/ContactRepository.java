package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.repository;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.entities.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.contact WHERE name LIKE %:providedName%"
    )
    List<Contact> findContactByName(@Param("providedName") String providedName, @Param("sortOrder") Sort sortOrder);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.contact WHERE category=:providedCategory"
    )
    List<Contact> findContactByCategory(@Param("providedCategory") String providedCategory, @Param("sortOrder") Sort sortOrder);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.contact WHERE contact_no LIKE %:providedContactNo%"
    )
    List<Contact> findContactByContactNo(@Param("providedContactNo") String providedContactNo, @Param("sortOrder") Sort sortOrder);
}
