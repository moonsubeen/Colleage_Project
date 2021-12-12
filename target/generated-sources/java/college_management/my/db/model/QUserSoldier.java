package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserSoldier is a Querydsl query type for UserSoldier
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserSoldier extends EntityPathBase<UserSoldier> {

    private static final long serialVersionUID = -1095870367L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserSoldier userSoldier = new QUserSoldier("userSoldier");

    public final StringPath branch = createString("branch");

    public final StringPath classification = createString("classification");

    public final StringPath dischageDate = createString("dischageDate");

    public final StringPath joinDate = createString("joinDate");

    public final StringPath militaryNumber = createString("militaryNumber");

    public final StringPath ranks = createString("ranks");

    public final StringPath states = createString("states");

    public final StringPath type = createString("type");

    public final QUser user;

    public QUserSoldier(String variable) {
        this(UserSoldier.class, forVariable(variable), INITS);
    }

    public QUserSoldier(Path<? extends UserSoldier> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserSoldier(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserSoldier(PathMetadata metadata, PathInits inits) {
        this(UserSoldier.class, metadata, inits);
    }

    public QUserSoldier(Class<? extends UserSoldier> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

