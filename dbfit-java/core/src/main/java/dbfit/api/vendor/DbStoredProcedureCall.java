package dbfit.api.vendor;

import java.sql.SQLException;

import dbfit.fixture.StatementExecution;

public interface DbStoredProcedureCall {

    String getName();

    boolean isFunction();

    String toSqlString();

    StatementExecution toStatementExecution() throws SQLException;
}
