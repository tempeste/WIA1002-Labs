/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author RAVEN
 */
public class Course implements Comparable<Course> {
    private String code;
    private String name;
    private int credit;
    private String grade;

    public Course(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade.toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }
    
    public int getPoint(){
        switch(grade.toUpperCase()){
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                 return 2;
            case "D":
                return 1;
            case "F":
                return 0;
            default:
                return -1;
        }
    }
    
    public String toString(){
        String output = String.format("Course: %s (%s) - %d credit hours. Grade: %s", code, name, credit, grade);
        return output;
    }
    
    @Override
    public int compareTo(Course o) {
        if(!o.getCode().equals(code)){
            return -1;
        }else if(!o.getName().equals(name)){
            return -1;
        }else if(o.getCredit() != (credit)){
            return -1;
        }else if(!o.getGrade().equals(grade)){
            return -1;
        }else{
            return 0;
        }
    }
    
}
