import java.util.ArrayList;
import java.util.List;
abstract class Employee{
       private String name;
       private int id;
       public Employee(String name,int id){
           this.name=name;
           this.id =id;
       }

//      Achieve encapsulation using Getter and Setter
       public String getName(){
           return name;
       }
       public int getId(){
           return id;
       }
       public void setName(String name){
           this.name=name;
       }
       public void setId(int id){
           this.id=id;
       }


//       now Acheive Abstraction by using abstract class and methods (method can only declare)

       public abstract double calculateSalary();

       @Override
       public String toString(){
           return "Employee [name : "+name+", id : "+id+", salary : "+calculateSalary()+"]";
       }
    }

    class FullTimeEmployee extends Employee{
       private double monthlySalary;

       public FullTimeEmployee(String name ,int id,double monthlySalary){
           super(name,id);
           this.monthlySalary=monthlySalary;
       }
       @Override
       public double calculateSalary(){
        return monthlySalary;
       }
    }

    class PartTimeEmployee extends Employee{
       private int hoursWorked;
       private double hourlyrate;

       public PartTimeEmployee(String name,int id, int hoursWorked, double hourlyrate){
           super(name, id);
           this.hourlyrate=hourlyrate;
           this.hoursWorked=hoursWorked;
       }
        @Override
       public double calculateSalary(){
           return hoursWorked * hourlyrate;
       }
    }

    class PayrollSystem{
     private  List<Employee> employeeList;

     public PayrollSystem(){
         employeeList=new ArrayList<>();
     }
      public void addEmployee(Employee employee){
          employeeList.add(employee);
      }
      public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList) {
            if (employee.getId() == id){
                employeeToRemove = employee;
                break;
            }

        }
          if (employeeToRemove != null){
              employeeList.remove(employeeToRemove);
          }
      }

      public void DisplayEmployee(){
          for (Employee employee : employeeList) {
              System.out.println(employee);
          }
      }
    }

   public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rohit",1,70000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Amit",2,60000);
        PartTimeEmployee emp3 = new PartTimeEmployee("Harshal" ,3,50,200);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);

        System.out.println("intial Employee :");
        payrollSystem.DisplayEmployee();

        payrollSystem.removeEmployee(3);
        System.out.println("removing the Employee :");
        payrollSystem.DisplayEmployee();
    }
}