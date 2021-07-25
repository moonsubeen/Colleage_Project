package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureAttendance is a Querydsl query type for LectureAttendance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLectureAttendance extends EntityPathBase<LectureAttendance> {

    private static final long serialVersionUID = 1793094833L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLectureAttendance lectureAttendance = new QLectureAttendance("lectureAttendance");

    public final StringPath attendance = createString("attendance");

    public final StringPath day = createString("day");

    public final QLecture lecture;

    public final StringPath month = createString("month");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final QStudent student;

    public QLectureAttendance(String variable) {
        this(LectureAttendance.class, forVariable(variable), INITS);
    }

    public QLectureAttendance(Path<? extends LectureAttendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLectureAttendance(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLectureAttendance(PathMetadata metadata, PathInits inits) {
        this(LectureAttendance.class, metadata, inits);
    }

    public QLectureAttendance(Class<? extends LectureAttendance> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture"), inits.get("lecture")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

