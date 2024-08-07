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
	
	List<Student> findByStudentName(String name);
	 Optional<Student> findById(int id);
	 @Query("UPDATE Student s SET s.student_name = :name, s.student_address = :add, s.student_gender = :gender, s.student_dob = :date, s.student_qualification = :qual, s.student_mobile = :mob WHERE s.student_id = :id")
	 void updateStudent(@Param("name") String name,
			 				@Param("add") String add, 
			 				@Param("gender") String gender,
			 				@Param("url") String url,
			 				@Param("date")	Date date,
			 				@Param("qual") String qual, 
			 				@Param("mob") String mob,
			 				@Param("id") int id);
}

