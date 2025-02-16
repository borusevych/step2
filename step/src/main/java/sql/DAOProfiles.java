package web;

import java.io.IOException;
import java.util.List;

public class DAOProfiles implements DAO<Profiles> {
    @Override
    public void saveAll(List<Profiles> profiles) throws IOException {
        // отправка профилей на сервер (SQL)
    }
    @Override
    public List<Profiles> showAll() throws IOException {
        return List.of();
        // олучение профилей с сервера (SQL)
    }
}
