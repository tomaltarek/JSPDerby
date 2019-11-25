package tomal.dao;



import java.util.List;

import tomal.entity.Users;

//why we are doing this ??
public interface UsersDAO {
List<Users> get();

boolean save(Users e);
boolean update(Users u, String s);
boolean delete(String s);

Users get(String u);
}
