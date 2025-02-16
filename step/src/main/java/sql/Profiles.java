package web;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Profiles {
    private String name;
    private String password;
    private String img;
    private int id;
    private List<Integer> liked;
    public Profiles(String name, String password, String  img, int id, List<Integer> liked) {
        this.name = name;
        this.password = password;
        this.img = img;
        this.id = id;
        this.liked = liked != null ? liked : new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getImg() {
        return img;
    }
    public List<Integer> getLiked() {
        return liked;
    }
    public int getId() {
        return id;
    }
    public void setLiked(int id) {
        if(!liked.contains(id)) {
            liked.add(id);
        }
    }
//    public void setDisLiked(int id) {
//        if (liked.contains(id)) {
//            liked.remove(id);
//        }
//    }
    @SneakyThrows
    public static Profiles fromResultSet(ResultSet rs) {
        String name = rs.getString("name");
        String password = rs.getString("password");
        String img = rs.getString("img");
        int id = rs.getInt("id");

        Integer[] likedArray = (Integer[]) rs.getArray("likedUsers").getArray();
        List<Integer> liked = likedArray != null ? new ArrayList<>(Arrays.asList(likedArray)) : new ArrayList<>();

        return new Profiles(name, password, img, id, liked);
    }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Profiles profile = (Profiles) obj;
            return id == profile.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

}

