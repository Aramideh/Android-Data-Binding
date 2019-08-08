package com.example.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding.databinding.RecycleViewItemBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders> {

    Context context;
    List<Student> students;
    RecyclerViewItemClickListener listener;

    public RecyclerViewAdapter(Context context, List<Student> students , RecyclerViewItemClickListener listener) {
        this.context = context;
        this.students = students;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecycleViewItemBinding recycleViewItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()) , R.layout.recycle_view_item , viewGroup , false);

        return new RecyclerViewHolders(recycleViewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders recyclerViewHolders, final int i) {
            recyclerViewHolders.recycleViewItemBinding.setStudent(students.get(i));
            recyclerViewHolders.itemView.setOnClickListener(v -> listener.onRecyclerItemClick(students.get(i)));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }



    public class RecyclerViewHolders extends RecyclerView.ViewHolder{

        public final RecycleViewItemBinding recycleViewItemBinding;

        public RecyclerViewHolders(RecycleViewItemBinding recycleViewItemBinding ) {
            super( recycleViewItemBinding.getRoot());
            this.recycleViewItemBinding = recycleViewItemBinding;
        }

    }


    public interface  RecyclerViewItemClickListener{
        void onRecyclerItemClick(Student student);
    }


}
