package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639451931488__TabelasDeCliente extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("cliente_pf")
                    .column("id", BIGINT.identity(true))
                    .column("codigo", VARCHAR(100).nullable(false))
                    .column("cpf", VARCHAR(100).nullable(false))
                    .column("nome", VARCHAR(100).nullable(false))
                    .column("rg", VARCHAR(100).nullable(false))
                    .column("usuario_id", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    constraint("cliente_pf_usuario").foreignKey("usuario_id").references("usuario", "id"))
                .execute();

            using(configuration)
                .createTableIfNotExists("cliente_pj")
                    .column("id", BIGINT.identity(true))
                    .column("codigo", VARCHAR(100).nullable(false))
                    .column("cnpj", VARCHAR(100).nullable(false))
                    .column("nome_fantasia", VARCHAR(100).nullable(false))
                    .column("razao_social", VARCHAR(100).nullable(false))
                    .column("usuario_id", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    constraint("cliente_pj_usuario").foreignKey("usuario_id").references("usuario", "id"))
                .execute();
        });
    }
}