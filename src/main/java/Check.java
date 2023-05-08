import java.time.LocalDate;


public class Check {
    public static void main(String[] args) {
        CRUDsomebody cruDsomebody = new CRUDsomebody(DBConfig.getConnection());
        Student ivanov = new Student.Builder()
                .surname("ivanov")
                .name("ivan")
                .dateOfBirth(LocalDate.of(2000,12,20))
                .build();

        long m = System.currentTimeMillis();
        int id = cruDsomebody.add(ivanov).getId();


        System.out.println(cruDsomebody.findById(id).getSurname());




    }
}
