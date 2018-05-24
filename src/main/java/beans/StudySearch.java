package beans;
import beans.prototype.Category.ColumnName;

public class StudySearch {
	public static final String QUERY_GET = "select * from study";
	public static final String QUERY_POST = "INSERT INTO CATEGORY VALUES(seq.nextval, ?, ?)";
	public static final String QUERY_PUT = "UPDATE ";
	public static final String QUERY_DELETE = "DELETE ";
}

