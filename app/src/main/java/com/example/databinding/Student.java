package com.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;


public class Student extends BaseObservable {
    String name;
    String family;
    String age;
    Drawable profileImage;



    public Student(String mName, String mFamily, String mAge ) {
        this.name = mName;
        this.family = mFamily;
        this.age = mAge;
    }

    public Student(String name, String family, String age, Drawable profileImage) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.profileImage = profileImage;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
        notifyPropertyChanged(BR.family);
    }
    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }


    @Bindable
    public Drawable getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Drawable profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

/*
    @BindingAdapter({"android:profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);

        // If you consider Picasso, follow the below
        // Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
    }*/

}
