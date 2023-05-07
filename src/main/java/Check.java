import java.time.LocalDate;

public class Check {
    public static void main(String[] args) {
        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student( "ivanov", "ivan", LocalDate.of(2015, 02, 02));
      //  Student petrov = new Student(2, "petrov", "petr", LocalDate.of(2012, 02, 03));
        long m = System.currentTimeMillis();

     cruDsomebody.add(ivanov);
     Student addStudent = cruDsomebody.add(ivanov);

        System.out.println(addStudent.getId());

    }
}
