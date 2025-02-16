package sql;

import web.Profiles;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreateProfilesDatabase {

    private final Connection connection;
    private DAO<Profiles> DAOProfiles;
    public CreateProfilesDatabase(Connection connection, DAO<Profiles> DAOProfiles) {
        this.connection = connection;
        this.DAOProfiles = DAOProfiles;
    }

    public void createUsers() throws IOException {
        List<Profiles> users = new ArrayList<>();
        Profiles user1 = new Profiles("Sasha", "https://www.vagabond.se/app/uploads/2021/06/YTo2OntzOjI6ImlkIjtpOjEyMjUyMTE7czoxOiJ3IjtpOjk4MDtzOjE6ImgiO2k6MzIwMDtzOjE6ImMiO2k6MDtzOjE6InMiO2k6MDtzOjE6ImsiO3M6NDA6ImU2YzAzYTk4NGVlY2FlM2VkZGEzZjliMzE3ZDU2MTU0MGRiYzNiMGIiO30.jpg", 1);
        Profiles user2 = new Profiles("Masha", "https://img.freepik.com/premium-photo/enchanting-elderly-indian-woman-traditional-saree-white-background_941493-1103.jpg", 2);
        Profiles user3 = new Profiles("Asia", "https://media.istockphoto.com/id/1375264815/ru/%D1%84%D0%BE%D1%82%D0%BE/%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D0%B0%D1%8F-%D0%B0%D1%84%D1%80%D0%BE-%D0%B6%D0%B5%D0%BD%D1%89%D0%B8%D0%BD%D0%B0.jpg?s=612x612&w=0&k=20&c=la6Efxe6nkexDUdQkEcIBtymyshqqHUhrNLwual_4kg=", 3);
        Profiles user4 = new Profiles("Vasia", "https://cs14.pikabu.ru/post_img/big/2022/04/16/8/1650117511157679557.jpg", 4);
        users.addAll(Arrays.asList(user1, user2, user3, user4));
        DAOProfiles.saveAll(users);
    }

    private static final String sql_delete =
            "DROP TABLE history;";

    private static final String sql_create_db = """
              CREATE TABLE IF NOT EXISTS history (
                  id SERIAL PRIMARY KEY,
                  line text,
                  at TIMESTAMP,
                  who text
              )
            """;

}