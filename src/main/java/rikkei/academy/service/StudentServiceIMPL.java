package rikkei.academy.service;

import rikkei.academy.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    public static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1L, "Thu", "Yen Bai", 2));
        studentList.add(new Student(2L, "Chuan", "Ha Noi", 3));
        studentList.add(new Student(3L, "Yen", "Hai Duong", 4));
        studentList.add(new Student(4L, "Long", "Nam Dinh", 1));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(Long id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        if (findById(student.getId()) != null) {
            studentList.set(studentList.indexOf(findById(student.getId())), student);
        } else {
            studentList.add(student);
        }
    }

    @Override
    public void deleteById(Long id) {
        studentList.remove(findById(id));
    }
}
