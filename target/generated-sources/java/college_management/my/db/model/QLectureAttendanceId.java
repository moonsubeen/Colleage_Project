package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureAttendanceId is a Querydsl query type for LectureAttendanceId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLectureAttendanceId extends BeanPath<LectureAttendanceId> {

    private static final long serialVersionUID = 882251180L;

    public static final QLectureAttendanceId lectureAttendanceId = new QLectureAttendanceId("lectureAttendanceId");

    public final StringPath lecture = createString("lecture");

    public final StringPath student = createString("student");

    public QLectureAttendanceId(String variable) {
        super(LectureAttendanceId.class, forVariable(variable));
    }

    public QLectureAttendanceId(Path<? extends LectureAttendanceId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureAttendanceId(PathMetadata metadata) {
        super(LectureAttendanceId.class, metadata);
    }

}

