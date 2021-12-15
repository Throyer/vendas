package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639451809915__TabelaFuncionario extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("funcionario")
                    .column("id", BIGINT.identity(true))
                    .column("codigo", VARCHAR(100).nullable(false))
                    .column("usuario_id", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    constraint("funcionario_usuario_fk").foreignKey("usuario_id").references("usuario", "id"))
                .execute();
        });
    }
}