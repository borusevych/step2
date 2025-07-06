package sql;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProfiles implements DAO<Profiles> {

    public final Connection connection;

    public DAOProfiles(Connection connection) {
        this.connection = connection;
    }


    @SneakyThrows
    @Override
    public void saveAll(List<Profiles> profiles) throws IOException {
        String sql = """
            INSERT INTO profiles (name, password, img, id, likedUsers) 
            VALUES (?, ?, ?, ?, ?)
        """;
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            for (Profiles profile : profiles) {
                st.setString(1, profile.getName());
                st.setString(2, profile.getPassword());
                st.setString(3, profile.getImg());
                st.setInt(4, profile.getId());

                Integer[] likedArray = profile.getLiked().toArray(new Integer[0]);
                Array sqlArray = connection.createArrayOf("INTEGER", likedArray);
                st.setArray(5, sqlArray);

                st.addBatch();
            }
            st.executeBatch();
        }
    }

    @SneakyThrows
    @Override
    public List<Profiles> showAll() {
        PreparedStatement st = connection.prepareStatement(
                """
                SELECT name, password, img, id, likedUsers 
                FROM profiles
                """
        );
        ResultSet rs = st.executeQuery();
        List<Profiles> profiles = new ArrayList<>();
        while (rs.next()) profiles.add(Profiles.fromResultSet(rs));
        return profiles;
    };


    @SneakyThrows
    @Override
    public void update(Profiles profile) throws IOException {
        String sql = """
            UPDATE profiles
            SET name = ?, img = ?, likedUsers = ?
            WHERE id = ?
        """;
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, profile.getName());
            st.setString(2, profile.getImg());

            Integer[] likedArray = profile.getLiked().toArray(new Integer[0]);
            Array sqlArray = connection.createArrayOf("INTEGER", likedArray);
            st.setArray(3, sqlArray);

            st.setInt(4, profile.getId());
            st.execute();
        }
    }
}
