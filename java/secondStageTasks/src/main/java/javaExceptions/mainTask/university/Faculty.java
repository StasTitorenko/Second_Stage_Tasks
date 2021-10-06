package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.LackOfFacultyException;
import javaExceptions.mainTask.exceptions.LackOfGroupException;
import javaExceptions.mainTask.featuredCategories.Faculties;

import java.util.List;

public class Faculty {
    private Faculties facultyName;
    private List<Group> groupList;

    public Faculty(Faculties facultyName, List<Group> groupList) {
        this.facultyName = facultyName;
        this.groupList = groupList;
        try {
            if (groupList.isEmpty()) {
                throw new LackOfGroupException("Faculty must have at least 1 group");
            }
        } catch (Exception e) {
            throw new LackOfGroupException("Faculty must have at least 1 group");
        }
    }

    public Faculties getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                ", groupList=" + groupList +
                '}';
    }
}
