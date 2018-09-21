package test.test.tp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import test.test.model.Student;

public class StudentInfoActivity extends AppCompatActivity {

    private Student currentStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_information);

        currentStudent = (Student)getIntent().getSerializableExtra(ListStudentActivity.STUDENT_EXTRA);

        SetInformations();
    }

    private void SetInformations(){
        TextView lastname = (TextView)findViewById(R.id.lastnameinfo);
        TextView firstname = (TextView)findViewById(R.id.firstnameinfo);
        TextView sex = (TextView)findViewById(R.id.sexinfo);
        TextView group = (TextView)findViewById(R.id.groupinfo);
        TextView redoublant = (TextView)findViewById(R.id.redoublantinfo);
        TextView birthday = (TextView)findViewById(R.id.birthdayinfo);
        TextView email = (TextView)findViewById(R.id.emailinfo);

        lastname.setText(currentStudent.getLastname());
        firstname.setText(currentStudent.getFirstname());
        sex.setText(currentStudent.getSexe());
        group.setText(currentStudent.getGroup());
        redoublant.setText(currentStudent.isRedoublant() ? "Oui" : "Non");
        birthday.setText(MainActivity.DATE_FORMAT.format(currentStudent.getBirthday()));
        email.setText(currentStudent.getEmail());
    }
}
