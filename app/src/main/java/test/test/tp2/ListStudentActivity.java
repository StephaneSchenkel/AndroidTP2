package test.test.tp2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import test.test.adapter.ListStudentAdapter;
import test.test.model.Student;

public class ListStudentActivity extends ListActivity {

    static final String STUDENT_EXTRA = "SelectedStudent";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_student);
        setListAdapter(new ListStudentAdapter(ListStudentActivity.this, R.layout.list_student_row, MainActivity.StudentList));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Student student = (Student)getListView().getItemAtPosition(position);

        Intent intent = new Intent(ListStudentActivity.this, StudentInfoActivity.class);
        intent.putExtra(STUDENT_EXTRA, student);
        startActivity(intent);
    }
}
