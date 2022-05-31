package edu.weber.cs.w01378454.cs3270a7;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import edu.weber.cs.w01378454.cs3270a7.DB.AppDatabase;
import edu.weber.cs.w01378454.cs3270a7.DB.Student;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseEditFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View root;

    private TextInputLayout Id;
    private TextInputLayout CourseName;
    private TextInputLayout CourseCode;
    private TextInputLayout StartAt;
    private TextInputLayout EndAt;

    private Button AddNewCourse;
    private Button RetrieveCourses;
    private Button DetailsOfSelectedCourse;
    private Button EditSelectedCourse;
    private Button DeleteSelectedCourse;



    public CourseEditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseEditFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseEditFragment newInstance(String param1, String param2) {
        CourseEditFragment fragment = new CourseEditFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_course_edit, container, false);

    }


    @Override
    public void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Background

                AppDatabase db = AppDatabase.getInstance(getContext());

                //Retrieve a list of courses (in the DAO)
             /*   List<Student> students = db.studentDAO().ListOfCourses();
                Log.d("All_Students", "All_Students: " + students);*/
            }
        }).start();

        Id = root.findViewById(R.id.id);
        CourseName = root.findViewById(R.id.course_name);
        CourseCode = root.findViewById(R.id.course_code);
        StartAt = root.findViewById(R.id.start_at);
        EndAt = root.findViewById(R.id.end_at);

        AddNewCourse = root.findViewById(R.id.btnAddNewCourse);
        RetrieveCourses = root.findViewById(R.id.btnRetrieve_Courses);
        DetailsOfSelectedCourse = root.findViewById(R.id.btnDetailsOfSelectedCourse);
        EditSelectedCourse = root.findViewById(R.id.btnEditSelectedCourse);
        DeleteSelectedCourse = root.findViewById(R.id.btnDeleteSelectedCourse);




        AddNewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = Id.getEditText().getText().toString();
                final String course_name = CourseName.getEditText().getText().toString();
                final String course_code = CourseCode.getEditText().getText().toString();
                final String start_at = StartAt.getEditText().getText().toString();
                final String end_at = EndAt.getEditText().getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Background

                        AppDatabase db = AppDatabase.getInstance(getContext());
                        //Add a new course to the database (via the UI & in the DAO)
                        db.studentDAO().AddACourse(new Student(id,course_name,course_code, start_at, end_at));




                    }
                }).start();

                        Toast toast = Toast.makeText(getContext(), "New Course Added", Toast.LENGTH_SHORT);
                        toast.show();

                        Id.getEditText().setText("");
                        CourseName.getEditText().setText("");
                        CourseCode.getEditText().setText("");
                        StartAt.getEditText().setText("");
                        EndAt.getEditText().setText("");
                AppDatabase db = AppDatabase.getInstance(getContext());


            }
        });

        RetrieveCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = Id.getEditText().getText().toString();
                final String course_name = CourseName.getEditText().getText().toString();
                final String course_code = CourseCode.getEditText().getText().toString();
                final String start_at = StartAt.getEditText().getText().toString();
                final String end_at = EndAt.getEditText().getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Background

                        AppDatabase db = AppDatabase.getInstance(getContext());

                        //Retrieve a list of courses (in the DAO)
                        List<Student> students = db.studentDAO().ListOfCourses();
                        Log.d("All_Students", "All_Students: " + students);
                    }
                }).start();

                Id.getEditText().setText("");
                CourseName.getEditText().setText("");
                CourseCode.getEditText().setText("");
                StartAt.getEditText().setText("");
                EndAt.getEditText().setText("");

                Toast toast = Toast.makeText(getContext(), "All Courses Retrieved", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        DetailsOfSelectedCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = Id.getEditText().getText().toString();
                final String course_name = CourseName.getEditText().getText().toString();
                final String course_code = CourseCode.getEditText().getText().toString();
                final String start_at = StartAt.getEditText().getText().toString();
                final String end_at = EndAt.getEditText().getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Background

                        AppDatabase db = AppDatabase.getInstance(getContext());

                        //Retrieve a list of courses (in the DAO)
                        List<Student> students = (List<Student>) db.studentDAO().getCourseByID(id);
                        Log.d("All_Students", "All_Students: " + students);
                    }
                }).start();

                Id.getEditText().setText("");
                CourseName.getEditText().setText("");
                CourseCode.getEditText().setText("");
                StartAt.getEditText().setText("");
                EndAt.getEditText().setText("");

                Toast toast = Toast.makeText(getContext(), "All Courses Retrieved", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        EditSelectedCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = Id.getEditText().getText().toString();
                final String course_name = CourseName.getEditText().getText().toString();
                final String course_code = CourseCode.getEditText().getText().toString();
                final String start_at = StartAt.getEditText().getText().toString();
                final String end_at = EndAt.getEditText().getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Background

                        AppDatabase db = AppDatabase.getInstance(getContext());

                        //Edit a selected course (in the DAO)
                        db.studentDAO().EditASelectedCourse(new Student(id, course_name,course_code, start_at, end_at));


                    }
                }).start();

                Id.getEditText().setText("");
                CourseName.getEditText().setText("");
                CourseCode.getEditText().setText("");
                StartAt.getEditText().setText("");
                EndAt.getEditText().setText("");

                Toast toast = Toast.makeText(getContext(), "Selected Course Edited", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        DeleteSelectedCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = Id.getEditText().getText().toString();
                final String course_name = CourseName.getEditText().getText().toString();
                final String course_code = CourseCode.getEditText().getText().toString();
                final String start_at = StartAt.getEditText().getText().toString();
                final String end_at = EndAt.getEditText().getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Background

                        AppDatabase db = AppDatabase.getInstance(getContext());

                         //Delete a selected course (in the DAO)

                        db.studentDAO().DeleteSelectedCourse(new Student(id, course_name,course_code, start_at, end_at));

                    }
                }).start();

                Id.getEditText().setText("");
                CourseName.getEditText().setText("");
                CourseCode.getEditText().setText("");
                StartAt.getEditText().setText("");
                EndAt.getEditText().setText("");

                Toast toast = Toast.makeText(getContext(), "Selected Course Deleted", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }
}


