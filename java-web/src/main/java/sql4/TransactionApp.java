package sql4;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionApp {

  @SneakyThrows
  void combineDefault(Connection conn) {
    // conn.setAutoCommit(true);
    PreparedStatement st1 = conn.prepareStatement("UPDATE 1...");
    PreparedStatement st2 = conn.prepareStatement("UPDATE 2...");

    st1.execute();
    // problem ???
    st2.execute();
  }

  @SneakyThrows
  void combineTransactionally(Connection conn) {
    PreparedStatement st1 = conn.prepareStatement("UPDATE 1...");
    PreparedStatement st2 = conn.prepareStatement("UPDATE 2...");

    conn.setAutoCommit(false);

    try {
      st1.execute();
      // problem: (Exception)
      st2.execute();
      conn.commit();
    } catch (Exception e) {
      conn.rollback();
    }

  }

  @SneakyThrows
  void transactionIsolation(Connection conn) {
    int isolation = conn.getTransactionIsolation();
//    Connection.TRANSACTION_NONE;
//    Connection.TRANSACTION_READ_UNCOMMITTED;
//    Connection.TRANSACTION_READ_COMMITTED;
//    Connection.TRANSACTION_REPEATABLE_READ;
//    Connection.TRANSACTION_SERIALIZABLE;
//    conn.setTransactionIsolation(???);
  }

}
