package college_management.my.db.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureHistoryID is a Querydsl query type for LectureHistoryID
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLectureHistoryID extends BeanPath<LectureHistoryID> {

    private static final long serialVersionUID = 475213287L;

    public static final QLectureHistoryID lectureHistoryID = new QLectureHistoryID("lectureHistoryID");

    public final StringPath lecture = createString("lecture");

    public final StringPath student = createString("student");

    public QLectureHistoryID(String variable) {
        super(LectureHistoryID.class, forVariable(variable));
    }

    public QLectureHistoryID(Path<? extends LectureHistoryID> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureHistoryID(PathMetadata metadata) {
        super(LectureHistoryID.class, metadata);
    }

}

