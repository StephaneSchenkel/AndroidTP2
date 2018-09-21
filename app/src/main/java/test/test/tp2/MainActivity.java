package test.test.tp2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.test.model.Student;

public class MainActivity extends AppCompatActivity {

    public static List<Student> StudentList;

    private Button addStudentButton;
    private Button listStudentButton;

    private static final int ADD_STUDENT = 1;
    static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public void InitList(){
        StudentList = new ArrayList<>();
        StudentList.add(new Student("SCHENKEL", "Stéphane", "Homme", "schenkel.stephane@gmail.com", new Date(), "SSINC", false));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(StudentList == null)
            InitList();

        addStudentButton = (Button)findViewById(R.id.AddStudentButton);
        listStudentButton = (Button)findViewById(R.id.ListStudentButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentFormActivity.class);
                startActivityForResult(intent, ADD_STUDENT);
            }
        });

        listStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode){
            case ADD_STUDENT:
                if(resultCode == 0)
                    Toast.makeText(MainActivity.this, "Student added to the list", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
