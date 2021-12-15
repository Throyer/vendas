package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639451282152__TabelaUsuario extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("usuario")
                    .column("id", BIGINT.identity(true))
                    .column("nome", VARCHAR(100).nullable(false))
                    .column("email", VARCHAR(100).nullable(false))
                    .column("senha", VARCHAR(100).nullable(false))
                    .column("ativo", BOOLEAN.nullable(false).defaultValue(true))
                    .column("permissao_id", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    constraint("usuario_permissao_fk").foreignKey("permissao_id").references("permissao", "id"))
                .execute();
        });
    }
}