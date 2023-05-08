import java.time.LocalDate;

public class Check {
    public static void main(String[] args) {
        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student("ivanov","ivan",LocalDate.of(2015,12,15));
        Student petrov = new Student("petrov","petr",LocalDate.of(2015,01,01));
        long m = System.currentTimeMillis();
        cruDsomebody.add(ivanov);
        cruDsomebody.add(petrov);
        cruDsomebody.update(ivanov);

       // int id = cruDsomebody.add(ivanov).getId();
       // cruDsomebody.update(ivanov);
      //  System.out.println(cruDsomebody.findById(id).getSurname());




    }
}
