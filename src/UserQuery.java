import java.util.ArrayList;
import java.util.Collections;

public class UserQuery {
    private String query;
    private ArrayList<String> keywords = new ArrayList();

    UserQuery (String query) {
        query = query.toLowerCase();
        Collections.addAll(keywords, query.split(" "));
        this.query = query;
    }

    @Override
    public boolean equals(Object o) { // TODO
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserQuery userQuery = (UserQuery) o;

        int size = Math.max(keywords.size(), userQuery.keywords.size());
        int count = 0;
        for (String entry : userQuery.keywords) {
            if (keywords.contains(entry)) {
                count++;
            }
        }

        double precision = count / (keywords.size() * 1.0);
        return precision >= 0.7;
    }

    @Override
    public int hashCode() {
        return query != null ? query.hashCode() : 0;
    }
}
