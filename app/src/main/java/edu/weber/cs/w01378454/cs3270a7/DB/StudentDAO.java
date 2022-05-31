package edu.weber.cs.w01378454.cs3270a7.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    //Add a new course to the database (via the UI & in the DAO)
    /*@Query("Insert Into Student(id, course_name,course_code, start_at, end_at) Values(':id',':name',':course_code',':start_at',':end_at')")
    Student AddACourse(String id, String course_name, String course_code, String start_at, String end_at);*/

    //Retrieve a list of courses (in the DAO)
    @Query("Select * from student")
    List<Student> ListOfCourses();

    //View the details of a selected course (in the DAO)
    @Query("Select * from student WHERE id like :id LIMIT 1")
    Student getCourseByID(String id);


    @Update
    void EditASelectedCourse(Student... student); //Edit a selected course (in the DAO)

    //Delete a selected course (in the DAO)
    @Delete
    void DeleteSelectedCourse(Student student); //Delete a selected course (in the DAO)

    //Add a new course to the database (via the UI & in the DAO)
    @Insert
    void AddACourse(Student... student); //Update Selected Course



}
