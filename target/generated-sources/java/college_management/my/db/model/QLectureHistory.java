package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureHistory is a Querydsl query type for LectureHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLectureHistory extends EntityPathBase<LectureHistory> {

    private static final long serialVersionUID = 1882056652L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLectureHistory lectureHistory = new QLectureHistory("lectureHistory");

    public final NumberPath<Integer> counts = createNumber("counts", Integer.class);

    public final StringPath evaluations = createString("evaluations");

    public final NumberPath<Integer> grades = createNumber("grades", Integer.class);

    public final QLectureHistoryID id;

    public final QLecture lecture;

    public final StringPath problems = createString("problems");

    public final StringPath ranks = createString("ranks");

    public final QStudent student;

    public QLectureHistory(String variable) {
        this(LectureHistory.class, forVariable(variable), INITS);
    }

    public QLectureHistory(Path<? extends LectureHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLectureHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLectureHistory(PathMetadata metadata, PathInits inits) {
        this(LectureHistory.class, metadata, inits);
    }

    public QLectureHistory(Class<? extends LectureHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QLectureHistoryID(forProperty("id")) : null;
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture"), inits.get("lecture")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

