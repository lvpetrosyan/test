public class UserService {
   private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user){
             return userDao.getUserByName(user.getName())!=null;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
