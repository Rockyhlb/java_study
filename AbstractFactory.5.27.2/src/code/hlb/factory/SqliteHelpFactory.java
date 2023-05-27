package code.hlb.factory;

import code.hlb.dao.IDao;
import code.hlb.dao.ScoresDao;

public class SqliteHelpFactory implements DataBaseFactory{

    @Override
    public IDao createDateBase() {
        return new ScoresDao();
    }
}
