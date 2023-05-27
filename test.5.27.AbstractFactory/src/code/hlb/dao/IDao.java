package code.hlb.dao;

public interface IDao {

    abstract void add() throws ClassNotFoundException;
    abstract void delete();
    abstract void select();
    abstract void update();
}
