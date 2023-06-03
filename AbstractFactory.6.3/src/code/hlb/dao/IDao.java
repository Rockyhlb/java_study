package code.hlb.dao;

import code.hlb.factory.JdbcFactory;

import java.sql.SQLException;

public interface IDao {
    /**
     *在 Java 抽象工厂中，通常将增删查操作放在 DAO（Data Access Object）包下面，而实体类则放在 Entity 包下面。
     * 这是因为 DAO 是用于封装数据持久化操作的接口或者类，而 Entity 则代表了应用程序中的实际领域对象。
     *
     * DAO 层的代码主要负责与数据库进行交互，它具有独立于应用程序其他层级的特点。如果把增删查找等操作放到 Entity 包下面，
     * 那么就会导致代码耦合性较高，而且难以进行单元测试，因为需要涉及到对数据库的访问。
     *
     * 另外，将增删查操作放在 DAO 包下面也符合软件设计模式中的 SRP（Single Responsibility Principle 单一职责原则）。
     * 该原则要求一个类只负责完成一个功能，而将增删查等操作放在 DAO 包下面，可以让这些操作独立于业务逻辑，提高代码复用性和可维护性。
     *
     * 因此，一般情况下，建议将增删查操作放在 DAO 包下面，而将实体类放在 Entity 包下面。
     * */

    void add(JdbcFactory jdbcFactory) throws SQLException;
    void delete(JdbcFactory jdbcFactory) throws SQLException;
    void select(JdbcFactory jdbcFactorym,String select_sql) throws SQLException;
    void update(JdbcFactory jdbcFactory) throws SQLException;
}
