package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFamily is a Querydsl query type for UserFamily
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserFamily extends EntityPathBase<UserFamily> {

    private static final long serialVersionUID = 1380691109L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFamily userFamily = new QUserFamily("userFamily");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath relation = createString("relation");

    public final QUser user;

    public QUserFamily(String variable) {
        this(UserFamily.class, forVariable(variable), INITS);
    }

    public QUserFamily(Path<? extends UserFamily> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFamily(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFamily(PathMetadata metadata, PathInits inits) {
        this(UserFamily.class, metadata, inits);
    }

    public QUserFamily(Class<? extends UserFamily> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

