package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
 * @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
 */
public class V1639525297749__TabelaItem extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("item")
                    .column("id", BIGINT.identity(true))
                    .column("quantidade", INTEGER.nullable(false))
                    .column("total", DECIMAL(10, 2).nullable(false))
                    .column("produto_id", BIGINT.nullable(false))
                    .column("venda_id", BIGINT.nullable(false))
                .constraints(
                    primaryKey("id"),
                    constraint("item_produto_fk").foreignKey("produto_id").references("produto", "id"),
                    constraint("item_venda_fk").foreignKey("venda_id").references("venda", "id"))
                .execute();
        });
    }
}