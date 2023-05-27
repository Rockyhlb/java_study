package code.hlb.dao;

import code.hlb.dao.IDao;

public class ScoresDao implements IDao {

    @Override
    public void add(){
        System.out.println("正在使用SqlLite的增加操作");
    }

    @Override
    public void delete(){
        System.out.println("正在使用SqlLite的删除操作");
    }

    @Override
    public void select(){
        System.out.println("正在使用SqlLite的删除操作");
    }

    @Override
    public void update(){
        System.out.println("正在使用SqlLite的更改操作");
    }
}
