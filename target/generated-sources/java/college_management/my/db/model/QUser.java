package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1959072225L;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final StringPath birthdate = createString("birthdate");

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath nationality = createString("nationality");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath pwd = createString("pwd");

    public final StringPath residentNumber = createString("residentNumber");

    public final EnumPath<college_management.my.api.config.Permission> role = createEnum("role", college_management.my.api.config.Permission.class);

    public final StringPath sex = createString("sex");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

