package code.hlb.factory;

import code.hlb.dao.IDao;

public interface DataBaseFactory {

    // 创建不同类型的数据库对象
    IDao createDateBase();
}
