package in.gmsk.repository;

import in.gmsk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String name);

     List<Student> findByFirstNameAndLastName(String firstName, String lastName);

     @Query("select s from Student s where s.email_id = ?1") // JPQL
     Student getStudentByEmailAddress(String mailId);

     @Query("select s.firstName from Student s where s.email_id = ?1") // JPQL
     String getStudentFirstNameByEmailAddress(String mailId);

     @Query(
             value = "SELECT * FROM student_registration sr where sr.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String mailId);
}
