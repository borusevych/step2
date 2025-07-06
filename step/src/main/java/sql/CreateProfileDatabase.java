package sql;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreateProfileDatabase {

    private Connection connection;
    private DAO<Profiles> DAOProfiles;
    public CreateProfileDatabase(Connection connection, DAO<Profiles> DAOProfiles) {
        this.connection = connection;
        this.DAOProfiles = DAOProfiles;
    }

    private static final String sql_delete =
            "DROP TABLE IF EXISTS profiles;";

    private static final String sql_create_db = """
              CREATE TABLE IF NOT EXISTS profiles (
                  name text,
                  password text,
                  img text,
                  id SERIAL PRIMARY KEY,
                  likedUsers INTEGER[]
              )
            """;

    @SneakyThrows
    public void createDataBase(Connection connection) {
        this.connection = connection;
        PreparedStatement st = connection.prepareStatement(sql_create_db);
        st.execute();
    }
    @SneakyThrows
    public void deleteDataBase(Connection connection) {
        this.connection = connection;
        PreparedStatement st = connection.prepareStatement(sql_delete);
        st.execute();
    }
    public void createProfiles(Connection connection) throws IOException {
        deleteDataBase(connection);
        createDataBase(connection);
        List<Profiles> users = new ArrayList<>();
        Profiles user1 = new Profiles("Sasha", "Sasha","https://www.vagabond.se/app/uploads/2021/06/YTo2OntzOjI6ImlkIjtpOjEyMjUyMTE7czoxOiJ3IjtpOjk4MDtzOjE6ImgiO2k6MzIwMDtzOjE6ImMiO2k6MDtzOjE6InMiO2k6MDtzOjE6ImsiO3M6NDA6ImU2YzAzYTk4NGVlY2FlM2VkZGEzZjliMzE3ZDU2MTU0MGRiYzNiMGIiO30.jpg", 1, null);
        Profiles user2 = new Profiles("Masha", "Masha", "https://img.freepik.com/premium-photo/enchanting-elderly-indian-woman-traditional-saree-white-background_941493-1103.jpg", 2, null);
        Profiles user3 = new Profiles("Asia", "Asia", "https://media.istockphoto.com/id/1375264815/ru/%D1%84%D0%BE%D1%82%D0%BE/%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D0%B0%D1%8F-%D0%B0%D1%84%D1%80%D0%BE-%D0%B6%D0%B5%D0%BD%D1%89%D0%B8%D0%BD%D0%B0.jpg?s=612x612&w=0&k=20&c=la6Efxe6nkexDUdQkEcIBtymyshqqHUhrNLwual_4kg=", 3, null);
        Profiles user4 = new Profiles("Vasia", "Vasia","https://www.nicknotas.com/wp-content/uploads/2023/08/most-interesting-person-in-the-world-1024x683.webp", 4, null);
        users.addAll(Arrays.asList(user1, user2, user3, user4));
        DAOProfiles.saveAll(users);
    }
}