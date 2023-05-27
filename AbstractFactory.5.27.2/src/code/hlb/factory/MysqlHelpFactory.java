package code.hlb.factory;

import code.hlb.dao.IDao;
import code.hlb.dao.StudentsDao;

public class MysqlHelpFactory implements DataBaseFactory{

    @Override
    public  IDao createDateBase() {
        return new StudentsDao();
    }
}
