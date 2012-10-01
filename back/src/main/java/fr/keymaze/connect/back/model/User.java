package fr.keymaze.connect.back.model;

import fr.keymaze.connect.back.utils.KeyMazeException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String nickName;
    private String password;
    private Boolean isAdmin;
    private String email;
    private Integer maxHeartFrequency;
    private String familyName;
    private String name;

    public User() {

    }

    public User(String email, String password, String nickName) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.isAdmin = false;
    }

    public static String encodePassword(String password)
            throws KeyMazeException {
        // Réaliser hash SAH1 du password;
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA1");
            return password;
        } catch (NoSuchAlgorithmException e) {
            throw new KeyMazeException(e);
        }
    }

//	public static User connectUser(String email, String password) {
//		return User.find("byEmailAndPassword", email, password).first();
//	}

}
