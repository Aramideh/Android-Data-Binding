package com.example.databinding;


import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity
        extends AppCompatActivity
        implements RecyclerViewAdapter.RecyclerViewItemClickListener{


    private ActivityMainBinding mainBinding;
    private Student mStudent;
    private MyClickHandlers handlers;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();


        // Initialize
        mStudent = new Student("","","");
        mainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        mainBinding.setStudent( mStudent );


        // Recycler View
        recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, populateData() , this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        //Click Handler
        handlers = new MyClickHandlers(this);
        mainBinding.setHandlers(handlers);
        handlers.setOnFabClickedListener(() -> Toast.makeText(this, "Doing Something.........", Toast.LENGTH_SHORT).show());

    }




    private List<Student> populateData() {

        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.usual_suspects);

        List<Student> students = new ArrayList<Student>();
        students.add( new Student("Bryan","Singer","12" ,  drawable) );
        students.add( new Student("Stephen","Baldwin","13" ,  drawable) );
        students.add( new Student("Gabriel","Byrne","14" ,  drawable) );
        students.add( new Student("Chazz","Palminteri","15" ,  drawable) );
        students.add( new Student("Kevin","Pollak","16" ,  drawable) );
        students.add( new Student("Pete","Postlethwaite","17" ,  drawable) );
        students.add( new Student("Kevin","Spacey","-1" ,  drawable) ); // because you are an idiot kevin! why would you do that?
        students.add( new Student("Suzy","Amis","18" ,  drawable) );
        students.add( new Student("Benicio","del Toro","19" ,  drawable) );
        students.add( new Student("Giancarlo","Esposito","20" ,  drawable) );
        students.add( new Student("John","Ottman","22" ,  drawable) );
        return students;
    }


    @Override
    public void onRecyclerItemClick(Student student) {
        mStudent.setName(student.name);
        mStudent.setFamily(student.family);
        mStudent.setAge(student.age);

    }

    public static class BindingUtils {
        public static String capitalize(String text) {
            return text.toUpperCase();
        }
    }

}

interface OnFabClickedListener {
    void onClick();
}
