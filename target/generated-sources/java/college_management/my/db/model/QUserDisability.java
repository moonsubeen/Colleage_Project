package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDisability is a Querydsl query type for UserDisability
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserDisability extends EntityPathBase<UserDisability> {

    private static final long serialVersionUID = 630283677L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserDisability userDisability = new QUserDisability("userDisability");

    public final StringPath disability = createString("disability");

    public final StringPath document = createString("document");

    public final StringPath state = createString("state");

    public final QUser user;

    public QUserDisability(String variable) {
        this(UserDisability.class, forVariable(variable), INITS);
    }

    public QUserDisability(Path<? extends UserDisability> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserDisability(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserDisability(PathMetadata metadata, PathInits inits) {
        this(UserDisability.class, metadata, inits);
    }

    public QUserDisability(Class<? extends UserDisability> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

