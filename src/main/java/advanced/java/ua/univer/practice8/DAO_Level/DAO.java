package advanced.java.ua.univer.practice8.DAO_Level;

import java.util.List;

public interface DAO <MyEntity,Key>{
     boolean create(MyEntity entity);
     List<MyEntity> findAll();
     MyEntity findEntityById(Key id);
     boolean update(MyEntity entity);
     boolean deleteById(Key id);
     boolean delete(MyEntity entity);


}
