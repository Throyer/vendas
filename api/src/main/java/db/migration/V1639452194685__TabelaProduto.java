package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639452194685__TabelaProduto extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("produto")
                    .column("id", BIGINT.identity(true))
                    .column("codigo", VARCHAR(100).nullable(false))
                    .column("nome", VARCHAR(100).nullable(false))
                    .column("preco", DECIMAL(10, 2).nullable(false))
                .constraints(
                    primaryKey("id"))
                .execute();
        });
    }
}