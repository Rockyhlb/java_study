package code.hlb.entity;

import code.hlb.dao.IDao;

public interface IVal {

    // entity 包中的类和接口可能是用于实现某些特定行为和属性的组件，用于构建更大型的应用程序和系统
    // 无论是利用MySQL还是Sqlite方案，都避免不了对数据的 增、删、查、改 基本操作，因此可以定义一个接口减少代码的冗杂
    void add(IDao dataBase);
    void delete(IDao dataBase);
    void select(IDao dataBase);
    void update(IDao dataBase);
}
