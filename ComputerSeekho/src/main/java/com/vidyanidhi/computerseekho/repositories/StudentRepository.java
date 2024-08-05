package com.vidyanidhi.computerseekho.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidyanidhi.computerseekho.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	@Query("SELECT s FROM Student s WHERE s.student_name = :name")
    List<Student> findByStudentName(@Param("name") String name);
	 Optional<Student> findById(int id);
	 @Modifying
	    @Transactional
	    @Query("UPDATE Student s SET s.student_name = :name, s.student_address = :address, s.student_gender = :gender, " +
	           "s.photo_url = :url, s.student_dob = :dob, s.student_qualification = :qualification, s.student_mobile = :mobile " +
	           "WHERE s.student_id = :id")
	    void updateStudent(@Param("name") String name,
	                       @Param("address") String address,
	                       @Param("gender") String gender,
	                       @Param("url") String url,
	                       @Param("dob") Date dob,
	                       @Param("qualification") String qualification,
	                       @Param("mobile") String mobile,
	                       @Param("id") int id);
}

