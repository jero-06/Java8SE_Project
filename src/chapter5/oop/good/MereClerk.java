package chapter5.oop.good;
/* 평사원 클래스 */
public class MereClerk extends Employee {
    String name;
    double salary;
    
    public MereClerk (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
        super(name,salary):
    }
    
    public void manageSalary(double rate) {
        salary = salary + salary*(rate/100);
    }
}
