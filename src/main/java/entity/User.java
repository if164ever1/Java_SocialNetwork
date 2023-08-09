package entity;

import entity.enums.ERole;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String name;
    private String username;
    private String lastName;
    private String email;
    private String bio;
    private String password;
    private final Set<ERole> role = new HashSet<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private LocalDateTime createdDate;

    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }
}