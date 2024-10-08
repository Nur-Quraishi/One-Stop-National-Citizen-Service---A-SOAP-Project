package bd.ac.du.iit.onestopcitizenservice.userservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import bd.ac.du.iit.onestopcitizenservice.userservice.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM one_stop_citizen_service.user WHERE email=:providedEmail AND password=:providedPassword"
    )
    Optional<User> findUserByEmailAndPassword(@Param("providedEmail") String providedEmail, @Param("providedPassword") String providedPassword);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.user WHERE email=:providedEmail"
    )
    Optional<User> findUserByEmail(@Param("providedEmail") String providedEmail);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.user WHERE mobile_no=:providedMobileNo AND password=:providedPassword"
    )
    Optional<User> findUserByMobileNoAndPassword(@Param("providedMobileNo") String providedMobileNo, @Param("providedPassword") String providedPassword);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM one_stop_citizen_service.user WHERE mobile_no=:providedMobileNo"
    )
    Optional<User> findUserByMobileNo(@Param("providedMobileNo") String providedMobileNo);
}
