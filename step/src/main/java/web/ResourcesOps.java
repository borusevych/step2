package web;

import java.net.URISyntaxException;

public class ResourcesOps {

    private static final boolean win = System.getProperty("os.name").toLowerCase().contains("win");

//    public static String dirUnsafe(String prefix) {
//        try {
//            String path = ResourcesOps.class
//                    .getClassLoader()
//                    .getResource(prefix)
//                    .toURI()
//                    .getPath();
//            return win ? path.substring(1) : path;
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
public static String dirUnsafe(String prefix) {
    try {
        var url = ResourcesOps.class.getClassLoader().getResource(prefix);
        if (url == null) {
            throw new RuntimeException("Resource not found: " + prefix);
        }
        String path = url.toURI().getPath();
        return win ? path.substring(1) : path;
    } catch (URISyntaxException e) {
        throw new RuntimeException(e);
    }
}

}
