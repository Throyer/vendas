package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639452271655__TabelaVenda extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("venda")
                    .column("id", BIGINT.identity(true))
                    .column("data", TIMESTAMP.nullable(false))
                    .column("total", DECIMAL(10, 2).nullable(false))
                    .column("cliente_pf_id", BIGINT.nullable(true))
                    .column("cliente_pj_id", BIGINT.nullable(true))
                    .column("vendedor_id", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    constraint("venda_cliente_pf_fk").foreignKey("cliente_pf_id").references("cliente_pf", "id"),
                    constraint("venda_cliente_pj_fk").foreignKey("cliente_pj_id").references("cliente_pj", "id"))
                .execute();
        });
    }
}