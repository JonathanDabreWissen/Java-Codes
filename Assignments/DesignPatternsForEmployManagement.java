public class DesignPatternsForEmployManagement {
    

}


class EmployeeList implements Iterator{


    public int count = 0;
    public Employee[] employees = new Emplyee[100];
    public void add(Employee e){

        emplyees[count++] = e;
    }

    public boolean hasNext(){

        if(employees[count] != null){
            return true;
        }else{
            return false;
        }
    }
}

abstract class EmployeeFactory{

    
}