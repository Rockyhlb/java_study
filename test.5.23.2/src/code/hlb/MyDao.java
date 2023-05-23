package code.hlb;

public class MyDao implements IDao{

    @Override
    public void add(){
        System.out.println("正在使用Mysql的增加操作");
    }

    @Override
    public void delete(){
        System.out.println("正在使用Mysql的删除操作");
    }

    @Override
    public void select(){
        System.out.println("正在使用Mysql的删除操作");
    }

    @Override
    public void update(){
        System.out.println("正在使用Mysql的更改操作");
    }
}
