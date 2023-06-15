package in.gmsk.repository;

import in.gmsk.entity.Guardian;
import in.gmsk.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent(){

        Guardian guardian=Guardian.builder()
                .name("sivakumar")
                .mailId("sivakumar@gmail.com")
                .mobileNo("9876543210")
                .build();

        Student student=Student.builder()
                .firstName("karthik")
                .lastName("sivakumar")
                .email_id("karthik@gmail.com")
                .guardian(guardian)
                .build();

        studentRepo.save(student);
    }
    @Test
    public void getStudentDetails(){

        List<Student> students=studentRepo.findAll();

        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByFirstName(){
        
        List<Student> firstName= studentRepo.findByFirstName("karthik");

        System.out.println("first Name = " + firstName);
        
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> firstNameContaining = studentRepo.findByFirstNameContaining("k");

        System.out.println("first Name Containing = " + firstNameContaining);

    }
    @Test
    public void printStudentBasedOnGuardian(){

        List<Student> studentGuardian=studentRepo.findByGuardianName("sivakumar");

        System.out.println("students = " + studentGuardian);
    }
    @Test
    public void findByFirstNameAndLastname(){

        List<Student> studentDetails=studentRepo.findByFirstNameAndLastName("karthik","sivakumar");

        System.out.println("student Details = " + studentDetails);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student =
                studentRepo.getStudentByEmailAddress("karthik@gmail.com");

        System.out.println("student Details = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String email =
                studentRepo.getStudentFirstNameByEmailAddress("karthik@gmail.com");

        System.out.println("student email Details = " + email);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student =
                studentRepo.getStudentByEmailAddressNative("karthik@gmail.com");

        System.out.println("student Details For Native = " + student);
    }
}