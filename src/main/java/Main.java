public class Main {
    public static void main(String[] args) {
     //   User user=new User("Link5000_00@mail.ru","Link5000_00@mail.ru");
      //  System.out.println(user);
    UserDaoImpl dao=new UserDaoImpl();
    System.out.println(dao.getUserByName("don"));


    }
}
