package test.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.test.model.Student;
import test.test.tp2.R;

public class ListStudentAdapter extends ArrayAdapter<Student> {

    private List<Student> list;
    private Context context;
    private int resource;

    public ListStudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        list = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = list.get(position);

        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resource, null);
        }

        if(student != null){
            TextView fullname = (TextView)v.findViewById(R.id.FullName);

            if(fullname != null)
                fullname.setText(student.getLastname() + " " + student.getFirstname());
        }

        return v;
    }
}
