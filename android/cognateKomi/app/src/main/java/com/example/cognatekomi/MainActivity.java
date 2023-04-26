package com.example.cognatekomi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

interface AdzuPeople {
    void introduce();

    void lesson();

    void scanID();
}

class Student implements AdzuPeople {
    String name;
    int age;
    int idNumber;
    String major;
    int year;

    public Student(String name, int age, int idNum, int year) {
        this.name = name;
        this.age = age;
        this.idNumber = idNum;
        this.year = year;
    }

    public void introduce() {
        Log.i("intro", "My name is " + name + " and I am " + age + " years old.");
    }

    @Override
    public void lesson() {
        Log.i("lesson", "I am now studying");
    }

    @Override
    public void scanID() {
        Log.i("scan", idNumber + " - " + name);
    }

}

class SITAO extends Student {
    String course;

    public SITAO(String name, int age, int idNum, int year, String course) {
        super(name, age, idNum, year);
        this.course = course;
    }
}

class EDUC extends Student {
    String major;

    public EDUC(String name, int age, int idNum, int year, String major) {
        super(name, age, idNum, year);
        this.major = major;
    }
}

class FS implements AdzuPeople {
    String name;
    int age;
    int idNumber;
    String office;
    boolean isFullTime;

    public FS(String name, int age, String office, int idNumber, boolean isft) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
        this.office = office;
        this.isFullTime = isft;
    }

    public void introduce() {
        Log.i("intro", "My name is " + name + " and I am " + age + " years old.");
    }

    @Override
    public void lesson() {
        Log.i("lesson", "I am working in " + office + " office");
    }

    @Override
    public void scanID() {
        Log.i("scan", idNumber + " - " + name);
    }

}

class Prof extends FS {
    String department;

    public Prof(String name, int age, String office, int idNumber, String department, boolean isft) {
        super(name, age, office, idNumber, isft);
        this.department = department;
    }
}

class Staff extends FS {
    int yearsOfService;

    public Staff(String name, int age, String office, int idNumber, boolean isft, int yearsOfService) {
        super(name, age, office, idNumber, isft);
        this.yearsOfService = yearsOfService;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SITAO sitao1 = new SITAO("JJJ", 21, 109321, 4, "BS IT");
        SITAO sitao2 = new SITAO("Juan Dela Cruz", 69, 124234, 3, "BS ECE");
        printSitao(sitao1);
        printSitao(sitao2);

        EDUC educ1 = new EDUC("Gio", 24, 13534, 4, "MATH");
        EDUC educ2 = new EDUC("John", 9, 234122, 3, "SCIENCE");
        printEduc(educ1);
        printEduc(educ2);

        Prof prof1 = new Prof("Gio Dims", 99, "CSIT", 69420, "CS", true);
        Prof prof2 = new Prof("Micah", 34, "CSIT", 123523, "CS", true);
        printProf(prof1);
        printProf(prof2);

        Staff staff1 = new Staff("Hart", 18, "OSA", 20321, true, 2);
        Staff staff2 = new Staff("Jeff", 18, "PPO", 324243, false, 1);
        printStaff(staff1);
        printStaff(staff2);

    }

    void printSitao(SITAO sitao) {
        Log.d("name: ", sitao.name);
        Log.d("age: ", sitao.age + " years old");
        Log.d("id: ", "id number: " + sitao.idNumber);
        Log.d("course and year: ", sitao.course + " " + sitao.year);
        sitao.introduce();
        sitao.lesson();
        sitao.scanID();
    }

    void printEduc(EDUC educ) {
        Log.d("name: ", educ.name);
        Log.d("age: ", educ.age + " years old");
        Log.d("id: ", "id number: " + educ.idNumber);
        Log.d("course and year: ", educ.major + " " + educ.year);
        educ.introduce();
        educ.lesson();
        educ.scanID();
    }

    void printProf(Prof prof) {
        Log.d("name: ", prof.name);
        Log.d("age: ", prof.age + " years old");
        Log.d("id: ", "id number: " + prof.idNumber);
        Log.d("office and dept: ", prof.office + " " + prof.department);
        if (prof.isFullTime) {
            Log.d("isft", "I am a full time employee in AdZU");
        } else {
            Log.d("isft", "I am a part-time employee in AdZU");
        }
        prof.introduce();
        prof.lesson();
        prof.scanID();
    }

    void printStaff(Staff staff) {
        Log.d("name: ", staff.name);
        Log.d("age: ", staff.age + " years old");
        Log.d("id: ", "id number: " + staff.idNumber);
        Log.d("office and years in service: ", staff.office + " " + staff.yearsOfService);
        if (staff.isFullTime) {
            Log.d("isft", "I am a full time employee in AdZU");
        } else {
            Log.d("isft", "I am a part-time employee in AdZU");
        }
        staff.introduce();
        staff.lesson();
        staff.scanID();
    }

}