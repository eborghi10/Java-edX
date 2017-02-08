package edu.galileo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObject {

    public static void main(String[] args) throws Exception {

        ObjectOutputStream output = null;

        UserProfile localProfile = new UserProfile(
                "Jaime",
                "jaimito@gmail.com",
                "Green",
                "Some other data"
        );

        //Serializable
        try {
            output = new ObjectOutputStream(
                    new FileOutputStream(
                            "userProfile.txt" ) );
            output.writeObject(localProfile);
        } finally {
            if (output != null){
                output.close();
            }
        }

        //Deserialize
        UserProfile restoredProfile;
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(
                    new FileInputStream(
                            "userProfile.txt" ) );
            restoredProfile = (UserProfile) input.readObject();
            System.out.println(restoredProfile);
        } finally {
            if (input != null){
                input.close();
            }
        }
    }
}


class UserProfile implements java.io.Serializable {
    private String name, email, themeColor;
    // "transient" for serializable object!!
    public transient String something;

    public UserProfile(String name, String email,
                       String themeColor, String something){
        this.name = name;
        this.email = email;
        this.themeColor = themeColor;
        this.something = something;
    }

    public String toString(){
        return "User: " + name +
                "\nEmail: " + email +
                "\nTheme Color: " + themeColor +
                "\nSomething (transient): " + something;
    }
}
